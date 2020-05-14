class MinHeap {
    private int currentSize;
    private HeapNode[] treeOfHeapNodes;
    int[] indexes; //will be used to decrease the distance

    //constructor
    MinHeap() {
        treeOfHeapNodes = new HeapNode[Constants.CAPACITY + 1];
        indexes = new int[Constants.CAPACITY];
        treeOfHeapNodes[0] = new HeapNode();
        treeOfHeapNodes[0].distance = Integer.MIN_VALUE;
        treeOfHeapNodes[0].vertex = -1; //init the source vertex to -1
        setCurrentSize(0);
    }


    //Add the element at the bottom leaf of the Heap.
    void insert(HeapNode x) {
        setCurrentSize(getCurrentSize()+1);
        int currentElement = getCurrentSize(); // declare and init currentElement as currentSize.
        treeOfHeapNodes[currentElement] = x; // the HeapNode[] element of the moment is equal to incoming HeapNode
        indexes[x.vertex] = currentElement; // id of vertex x is set to currentElement.
        bubbleUp(currentElement);
    }

    // If inserted element is smaller than its parent node
    // swap the element with its parent.
    //Keep repeating the above step, if node reaches its correct position, STOP.
    void bubbleUp(int currentPosition) {
        int parentElement = currentPosition / 2; //Define middle of range
        //int currentElement = currentPosition; //Vertex id
        //Conditions: Given vertex id greater than 0, distance of heap node at middle of range greater than distance of current node
        //If the parents distance is bigger then current distance, swap by MIN heap rules
        while (currentPosition > 0 && treeOfHeapNodes[parentElement].distance > treeOfHeapNodes[currentPosition].distance) {
            HeapNode currentNode = treeOfHeapNodes[currentPosition]; //Set current node to whatever index currentElement is currently.
            HeapNode parentNode = treeOfHeapNodes[parentElement]; //Set parentNode to whatever index parentElement is currently.
            //Swap the positions
            indexes[currentNode.vertex] = parentElement;
            indexes[parentNode.vertex] = currentPosition;

            swap(currentPosition, parentElement);
            currentPosition = parentElement;
            parentElement = parentElement / 2;
        }
    }
    // Take out the element from the root
    //Take out the last element from the last level from the heap and replace the root with the element.
    //place the element in right place with sinkDown
    HeapNode extractMin() {
        HeapNode min = treeOfHeapNodes[1]; //Min is set to whatever the second element in the heap array holds.
        HeapNode lastNode = treeOfHeapNodes[getCurrentSize()]; //Min is set to whatever the last element in the heap array holds.

        //Update the indexes[] and move the last node to the top
        indexes[lastNode.vertex] = 1;
        treeOfHeapNodes[1] = lastNode;
        treeOfHeapNodes[getCurrentSize()] = null;
        //Call sink down to move element downwards in the heap
        sinkDown(1);
        setCurrentSize(getCurrentSize()-1);
        return min;
    }
    // If replaced element is greater than any of its child node
    //swap the element with its smallest child
    //Tar bort det minsta talet i trädet!!!
    void sinkDown(int k) {
        int smallest = k;
        int leftChildIdX = 2 * k;
        int rightChildIdX = 2 * k + 1;
        //Conditions: id of left child is smaller than heap size, node with shortest distance is greater than the distance of left child
        if (leftChildIdX < getCurrentSize() && treeOfHeapNodes[smallest].distance > treeOfHeapNodes[leftChildIdX].distance) {
            smallest = leftChildIdX; //the smallest distance is now whatever left child holds currently.
        }
        //Conditions: id of right child is smaller than heap size, node with shortest distance is greater than right node distance
        if (rightChildIdX < getCurrentSize() && treeOfHeapNodes[smallest].distance > treeOfHeapNodes[rightChildIdX].distance) {
            smallest = rightChildIdX; //the smallest distance is now whatever right child holds currently.
        }
        //If the shortest distance is not same as input value, update values and call method recursively.
        if (smallest != k) {
            HeapNode smallestNode = treeOfHeapNodes[smallest];
            HeapNode kNode = treeOfHeapNodes[k];
            //swap the positions
            indexes[smallestNode.vertex] = k;
            indexes[kNode.vertex] = smallest;
            swap(k, smallest);
            sinkDown(smallest); //recursive
        }
    }

    private void swap(int a, int b) {
        HeapNode temp = treeOfHeapNodes[a];
        treeOfHeapNodes[a] = treeOfHeapNodes[b];
        treeOfHeapNodes[b] = temp;
    }

    boolean isEmpty() {
        return currentSize == 0;
    }

    int getCurrentSize() {
        return currentSize;
    }

    private void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    HeapNode[] getTreeOfHeapNodes() {
        return treeOfHeapNodes;
    }

    private void setTreeOfHeapNodes(HeapNode[] treeOfHeapNodes) {
        this.treeOfHeapNodes = treeOfHeapNodes;
    }
}


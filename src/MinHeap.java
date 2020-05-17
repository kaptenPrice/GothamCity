/**
 * This class manages the min heap.
 */
class MinHeap {
    private int currentSize;
    int currentElement;
    private HeapNode[] treeOfHeapNodes;
    int[] indexes;

    /**
     * Constructor. Initializes the first heap node in treeOfHeapNodes.
     */
    MinHeap() {
        treeOfHeapNodes = new HeapNode[Constants.CAPACITY + 1];
        indexes = new int[Constants.CAPACITY];
        treeOfHeapNodes[0] = new HeapNode();
        treeOfHeapNodes[0].setDistance(Integer.MIN_VALUE);
        treeOfHeapNodes[0].setVertex(-1);
        setCurrentSize(0);
    }

    /**
     * Add the heapNode at the bottom leaf of the heap, determined by the current size of the heap.
     * Call bubbleUp to set it at the correct position.
     *
     * @param heapNode heap node to be inserted.
     */
    void insert(HeapNode heapNode) {
        setCurrentSize(getCurrentSize()+1);
        currentElement = getCurrentSize();
        treeOfHeapNodes[currentElement] = heapNode;
        indexes[heapNode.getVertex()] = currentElement;
        bubbleUp(currentElement);
    }


    /**
     *  Conditions: Given vertex id greater than 0, distance of heap node at middle of range greater than distance of current node.
     *  Set current node to whatever index currentElement is currently. Set parentNode to whatever index parentElement is currently.
     *  Repeat as long as above conditions are fulfilled.
     *
     * @param currentPosition current position to be updated.
     */
    void bubbleUp(int currentPosition) {
        int parentElement = currentPosition / 2;

        while (currentPosition > 0 && treeOfHeapNodes[parentElement].getDistance() > treeOfHeapNodes[currentPosition].getDistance()) {
            HeapNode currentNode = treeOfHeapNodes[currentPosition];
            HeapNode parentNode = treeOfHeapNodes[parentElement];

            indexes[currentNode.getVertex()] = parentElement;
            indexes[parentNode.getVertex()] = currentPosition;

            swap(currentPosition, parentElement);
            currentPosition = parentElement;
            parentElement = parentElement / 2;
        }
    }


    /**
     *  This method takes out the element from the root, takes out the last element from the last level in the heap and replaces the root with the element.
     *  Updates the indexes[] and moves the last node to the top.
     *  Calls sinkDown to place the element in right place.
     *
     * @return min the extracted node.
     */
    HeapNode extractMin() {
        HeapNode min = treeOfHeapNodes[1];
        HeapNode lastNode = treeOfHeapNodes[getCurrentSize()];

        indexes[lastNode.getVertex()] = 1;
        treeOfHeapNodes[1] = lastNode;
        treeOfHeapNodes[getCurrentSize()] = null;

        sinkDown(1);
        setCurrentSize(getCurrentSize()-1);
        return min;
    }


    /**
     * Structures the heap into branches based on the conditions of two different if statements,
     * determining if the node should be in the left or the right branch.
     * Recursively calls itself until smallest and k are same.
     * Will result in removing the extracted min from the heap.
     *
     * @param k index to be sunk down.
     */
    void sinkDown(int k) {
        int smallest = k;
        int leftChildIdX = 2 * k;
        int rightChildIdX = 2 * k + 1;

        if (leftChildIdX < getCurrentSize() && treeOfHeapNodes[smallest].getDistance() > treeOfHeapNodes[leftChildIdX].getDistance()) {
            smallest = leftChildIdX;
        }

        if (rightChildIdX < getCurrentSize() && treeOfHeapNodes[smallest].getDistance() > treeOfHeapNodes[rightChildIdX].getDistance()) {
            smallest = rightChildIdX;
        }

        if (smallest != k) {
            HeapNode smallestNode = treeOfHeapNodes[smallest];
            HeapNode kNode = treeOfHeapNodes[k];
            indexes[smallestNode.getVertex()] = k;
            indexes[kNode.getVertex()] = smallest;
            swap(k, smallest);
            sinkDown(smallest);
        }
    }

    /**
     * Swaps a and b.
     *
     * @param a position a.
     * @param b position b.
     */
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


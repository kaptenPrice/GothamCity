import java.util.LinkedList;

/**
 * This class contains methods related to calculating the shortest path using Dijkstra's algorithm.
 * */
class Dijkstra {
    private int source;
    private HeapNode[] arrayOfHeapNodes;
    private MinHeap minHeap;

/**
 * This method calculates the shortest distance between the source (user input) and all nodes.
 *
 * @param graph graph that contains the nodes and edges used in the calculation.
 * @param source user defined source node from which the distance is calculated to all other nodes.
 * @return HeapNode[] an array of heap nodes that contains the result set of shortest distance between source and all other nodes.
 * */
    HeapNode[] dijkstraGetMinDistance(Graph graph, int source) {
        setSource(source);
        boolean[] isVisited = new boolean[Constants.NUMBER_OF_VERTICES];
        setArrayOfHeapNodes(createArrayOfHeapNodes());
        //decrease the distance for the first index
        getArrayOfHeapNodes()[getSource()].setDistance(0);
        setMinHeap(createMinHeap());

        while (!getMinHeap().isEmpty()) {
            //Extract the min
            HeapNode extractedNode = getMinHeap().extractMin();
            //Extract vertex
            int currentRoot = extractedNode.getVertex();
            isVisited[currentRoot] = true;
            //iterate through all the adjacent vertices
            LinkedList<Edge> listOfEdges = graph.adjacentVerticesList[currentRoot];
            for (Edge edge : listOfEdges) {
                int destination = edge.destination;

                if (!isVisited[destination]) {
                    //Check if distance need update or not
                    //means check total weight from source to vertex_V is
                    //less then the current distance value, if yes then update the distance
                    int newWeight = getArrayOfHeapNodes()[currentRoot].getDistance() + edge.weight;
                    int currentWeight = getArrayOfHeapNodes()[destination].getDistance();
                    if (currentWeight > newWeight) {
                        decreaseWeight(getMinHeap(), newWeight, destination);
                        getArrayOfHeapNodes()[destination].setDistance(newWeight);
                    }
                }
            }
        }

        return getArrayOfHeapNodes();
    }

    /**
     * Creates and returns an array of heap nodes (containing vertex and distance).
     * Each node is filled in with vertex id (0-9) and distance (integer's max value).
     *
     * @return HeapNode[] array of heap nodes
     * */
    HeapNode[] createArrayOfHeapNodes() {
        arrayOfHeapNodes = new HeapNode[Constants.NUMBER_OF_VERTICES];
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            arrayOfHeapNodes[i] = new HeapNode();
            arrayOfHeapNodes[i].setVertex(i);
            arrayOfHeapNodes[i].setDistance(Integer.MAX_VALUE);
        }
        return arrayOfHeapNodes;
    }

    /**
     *
     *
     * @return MinHeap
     * */
    MinHeap createMinHeap() {
        setMinHeap(new MinHeap());
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            getMinHeap().insert(arrayOfHeapNodes[i]);
        }
        return getMinHeap();
    }

    //minheap has to be sent into the method in order for the method to get the correct heap.
    private void decreaseWeight(MinHeap minHeap, int newWeight, int vertex) {
        //get the index which distance needs to decrease
        int index = getMinHeap().indexes[vertex];
        //get the node and update its value
        HeapNode node = getMinHeap().getTreeOfHeapNodes()[index];
        node.setDistance(newWeight);
        getMinHeap().bubbleUp(index);
    }

    void setSource(int source) {
        this.source = source;
    }

    int getSource() {
        return source;
    }

    MinHeap getMinHeap() {
        return minHeap;
    }

    void setMinHeap(MinHeap minHeap) {
        this.minHeap = minHeap;
    }

    HeapNode[] getArrayOfHeapNodes() {
        return arrayOfHeapNodes;
    }

    void setArrayOfHeapNodes(HeapNode[] arrayOfHeapNodes) {
        this.arrayOfHeapNodes = arrayOfHeapNodes;
    }

}

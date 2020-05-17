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
 * The array of booleans isVisited[] keeps track of what vertices have been visited. Every time a node has been extracted and used as root, it is marked as visited (true).
 * Calling createArrayOfHeapNodes to get a heap node array to work with.
 * The source node's distance is set to 0 by default and is also the first vertex to be visited.
 * Calling createArrayOfHeapNodes to get a heap to work with.
 *
 * @param graph graph that contains the nodes and edges used in the calculation.
 * @param source user defined source node from which the distance is calculated to all other nodes.
 * @return HeapNode[] an array of heap nodes that contains the result set of shortest distance between source and all other nodes.
 * */
    HeapNode[] dijkstraGetMinDistance(Graph graph, int source) {
        setSource(source);
        boolean[] isVisited = new boolean[Constants.NUMBER_OF_VERTICES];
        setArrayOfHeapNodes(createArrayOfHeapNodes());
        getArrayOfHeapNodes()[getSource()].setDistance(0);
        setMinHeap(createMinHeap());

        while (!getMinHeap().isEmpty()) {
            HeapNode extractedNode = getMinHeap().extractMin();
            int currentRoot = extractedNode.getVertex();
            isVisited[currentRoot] = true;
            LinkedList<Edge> listOfEdges = graph.adjacentVerticesList[currentRoot];
            for (Edge edge : listOfEdges) {
                int destination = edge.destination;

                //Check if distance needs to update or not, i.e. check if total distance from source to vertex is
                //less then the current distance value, if yes then update the distance.
                if (!isVisited[destination]) {
                    int newDistance = getArrayOfHeapNodes()[currentRoot].getDistance() + edge.distance;
                    int currentDistance = getArrayOfHeapNodes()[destination].getDistance();
                    if (currentDistance > newDistance) {
                        decreaseDistance(getMinHeap(), newDistance, destination);
                        getArrayOfHeapNodes()[destination].setDistance(newDistance);
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
     * Creates and returns a new MinHeap and calls insert() to insert the heap nodes
     * created in createArrayOfHeapNodes into the heap.
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

    /**
     * Updates the distance to the current destination vertex.
     * Calls bubbleUp to update the position in the heap.
     * Minheap has to be sent into the method in order for the method to get the correct heap version.
     *
     * @param minHeap current version of the heap.
     * @param newDistance new distance to be set.
     * @param destinationVertex defines what index the new distance should be set at.
     * */
    private void decreaseDistance(MinHeap minHeap, int newDistance, int destinationVertex) {
        int index = getMinHeap().indexes[destinationVertex];
        HeapNode node = getMinHeap().getTreeOfHeapNodes()[index];
        node.setDistance(newDistance);
        getMinHeap().bubbleUp(index);
    }



    private void setSource(int source) {
        this.source = source;
    }

    private int getSource() {
        return source;
    }

    private MinHeap getMinHeap() {
        return minHeap;
    }

    private void setMinHeap(MinHeap minHeap) {
        this.minHeap = minHeap;
    }

    private HeapNode[] getArrayOfHeapNodes() {
        return arrayOfHeapNodes;
    }

    private void setArrayOfHeapNodes(HeapNode[] arrayOfHeapNodes) {
        this.arrayOfHeapNodes = arrayOfHeapNodes;
    }

}

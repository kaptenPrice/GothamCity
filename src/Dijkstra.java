import java.util.LinkedList;

class Dijkstra {
    private Utility utility = new Utility();
    private Graph graph;
    private int source;
    private HeapNode[] arrayOfHeapNodes;
    private MinHeap minHeap;



     HeapNode[] dijkstraGetMinDistance(Graph graph, int source) {
        setSource(source);
        boolean[] isVisited = new boolean[Constants.NUMBER_OF_VERTICES];
        setArrayOfHeapNodes(createArrayOfHeapNodes());
        //decrease the distance for the first index
        getArrayOfHeapNodes()[getSource()].distance = 0;
        setMinHeap(createMinHeap());

        //while minHeap is not empty
         while (!getMinHeap().isEmpty()) {
             if (graph==null){
                 return null;
             }
            //Extract the min
            HeapNode extractedNode = getMinHeap().extractMin();
            //Extract vertex
            int currentRoot = extractedNode.vertex;
            isVisited[currentRoot] = true;
            //iterate through all the adjacent vertices
            LinkedList<Edge> listOfEdges = graph.adjacentVerticesList[currentRoot];
            for (Edge edge : listOfEdges) {
                int destination = edge.destination;
                //Only if destination vertex is not present in isVisited
                if (!isVisited[destination]) {
                    //Check if distance need update or not
                    //means check total weight from source to vertex_V is
                    //less then the current distance value, if yes then update the distance
                    int newWeight = getArrayOfHeapNodes()[currentRoot].distance + edge.weight;
                    int currentWeight = getArrayOfHeapNodes()[destination].distance;
                    if (currentWeight > newWeight) {
                        decreaseWeight(getMinHeap(), newWeight, destination);
                        getArrayOfHeapNodes()[destination].distance = newWeight;
                    }
                }
            }
        }

        return getArrayOfHeapNodes();
    }

    private HeapNode[] createArrayOfHeapNodes() {
      arrayOfHeapNodes = new HeapNode[Constants.NUMBER_OF_VERTICES];
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            arrayOfHeapNodes[i] = new HeapNode();
            arrayOfHeapNodes[i].vertex = i;
            arrayOfHeapNodes[i].distance = Integer.MAX_VALUE;
        }
        return arrayOfHeapNodes;
    }

    private MinHeap createMinHeap() {
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
        //HeapNode node = getMinHeap().treeOfHeapNodes[index];
        HeapNode node = getMinHeap().getTreeOfHeapNodes()[index];
        node.distance = newWeight;
        getMinHeap().bubbleUp(index);
    }

/*
    void checkIfNodesAreConnected(HeapNode[] resultSet) {
        System.out.println("Walking in the checkIfNodesAreConnected line");
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            if (resultSet[i].distance < 0 || resultSet[i].distance > 100) {
                System.out.println("Not a coherent graph, printing a new one");

                RandomGraphMaker randomGraphMaker = new RandomGraphMaker();
                graph = randomGraphMaker.setGraph();
                randomGraphMaker.secureGraphNodesAreUnique(graph);
                dijkstraGetMinDistance(graph, getSource());
                utility.printGraph(graph);
            }
        }
    }*/

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

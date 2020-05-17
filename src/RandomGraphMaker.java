/**
 * This class creates and validates random connections and distances.
 */
class RandomGraphMaker {
    private Dijkstra getMinDistance = new Dijkstra();
    Utility utility = new Utility();
    Graph graph;

    /**
     * Keeps creating new graphs until an acceptable graph is created.
     *
     * @return graph the accepted graph.
     */
    Graph createNewGraph() {
        graph = setGraph();
        while (!secureGraphNodesAreUnique(graph) || !checkIfGraphIsCoherent(countWeightBetweenNodes(graph))) {
            graph = setGraph();
        }

        utility.printGraph(graph);
        return graph;
    }

    /**
     * Provides data for the graph. Makes sure each node is connected to 2 or 3 other nodes and that vertex and neighbour are not the same.
     *
     * @return graph
     */
    Graph setGraph() {
        graph = new Graph();

        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            while (graph.adjacentVerticesList[i].size() < 2) {
                int newNeighbour = (int) ((Math.random() * 10));
                int randomWeight = (int) ((Math.random() * 10) + 1);

                if (graph.adjacentVerticesList[i].size() < 3 &&
                        graph.adjacentVerticesList[newNeighbour].size() < 3 && graph.adjacentVerticesList[i] != graph.adjacentVerticesList[newNeighbour]) {
                    graph.addEdge(i, newNeighbour, randomWeight);
                }
            }
        }
         return graph;
    }

    /**
     * Ensure that each vertex's neighbours are not repeated.
     *
     * @param graph random graph to be validated.
     * @return true/false depending on if the graph is acceptable or not.
     */
    boolean secureGraphNodesAreUnique(Graph graph) {
      this.graph=graph;
        if (graph==null) {
            graph = setGraph();
        }
        for (int i = 0; i < graph.adjacentVerticesList.length; i++) {
            int firstElement = 0;
            int lastElement = graph.adjacentVerticesList[i].size() - 1;

            for (int j = 0; j < lastElement; j++) {

                if (graph.adjacentVerticesList[i].get(j).destination == graph.adjacentVerticesList[i].get(j + 1).destination) {
                    return false;
                }

                if (graph.adjacentVerticesList[i].size() > 2) {
                    if (graph.adjacentVerticesList[i].get(firstElement) == graph.adjacentVerticesList[i].get(lastElement)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Calls dijkstraGetMinDistance and passes on the result set.
     *
     * @param graph current graph.
     * @return HeapNode[] result set.
     */
    HeapNode[] countWeightBetweenNodes(Graph graph) {
        this.graph = graph;
        return getMinDistance.dijkstraGetMinDistance(graph, 0);
    }

    /**
     * Makes sure no result is infinity, meaning that it is possible to get from all nodes to all nodes.
     *
     * @param resultSet result of Dijkstra's algorithm.
     * @return true/false depending on if the graph is coherent or not.
     */
    boolean checkIfGraphIsCoherent(HeapNode[] resultSet) {
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            if (resultSet[i].getDistance() < 0 || resultSet[i].getDistance() > 100) {
                return false;
            }
        }
        return true;
    }


}



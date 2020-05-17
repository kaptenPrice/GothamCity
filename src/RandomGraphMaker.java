/**
 * This class creates and validates random connections and distances.
 */
class RandomGraphMaker {
    private Dijkstra getMinDistance = new Dijkstra();
    Utility utility = new Utility();
    Graph graph;

    /**
     * @return the created graph.
     */
    Graph createNewGraph() {
        graph = setGraph();
        while (!secureGraphNodesAreUnique(graph) || !checkIfGraphIsCoherent(countWeightBetweenNodes(graph))) {
            System.gc();
            graph = setGraph();
        }

        utility.printGraph(graph);
        return graph;
    }

    /**
     * Provide data for the graph. Make sure each node is connected to 2 or 3 other nodes.
     * Loop until current vertex has at least 2 neighbours
     * Making sure no vertex has more than 3 edges and that vertex and neighbour are not the same.
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
     * @param graph
     * @return
     */
    boolean secureGraphNodesAreUnique(Graph graph) {
        this.graph = graph;
        if (graph == null) {
            graph = setGraph();
        }
        for (int i = 0; i < graph.adjacentVerticesList.length; i++) {
            int firstElement = 0;
            int lastElement = graph.adjacentVerticesList[i].size() - 1;
            for (int j = 0; j < lastElement; j++) {
                //checks so that 0 - 1 and 1 - 2  are not the same
                if (graph.adjacentVerticesList[i].get(j).destination == graph.adjacentVerticesList[i].get(j + 1).destination) {
                    return false;
                }
                //if node has three neighbours, check so that 0 and 2 are not the same
                if (graph.adjacentVerticesList[i].size() > 2) {
                    if (graph.adjacentVerticesList[i].get(firstElement).destination == graph.adjacentVerticesList[i].get(lastElement).destination) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    HeapNode[] countWeightBetweenNodes(Graph graph) {
        this.graph = graph;
        return getMinDistance.dijkstraGetMinDistance(graph, 0);
    }

    boolean checkIfGraphIsCoherent(HeapNode[] resultSet) {
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            if (resultSet[i].getDistance() < 0 || resultSet[i].getDistance() > 100) {
                return false;
            }
            /*for (int j = 1; j < resultSet.length-1; j++) {
                if (resultSet[i].getVertex() == resultSet[j].getVertex()) {
                    return false;
                }
            }*/
        }
        return true;
    }


}




class RandomGraphMaker {
    private Dijkstra getMinDistance = new Dijkstra();
    Graph graph;

    /*RandomGraphMaker() {
      //  secureGraphNodesAreUnique();
        //setGraph();
        // setFixedGraph();
    }*/

    //Provide data for the graph. Make sure each node is connected to 2 or 3 other nodes.
    Graph setGraph() {
        graph = new Graph();
        System.out.println("Jag skapar en graf, life is fantastic!");

        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {

            //Loop until current vertex has at least 2 neighbours
            while (graph.adjacentVerticesList[i].size() < 2) {
                int newNeighbour = (int) ((Math.random() * 10));
                int randomWeight = (int) ((Math.random() * 10) + 1);

                //Making sure no vertex has more than 3 edges and that vertex and neighbour are not the same.
                if (graph.adjacentVerticesList[i].size() < 3 &&
                        graph.adjacentVerticesList[newNeighbour].size() < 3 && graph.adjacentVerticesList[i] != graph.adjacentVerticesList[newNeighbour]) {
                    graph.addEdge(i, newNeighbour, randomWeight);

                }
            }
        }
       // secureGraphNodesAreUnique(graph);
         return graph;
    }

    boolean secureGraphNodesAreUnique(Graph graph) {
      this.graph=graph;
        if (graph==null) {
            graph = setGraph();
        }
        System.out.println("Jag gick in i loopen, fångad av en stormvind");
        for (int i = 0; i < graph.adjacentVerticesList.length; i++) {
            int firstElement = 0;
            int lastElement = graph.adjacentVerticesList[i].size() - 1;
            for (int j = 0; j < lastElement; j++) {
                //checks so that 0 - 1 and 1 - 2  are not the same
                if (graph.adjacentVerticesList[i].get(j).destination == graph.adjacentVerticesList[i].get(j + 1).destination) {
                    System.out.println("Dubletter finns, this is the night");
                    //creating a new graph
                    //graph = setGraph();
                   // setGraph();
                    return false;
                }
                //if node has three neighbours, check so that 0 and 2 are not the same
                if (graph.adjacentVerticesList[i].size() > 2) {

                    if (graph.adjacentVerticesList[i].get(firstElement) == graph.adjacentVerticesList[i].get(lastElement)) {
                        System.out.println("Dubletter finns i 3");
                        //graph = setGraph();
                        //setGraph();
                        return false;
                    }
                }
            }
        }
        System.out.println("All nodes are unique, caramia");
      //  checkIfGraphIsCoherent(countWeightBetweenNodes(graph));

        return true;
    }

    HeapNode[] countWeightBetweenNodes(Graph graph) {
        System.out.println("countWeightBetweenNodes activated, Dijsktra is working now");
        this.graph=graph;
        return getMinDistance.dijkstraGetMinDistance(graph, 0);
    }

    boolean checkIfGraphIsCoherent(HeapNode[] resultSet) {
        System.out.println("Walking in the checkIfNodesAreConnected activated");
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            if (resultSet[i].distance < 0 || resultSet[i].distance > 100) {
                System.out.println("Not a coherent graph, printing a new one");
               // secureGraphNodesAreUnique();
                //setGraph();
                return false;
            }
        }
        System.out.println("Graph is coherent");
        return true;
    }

  /*  void setFixedGraph() {
            Graph graph = new Graph();
            graph.addEdge(0, 1, 11);
            graph.addEdge(0, 2, 12);
            graph.addEdge(1, 3, 14);
            graph.addEdge(2, 3, 15);
            graph.addEdge(3, 5, 17);
            graph.addEdge(4, 5, 19);
            graph.addEdge(4, 7, 25);
            graph.addEdge(5, 6, 20);
            graph.addEdge(7, 8, 22);
            graph.addEdge(8, 9, 23);
            graph.addEdge(6, 9, 24);
           // graph.dijkstraGetMinDistance(1);

    }*/
}



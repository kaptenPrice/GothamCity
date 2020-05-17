import java.util.LinkedList;

class Utility {

    void printGraph(Graph graph) {
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            LinkedList<Edge> list = graph.adjacentVerticesList[i];
          for (Edge edge : list) {
                System.out.println(Constants.NAMES[i] + " is connected to " + Constants.NAMES[edge.destination] + " and distance is " + edge.weight);
            }
            System.out.println();
        }

    }

    void printDijkstra(HeapNode[] resultSet, int source, int destination) {
        System.out.println("\n\n\nThe shortest path to your destination:");
        System.out.println("*****" + Constants.NAMES[source] + " to " + Constants.NAMES[destination] + " distance is " + resultSet[destination].getDistance() + "*****");
    }
}
/*--              --
*   ---      ---
*       ----
*        -
*        -
*       ----
*   ---      ----
* --             --
*
*
*
*
*
* */
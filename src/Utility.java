import java.util.LinkedList;

/**
 * Utility class that takes care of print outs.
 */
class Utility {

    /**
     * Prints the given graph.
     *
     * @param graph graph to print
     */
    void printGraph(Graph graph) {
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            LinkedList<Edge> list = graph.adjacentVerticesList[i];
          for (Edge edge : list) {
                System.out.println(Constants.NAMES[i] + " is connected to " + Constants.NAMES[edge.destination] + " and distance is " + edge.distance);
            }
            System.out.println();
        }

    }

    /**
     * Prints the result relevant for the user.
     *
     * @param resultSet result from Dijkstra.
     * @param source user's starting point.
     * @param destination user's end point.
     */
    void printDijkstra(HeapNode[] resultSet, int source, int destination) {
        System.out.println("\n\n\nThe shortest path to your destination:");
        System.out.println("*****" + Constants.NAMES[source] + " to " + Constants.NAMES[destination] + " distance is " + resultSet[destination].getDistance() + " by Batmobile*****");
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
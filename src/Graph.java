import java.util.LinkedList;

/**
 * This class handles the graph.
 *
 * */
class Graph {
    LinkedList<Edge>[] adjacentVerticesList;

    /**
     * Constructor. Creates a linked list of linked lists. Each inner list is a list of the adjacent vertices of that particular index vertex.
     * */
    Graph() {
        adjacentVerticesList = new LinkedList[Constants.NUMBER_OF_VERTICES];
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            adjacentVerticesList[i] = new LinkedList<>();
        }
    }

    /**
     * Creates new edges and adds them to the vertices list. The connections are always made two-way.
     *
     * @param source starting point of the connection.
     * @param destination end point of the connection.
     * @param distance the distance between source and destination.
     */
    void addEdge(int source, int destination, int distance) {
        Edge edge = new Edge(source, destination, distance);
        adjacentVerticesList[source].add(edge);
        edge = new Edge(destination, source, distance);
        adjacentVerticesList[destination].add(edge);
    }

}

import java.util.LinkedList;

class Graph {

    LinkedList<Edge>[] adjacentVerticesList;

    Graph() {

        adjacentVerticesList = new LinkedList[Constants.NUMBER_OF_VERTICES];
        //initialize adjacency lists for all the vertices
        //Create 10 LinkedLists and add the to adjacentVerticesList
        for (int i = 0; i < Constants.NUMBER_OF_VERTICES; i++) {
            adjacentVerticesList[i] = new LinkedList<>();
        }
    }


    void addEdge(int source, int destination, int weight) {

        //New edge
        Edge edge = new Edge(source, destination, weight);

        //Adding source to destination
        adjacentVerticesList[source].add(edge);

        //New edge
        edge = new Edge(destination, source, weight);

        // to Add destination to source
        adjacentVerticesList[destination].add(edge);


    }

}

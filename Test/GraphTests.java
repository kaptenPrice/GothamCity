import org.junit.jupiter.api.*;

public class GraphTests {

    @Test
    void testGraphConstruktor() {
        Graph graph = new Graph();
        int actual = graph.adjacentVerticesList.length;
        int expected =Constants.CAPACITY;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testAddEdgeToAdjacentVerticesList() {
        Graph testGraph = new Graph();
        testGraph.addEdge(0, 1, 9);
        int acutalSource = testGraph.adjacentVerticesList[0].get(0).source;
        int actualWeight = testGraph.adjacentVerticesList[0].get(0).weight;
        int acutalDestination = testGraph.adjacentVerticesList[0].get(0).destination;
        int expectedSource = 0;
        int expectedDestination = 1;
        int expectedW = 9;
        Assertions.assertEquals(expectedSource, acutalSource);
        Assertions.assertEquals(expectedDestination, acutalDestination);
        Assertions.assertEquals(expectedW, actualWeight);
    }

    @Test
    void testAddEdgeCreatesWayBackFromSource() {
        Graph testGraph = new Graph();
        testGraph.addEdge(0, 1, 9);
        int acutalSource = testGraph.adjacentVerticesList[1].get(0).source;
        int actualWeight = testGraph.adjacentVerticesList[1].get(0).weight;
        int acutalDestination = testGraph.adjacentVerticesList[1].get(0).destination;
        int expectedSource = 1;
        int expectedDestination = 0;
        int expectedW = 9;
        Assertions.assertEquals(expectedSource, acutalSource);
        Assertions.assertEquals(expectedDestination, acutalDestination);
        Assertions.assertEquals(expectedW, actualWeight);
    }

    @Test
    void testConnectionBetweenEdgesInLinkedList() {
        Graph testgraph = new Graph();
        testgraph.addEdge(0, 5, 10);
        testgraph.addEdge(0, 6, 11);
        testgraph.addEdge(0, 7, 12);
        int actualFirstEdgeDest = testgraph.adjacentVerticesList[0].get(0).destination;
        int actualSecondEdgeDest = testgraph.adjacentVerticesList[0].get(1).destination;
        int actualthirdEdgeDest = testgraph.adjacentVerticesList[0].get(2).destination;
        int expectedFirstEdgeDest = 5;
        int expectedSecondEdgeDest = 6;
        int expectedThirdEdgeDest = 7;
        Assertions.assertEquals(actualFirstEdgeDest, expectedFirstEdgeDest);
        Assertions.assertEquals(actualSecondEdgeDest, expectedSecondEdgeDest);
        Assertions.assertEquals(actualthirdEdgeDest, expectedThirdEdgeDest);
    }



}

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
* Final test, we are testing all functions against one graf*/
class SystemTest {
    @Test
    void testDijkstra() {
        Dijkstra testDijkstra = new Dijkstra();
        Graph testGraph;
        Hub hub = new Hub();
        testGraph = new Graph();
        testGraph.addEdge(0, 1, 11);
        testGraph.addEdge(0, 2, 12);
        testGraph.addEdge(1, 3, 14);
        testGraph.addEdge(2, 3, 15);
        testGraph.addEdge(3, 5, 17);
        testGraph.addEdge(4, 5, 19);
        testGraph.addEdge(4, 7, 25);
        testGraph.addEdge(5, 6, 20);
        testGraph.addEdge(7, 8, 22);
        testGraph.addEdge(8, 9, 23);
        testGraph.addEdge(6, 9, 24);

        HeapNode[] actual = testDijkstra.dijkstraGetMinDistance(testGraph, 0);
        int[] expectedVertex = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedDistance = {0, 11, 12, 25, 61, 42, 62, 86, 108, 86};
        for (int i = 0; i < actual.length; i++) {
            Assert.assertEquals(expectedVertex[i], actual[i].getVertex());
            Assert.assertEquals(expectedDistance[i], actual[i].getDistance());
        }
        HeapNode[] testArray = hub.showDistance(testGraph, 4, 7);
        Assertions.assertEquals(37, testArray[6].getDistance()); //assert distance
    }

    /**
     * Tesing to create x grafs to se how the program handles big amount of ordered grafs.
     */
    @Test
    void stressTest() {

        RandomGraphMaker randomGraphMaker = new RandomGraphMaker();
        Graph graph;
       // Utility utility = new Utility();
        int count = 0;
        while (count < 10) {
            randomGraphMaker.createNewGraph();
            count++;
            System.out.println(count);

            }
        }
    }

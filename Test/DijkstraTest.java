import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DijkstraTest {
    @Test
    void testLengthOfArrayOfHeapNodes() {
        Dijkstra dijkstraTest = new Dijkstra();
        HeapNode[] actualTestArr = dijkstraTest.createArrayOfHeapNodes();
        int actualLength = actualTestArr.length;
        int expectedLength = Constants.NUMBER_OF_VERTICES;
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    void testIfDistanceIsMaxValue() {
        int expectedValue = Integer.MAX_VALUE;
        Dijkstra dijkstraTest = new Dijkstra();
        HeapNode[] actualTestArr = dijkstraTest.createArrayOfHeapNodes();
        for (HeapNode heapNode : actualTestArr) {
            int actual = heapNode.getDistance();
            Assert.assertEquals(expectedValue, actual);
        }
    }

    @Test
    void testIfVerticesHasValues() {
        Dijkstra dijkstraTest = new Dijkstra();
        HeapNode[] actualTestArr = dijkstraTest.createArrayOfHeapNodes();
        for (int i = 0; i < actualTestArr.length; i++) {
            int actual = actualTestArr[i].getVertex();
            Assert.assertEquals(i, actual);
        }

    }

    @Test
    void testCreateMinHeapSize() {
        Dijkstra dijkstraTest = new Dijkstra();
        HeapNode[] actualArrayOfHeapNodes = dijkstraTest.createArrayOfHeapNodes();
        MinHeap actualMinHeap = dijkstraTest.createMinHeap();
        int actualSize = actualMinHeap.getCurrentSize();
        int expected = Constants.NUMBER_OF_VERTICES;
        Assert.assertEquals(expected, actualSize);
    }

    @Test
    void testCreateMinHeap() {
        Dijkstra dijkstraTest = new Dijkstra();
        HeapNode[] actualArrayOfHeapNodes = dijkstraTest.createArrayOfHeapNodes();
        MinHeap actualMinHeap = dijkstraTest.createMinHeap();
        HeapNode[] actualHeapNodeArr = actualMinHeap.getTreeOfHeapNodes();
        Assert.assertEquals(-1, actualHeapNodeArr[0].getVertex());
        for (int i = 0; i < actualHeapNodeArr.length; i++) {
            Assert.assertEquals(i - 1, actualHeapNodeArr[i].getVertex());
        }
    }

    @Test
    void testDijkstra(){
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

        for(int i = 0; i < actual.length; i++) {
            Assert.assertEquals(expectedVertex[i], actual[i].getVertex());
            Assert.assertEquals(expectedDistance[i], actual[i].getDistance());
        }

        HeapNode[] testArray = hub.showDistance(testGraph,4, 7);
      /*  for (int i = 0; i < testArray.length; i++) {
            System.out.println("Vertex: " + testArray[i].vertex + "\nDistance: " + testArray[i].distance);
        }*/

        Assertions.assertEquals(37, testArray[6].getDistance()); //assert distance
    }

}

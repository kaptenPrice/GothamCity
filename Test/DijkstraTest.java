import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DijkstraTest {
    @Test
    void testLenghtOfArrayOfHeapNodes() {
        Dijkstra dijkstraTest = new Dijkstra();
        HeapNode[] actualTestArr = dijkstraTest.createArrayOfHeapNodes();
        int actualLenght = actualTestArr.length;
        int expectedLenght = Constants.NUMBER_OF_VERTICES;
        Assert.assertEquals(expectedLenght, actualLenght);
    }

    @Test
    void testIfDistanceIsMAxValue() {
        int expectedValue = Integer.MAX_VALUE;
        Dijkstra dijkstraTest = new Dijkstra();
        HeapNode[] actualTestArr = dijkstraTest.createArrayOfHeapNodes();
        for (HeapNode heapNode : actualTestArr) {
            int actual = heapNode.distance;
            Assert.assertEquals(expectedValue, actual);
        }
    }

    @Test
    void testIfVerticesHasValues() {
        Dijkstra dijkstraTest = new Dijkstra();
        HeapNode[] actualTestArr = dijkstraTest.createArrayOfHeapNodes();
        for (int i = 0; i < actualTestArr.length; i++) {
            int actual = actualTestArr[i].vertex;
            Assert.assertEquals(i, actual);
        }

    }

    @Test
    void testcreateMinHeapSize() {
        Dijkstra dijkstraTest = new Dijkstra();
        MinHeap acutalMinHeap = dijkstraTest.createMinHeap();
        int actualSize = acutalMinHeap.getCurrentSize();
        int expected = Constants.NUMBER_OF_VERTICES;
        Assert.assertEquals(expected, actualSize);
    }

    @Test
    void testcreateMinHeap() {
        Dijkstra dijkstraTest = new Dijkstra();
        MinHeap acutalMinHeap = dijkstraTest.createMinHeap();
        HeapNode[] actualHeapNodeArr = acutalMinHeap.getTreeOfHeapNodes();
        Assert.assertEquals(-1, actualHeapNodeArr[0].vertex);
        for (int i = 0; i < actualHeapNodeArr.length; i++) {
            Assert.assertEquals(i - 1, actualHeapNodeArr[i].vertex);
        }
    }


}

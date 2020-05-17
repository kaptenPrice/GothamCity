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


}

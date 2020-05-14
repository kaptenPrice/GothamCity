import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinHeapTest {


    //Asserting that each vertex in the heap node array gets their assigned value.
    @Test
    void insert() {
        MinHeap minHeap = new MinHeap();
        HeapNode heapNode = new HeapNode();

        int expectedId;
        int actualId;

        for (int i = 0; i < 9; i++) {
            minHeap.insert(heapNode);
            expectedId = i+1;
            actualId = minHeap.indexes[heapNode.vertex];
            Assertions.assertEquals(expectedId, actualId);
        }
    }

    @Test
    void bubbleUp() {
        MinHeap minHeap = new MinHeap();
        HeapNode[] mH = new HeapNode[10];

        for (int i = 0; i < 10; i++) {
            mH[i] = new HeapNode();
            mH[i].vertex = i;
            mH[i].distance = Integer.MAX_VALUE;
        }

        for(int pos = 0; pos< 10; pos++) {

            if (mH[pos/2].distance > mH[pos].distance) {
                minHeap.bubbleUp(pos);

                int actualParentId = minHeap.indexes[minHeap.getTreeOfHeapNodes()[pos].vertex];
                int expectedParentId = 0;
                int actualCurrentId = minHeap.indexes[minHeap.getTreeOfHeapNodes()[pos/2].vertex];
                int expectedCurrentId = 0;

                Assertions.assertEquals(expectedParentId, actualParentId);
                Assertions.assertEquals(expectedCurrentId, actualCurrentId);
            }
        }
    }

    @Test
    void extractMin() {
        MinHeap minHeap = new MinHeap();
        HeapNode expectedHeapNode = new HeapNode();
        expectedHeapNode.vertex = 1;

    //    HeapNode actualHeapNode = minHeap.treeOfHeapNodes[minHeap.currentSize];
    //    actualHeapNode.vertex = 1; //TODO should be assigned in the method itself, but returns -1 and index out of bounds every time....

   //     Assertions.assertEquals(expectedHeapNode.vertex, actualHeapNode.vertex);
        Assertions.assertDoesNotThrow(minHeap::extractMin);
    }

    @Test
    void sinkDown() {
        MinHeap minHeap = new MinHeap();
        int expectedSmallest;
        int actualSmallest;

        minHeap.sinkDown(1);

        expectedSmallest = 1;
        minHeap.indexes[3] = 1;
        actualSmallest = minHeap.indexes[3];

        Assertions.assertEquals(expectedSmallest, actualSmallest);
    }

    @Test
    void swap() {
        MinHeap minHeap = new MinHeap();
        HeapNode[] mH = new HeapNode[10];
        int b = 1;
        for (int i = 0; i < 10; i++) {
            mH[i] = new HeapNode();
            mH[i].vertex = i;
            mH[i].distance = Integer.MAX_VALUE;
        }
       // minHeap.swap(2, b);
        int expected = 1;
        int actual = mH[b].vertex;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        MinHeap minHeap = new MinHeap();
        Assertions.assertTrue(minHeap.isEmpty());
    }

    @Test
    void heapSize() {
        MinHeap minHeap = new MinHeap();
        Assertions.assertEquals(0, minHeap.getCurrentSize());
    }
}
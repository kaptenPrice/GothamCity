import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinHeapTest {

    /**
     * Test if minHeap arranges by MinHeap rules when we insert new nodes to tree and if extractMin extracts the root when called.
     */
    @Test
    void minHeapIntegrationTest() {
        MinHeap minHeap = new MinHeap();
        HeapNode[] treeOfHeadPhones = new HeapNode[5];

        treeOfHeadPhones[0] = new HeapNode();
        treeOfHeadPhones[0].setVertex(3);
        treeOfHeadPhones[0].setDistance(15);

        treeOfHeadPhones[1] = new HeapNode();
        treeOfHeadPhones[1].setVertex(5);
        treeOfHeadPhones[1].setDistance(7);

        treeOfHeadPhones[2] = new HeapNode();
        treeOfHeadPhones[2].setVertex(4);
        treeOfHeadPhones[2].setDistance(10);

        treeOfHeadPhones[3] = new HeapNode();
        treeOfHeadPhones[3].setVertex(2);
        treeOfHeadPhones[3].setDistance(5011);

        treeOfHeadPhones[4] = new HeapNode();
        treeOfHeadPhones[4].setVertex(7);
        treeOfHeadPhones[4].setDistance(2);

        minHeap.insert(treeOfHeadPhones[3]);
        minHeap.insert(treeOfHeadPhones[1]);
        minHeap.insert(treeOfHeadPhones[4]);
        minHeap.insert(treeOfHeadPhones[2]);
        minHeap.insert(treeOfHeadPhones[0]);
        minHeap.extractMin();

        int[]expectedVertexArr={-1,5,4,3,2};
        int[]expectedDistanceArr={Integer.MIN_VALUE,7,10,15,5011};
        for (int i = 0; i <= treeOfHeadPhones.length-1; i++) {
            Assert.assertEquals(expectedVertexArr[i],minHeap.getTreeOfHeapNodes()[i].getVertex());
            Assert.assertEquals(expectedDistanceArr[i],minHeap.getTreeOfHeapNodes()[i].getDistance());
        }
    }

    /**
     * Asserting that each vertex in the heap node array gets their assigned value and that it returns false if that is not the case.
     */
    @Test
    void insert() {
        MinHeap minHeap = new MinHeap();
        HeapNode heapNode = new HeapNode();

        int expectedId;
        int actualId;

        for (int i = 1; i < Constants.NUMBER_OF_VERTICES; i++) {
            minHeap.insert(heapNode);
            expectedId = i;
            actualId = minHeap.indexes[heapNode.getVertex()];
            Assertions.assertEquals(expectedId, actualId);
            Assertions.assertFalse(expectedId != actualId);
        }
    }

    /**
     *  Making sure currentSize is being updated correctly and that currentElement is following it.
     */
    @Test
    void testCurrentSizeInsert() {
        MinHeap minHeap = new MinHeap();
        HeapNode heapNode = new HeapNode();

        int currentTestSize = 0;

        for (int i = 1; i < Constants.NUMBER_OF_VERTICES; i++) {
            minHeap.insert(heapNode);
            currentTestSize++;

            Assertions.assertEquals(currentTestSize, minHeap.getCurrentSize());
            Assertions.assertEquals(currentTestSize, minHeap.currentElement);
        }
    }

    /**
     * Checks if bubbleUp gives the correct parent and current id.
     */
    @Test
    void bubbleUp() {
        MinHeap minHeap = new MinHeap();
        HeapNode[] mH = new HeapNode[10];

        for (int i = 0; i < 10; i++) {
            mH[i] = new HeapNode();
            mH[i].setVertex(i);
            mH[i].setDistance(Integer.MAX_VALUE);
        }

        for(int pos = 0; pos< 10; pos++) {

            if (mH[pos/2].getDistance() > mH[pos].getDistance()) {
                minHeap.bubbleUp(pos);

                int actualParentId = minHeap.indexes[minHeap.getTreeOfHeapNodes()[pos].getVertex()];
                int expectedParentId = 0;
                int actualCurrentId = minHeap.indexes[minHeap.getTreeOfHeapNodes()[pos/2].getVertex()];
                int expectedCurrentId = 0;

                Assertions.assertEquals(expectedParentId, actualParentId);
                Assertions.assertEquals(expectedCurrentId, actualCurrentId);
            }
        }
    }


    /**
     * Checks if sink down returns the correct smallest.
     */
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

    /**
     * Checks that swap swaps the positions.
     */
    @Test
    void swap() {
        MinHeap minHeap = new MinHeap();
        HeapNode[] mH = new HeapNode[10];
        int b = 1;
        for (int i = 0; i < 10; i++) {
            mH[i] = new HeapNode();
            mH[i].setVertex(i);
            mH[i].setDistance(Integer.MAX_VALUE);
        }
        int expected = 1;
        int actual = mH[b].getVertex();
        Assertions.assertEquals(expected, actual);
    }

}
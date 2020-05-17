import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EdgeTest {

    /**
     * Testing value of Edges variables when new Edge is created
     */
    @Test
    void testNewEdge() {
        Edge edge = new Edge(1, 0, 8);
        int expectedSource = 1;
        int expectedDest = 0;
        int expectedWeight = 8;

        Assertions.assertEquals(expectedSource, edge.source);
        Assertions.assertEquals(expectedDest, edge.destination);
        Assertions.assertEquals(expectedWeight, edge.distance);

    }


}




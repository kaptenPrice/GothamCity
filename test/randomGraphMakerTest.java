import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/*
class randomGraphMakerTest {
//TODO Gör ett test som skapar 100 grafer och kolla så att avstånd hamnar mellan 1-10 på alla
    //Gets 10 random vertices from graphMaker and assures all have 2-3 neighbours.
    @Test
    public void TestSetGraph() {
        RandomGraphMaker randomGraphMaker = new RandomGraphMaker();
       Graph testGraph= randomGraphMaker.setGraph();
        for (int i = 0; i < 10; i++) {
            LinkedList<Edge> actual=testGraph.adjacentVerticesList[i];
            if (actual.size()<2){
                System.out.println("Node has only one connection");
            }
            if (actual.size()>=2){
                System.out.println("linkedlist element "+i+" is connected to  "+testGraph.adjacentVerticesList[i].size()+" nodes");
            }
        }
    }

    @Test
    void assureNoExceptions() {
        RandomGraphMaker randomGraphMaker = new RandomGraphMaker();
        Assertions.assertDoesNotThrow(randomGraphMaker::setGraph);
    }
}
 */
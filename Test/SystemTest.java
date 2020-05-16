import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemTest {
    @Test
    void finalTest() {

        RandomGraphMaker randomGraphMaker = new RandomGraphMaker();
        Graph graph;
        Utility utility = new Utility();
        int count = 0;
        while (count < 30) {
            //graph = randomGraphMaker.setGraph();
            graph = randomGraphMaker.createNewGraph();
         //   while (!randomGraphMaker.secureGraphNodesAreUnique(graph) || !randomGraphMaker.checkIfGraphIsCoherent(randomGraphMaker.countWeightBetweenNodes(graph))) {
           //     graph = randomGraphMaker.setGraph();
           // }

            utility.printGraph(graph);
            count++;
        }
    }
}
package greedyalgorithm;
import org.junit.Test;

import java.util.Random;

public class RandomGeneratorTest {

    @Test
    public void testRandom(){
        RandomGraphGenerator rGG = new RandomGraphGenerator();
        rGG.generate(10, 0.2);
        GraphPrintUtils.printGraph(rGG.getResult());

        //second time
        System.out.println("");
        rGG.generate(10, 0.2);
        GraphPrintUtils.printGraph(rGG.getResult());
    }

    @Test
    public void testRandomGraph(){
        RandomGraphGenerator rGG = new RandomGraphGenerator();
        rGG.generate(10, 0.2);
        RandomGraph graph = rGG.getResult();

        GraphPrintUtils.printGraph(graph);
        graph.remove(4);

        System.out.println("");
        GraphPrintUtils.printGraph(graph);
    }
}

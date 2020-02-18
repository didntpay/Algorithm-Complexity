package greedyalgorithm.homework3;
import org.junit.Test;

public class RandomGeneratorTest {

    @Test
    public void testRandom(){
        RandomGraphGenerator rGG = new RandomGraphGenerator();
        rGG.generate(10, 0.2);
        GraphPrintUtils.printGraph(rGG.getResult());

        //second time
        System.out.println("");
        rGG.generate(10, 0.2);
        GraphPrintUtils.printGraphWithColor(rGG.getResult());
    }

}

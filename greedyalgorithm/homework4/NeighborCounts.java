package greedyalgorithm.homework4;

import greedyalgorithm.Vertex;
import greedyalgorithm.homework3.RandomGraph;
import greedyalgorithm.homework3.RandomGraphGenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NeighborCounts {
    public static void main(String[] args){
        double[] sampleSize = {0.002, 0.004, 0.006, 0.008, 0.01, 0.012, 0.014, 0.016, 0.018, 0.02};
        RandomGraphGenerator rGG = new RandomGraphGenerator();
        for (int i = 0; i < sampleSize.length; i++){
            rGG.generate(1000, sampleSize[i]);
            RandomGraph temp = rGG.getResult();
            //GraphPrintUtils.printGraph(temp);
            Map<Integer, Integer> neighborCount = neighborCategory(temp);
            Integer[] keys = new Integer[neighborCount.keySet().toArray().length];
            keys = neighborCount.keySet().toArray(keys);
            //Arrays.sort(keys);
            for (Integer key : keys){
                System.out.println(key + " \t" + neighborCount.get(key));
            }

            System.out.println("");
        }
    }

    public static Map<Integer, Integer> neighborCategory(RandomGraph graph){
        Map<Integer, Integer> result = new HashMap<>();
        Vertex[] vertices = graph.getAllKeys();

        for (int i = 0; i < vertices.length; i++){
            int neighborCount = graph.neighbors(vertices[i]).length;
            if (!result.containsKey(neighborCount)){
                result.put(neighborCount, 1);
            }
            else {
                result.put(neighborCount, result.get(neighborCount) + 1);
            }
        }
        return result;
    }


}

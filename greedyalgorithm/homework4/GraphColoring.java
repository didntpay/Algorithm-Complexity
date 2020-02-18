package greedyalgorithm.homework4;

import greedyalgorithm.Vertex;
import greedyalgorithm.homework3.GraphPrintUtils;
import greedyalgorithm.homework3.RandomGraph;
import greedyalgorithm.homework3.RandomGraphGenerator;

import java.util.Set;

public class GraphColoring {
    public static void main(String[] args){
        double[] sampleSize = {0.002, 0.004, 0.006, 0.008, 0.01, 0.012, 0.014, 0.016, 0.018, 0.02};
        RandomGraphGenerator rGG = new RandomGraphGenerator();
        for (int i = 0; i < sampleSize.length; i++){
            int avgColor = 0;
            int avgMaxDegree = 0;
            for (int j = 0; j < 20; j++){
                rGG.generate(1000, sampleSize[i]);
                RandomGraph temp = rGG.getResult();
                avgColor += coloringGraph(temp);
                avgMaxDegree += maxNeighborDegree(temp);
                //GraphPrintUtils.printGraphWithColor(temp);
            }
            System.out.println(sampleSize[i] + "\t" + avgColor / 20.0 + "\t" + avgMaxDegree / 20);
        }
    }

    public static int coloringGraph(RandomGraph graph){
        int colorCount = maxNeighborDegree(graph);
        int[] colorUsage = new int[colorCount + 1];
        int[] colors = new int[colorCount + 1];

        for (int i = 0; i < colors.length; i++){
            colors[i] = i;
        }

        Vertex[] keys = graph.getAllKeys();
        int total = 0;
        int color = -1;
        for (Vertex key : keys){
            Set<Integer> usedColor = graph.getNeighborColors(key);
            for (int i = 0; i < colors.length; i++){
                if (!usedColor.contains(colors[i])){
                    graph.setColor(key, colors[i]);
                    color = i;
                    colorUsage[colors[i]]++;
                    break;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < colorUsage.length; i++){
            if (colorUsage[i] > 0){
                max++;
            }
        }
        return max;

    }

    public static int maxNeighborDegree(RandomGraph graph){
        Vertex[] keys = graph.getAllKeys();
        int max = 0;
        for (Vertex key : keys){
            int len = graph.neighbors(key).length;
            if (graph.neighbors(key).length > max){
                max = graph.neighbors(key).length;
            }
        }
        return max;
    }
}

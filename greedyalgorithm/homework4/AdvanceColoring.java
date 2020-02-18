package greedyalgorithm.homework4;

import greedyalgorithm.Vertex;
import greedyalgorithm.homework3.RandomGraph;
import greedyalgorithm.homework3.RandomGraphGenerator;

import java.util.*;

public class AdvanceColoring {

    public static void main(String[] args){
        double[] sampleSize = {0.002, 0.004, 0.006, 0.008, 0.01, 0.012, 0.014, 0.016, 0.018, 0.02};
        RandomGraphGenerator rGG = new RandomGraphGenerator();
        for (int i = 0; i < sampleSize.length; i++){
            int avgColor = 0;
            int avgMaxDegree = 0;
            for (int j = 0; j < 5; j++){
                rGG.generate(1000, sampleSize[i]);
                RandomGraph temp = rGG.getResult();
                avgMaxDegree += maxNeighborDegree(temp);
                avgColor += coloringGraph(temp, 1000);
            }
            System.out.println(avgMaxDegree / 5 + "\t" + sampleSize[i] + "\t" + avgColor / 5.0);
        }
    }

    public static int coloringGraph(RandomGraph graph, int vertexSize){
        int colorCount = maxNeighborDegree(graph);
        int[] colorUsage = new int[colorCount + 1];
        Vertex startNode = graph.getAllKeys()[0];
        Stack<Vertex> q = new Stack<>();
        q.push(startNode);
        Set<Vertex> visited = new HashSet<>(Set.of(startNode));
        graph.setColor(startNode, 0);

        while (!q.isEmpty()){
            Vertex cur = q.pop();
            Vertex[] neighbors = graph.neighbors(cur);
            Set<Integer> usedColors = graph.getNeighborColors(cur);
            //visited.add(cur);
            int color = -1;


            for (Vertex nei : neighbors){
                if (!visited.contains(nei)){
                    for (int i = 0; i < colorCount + 1; i++){
                        if (!usedColors.contains(i)){
                            color = i;
                            colorUsage[color]++;
                            break;
                        }
                    }
                    q.add(nei);
                    graph.setColor(nei, color);
                    visited.add(nei);
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

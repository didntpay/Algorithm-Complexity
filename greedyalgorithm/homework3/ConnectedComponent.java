package greedyalgorithm.homework3;

import greedyalgorithm.Vertex;

import java.util.*;

public class ConnectedComponent {
    public static void main(String[] args){
        RandomGraphGenerator rGG = new RandomGraphGenerator();
        HashMap<Integer, ArrayList<Vertex>> map = new HashMap<>();
        double[] sampleSize = {0.00005, 0.000075, 0.0001, 0.000125, 0.00015, 0.000175, 0.0002, 0.0003, 0.0004,
                                0.0005, 0.0006, 0.0007, 0.0008, 0.0009, 0.001};
        for (int i = 0; i < sampleSize.length; i++){
            int totalD = 0;
            int totalSize = 0;
            for (int j = 0; j < 10; j++){
                rGG.generate(10000, sampleSize[i]);
                RandomGraph temp = rGG.getResult();
                boolean done = false;
                int d = 0;
                Vertex nextVertex = new Vertex(0);
                //GraphPrintUtils.printGraph(temp);
                while (!done){

                    map.put(d, traverseComponenet(temp, nextVertex));
                    d++;

                    if (temp.getAllKeys().length > 0){
                        nextVertex = temp.getAllKeys()[0];
                    }
                    else {
                        done = true;
                    }
                }
                totalD += d;
                totalSize += findComponentSize(map);
            }
            System.out.print(sampleSize[i] + "\t" + totalD / 10 + "\t");
            System.out.println(totalSize / 10);

        }
    }

    public static ArrayList<Vertex> traverseComponenet(RandomGraph graph, Vertex vertexChoice){
        Queue<Vertex> queue = new LinkedList<>(List.of(vertexChoice));
        ArrayList<Vertex> component = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        visited.add(vertexChoice);

        while (!queue.isEmpty()){
            Vertex vertex = queue.poll();
            component.add(vertex);
            for (Vertex neighbor : graph.neighbors(vertex)){
                if (!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
            graph.remove(vertex);
        }
        return component;
    }

    public static int findComponentSize(HashMap<Integer, ArrayList<Vertex>> map){
        int count = map.keySet().size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++){
            if (map.get(i).size() > max){
                max = map.get(i).size();
            }
        }
        return max;
    }

}

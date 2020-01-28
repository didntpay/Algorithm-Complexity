package greedyalgorithm;

public class GraphPrintUtils {
    public static void printGraph(RandomGraph graph){
        for (int i = 0; i < graph.V(); i++){
            Integer[] neighbors = graph.neighbors(i);
            if (neighbors.length > 0){
                System.out.print(i + ": [" + neighbors[0]);
                for (int j = 1; j < neighbors.length; j++){
                    System.out.print(", " + neighbors[j]);
                }
                System.out.println("]");
            }
            else {
                System.out.println(i + ":");
            }

        }
    }
}

package greedyalgorithm.homework3;

import greedyalgorithm.Vertex;

public class GraphPrintUtils {
    public static void printGraph(RandomGraph graph){
        Vertex[] keys = graph.getAllKeys();
        for (int i = 0; i < keys.length; i++){
            Vertex[] neighbors = graph.neighbors(keys[i]);
            if (neighbors.length > 0){
                System.out.print(keys[i].getID() + ": [" + neighbors[0].getID());
                for (int j = 1; j < neighbors.length; j++){
                    System.out.print(", " + neighbors[j].getID());
                }
                System.out.println("]");
            }
            else {
                System.out.println(keys[i].getID() + ":");
            }

        }
    }

    public static void printGraphWithColor(RandomGraph graph){
        Vertex[] keys = graph.getAllKeys();
        for (int i = 0; i < keys.length; i++){
            Vertex[] neighbors = graph.neighbors(keys[i]);
            if (neighbors.length > 0){
                System.out.print(keys[i].getID() + ": [" + neighbors[0].getID());
                for (int j = 1; j < neighbors.length; j++){
                    System.out.print(", " + neighbors[j].getID());
                }
                System.out.println("] " + graph.getNeighborColor(keys[i].getID()));
            }
            else {
                System.out.println(keys[i].getID() + ":");
            }

        }
    }
}

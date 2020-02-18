package greedyalgorithm.homework3;


import greedyalgorithm.Vertex;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class RandomGraph {
    private Map<Vertex, List<Vertex>> neighbor;
    private int[] neighborColors;

    public RandomGraph(int n){
        this.neighbor = new HashMap<>();
        this.neighborColors = new int[n];
    }

    public void add(Vertex vertexV, Vertex vertexE){

        if (!this.neighbor.containsKey(vertexV))
            this.neighbor.put(vertexV, new ArrayList<>(List.of(vertexE)));
        else
            this.neighbor.get(vertexV).add(vertexE);

        if (!this.neighbor.containsKey(vertexE))
            this.neighbor.put(vertexE, new ArrayList<>(List.of(vertexV)));
        else
            this.neighbor.get(vertexE).add(vertexV);
    }

    public void remove(Vertex vertexV){
        this.neighbor.remove(vertexV);
    }

    public Vertex[] neighbors(Vertex vertex){
        if (this.neighbor.containsKey(vertex)){
            Vertex[] result = new Vertex[this.neighbor.get(vertex).size()];
            return this.neighbor.get(vertex).toArray(result);
        }
        return new Vertex[] {};
    }

    public Set<Integer> getNeighborColors(Vertex v){
        Vertex[] neighbors = this.neighbors(v);
        Set<Integer> color = new HashSet<>();
        for (Vertex e : neighbors){
            color.add(this.neighborColors[e.getID()]);
        }
        return color;
    }

    public void setColor(Vertex target, int color){
        this.neighborColors[target.getID()] = color;
    }

    public int getNeighborColor(int index){
        return this.neighborColors[index];
    }

    public boolean isEmpty(){
        return this.neighbor.isEmpty();
    }

    public Vertex[] getAllKeys(){
        Vertex[] keys = new Vertex[this.neighbor.keySet().size()];
        return this.neighbor.keySet().toArray(keys);
    }
}

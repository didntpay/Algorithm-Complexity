package greedyalgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RandomGraph {
    private Map<Integer, List<Integer>> neighbor;

    public RandomGraph(){
        this.neighbor = new HashMap<>();
    }

    public void add(int vertexV, int vertexE){
        if (!this.neighbor.containsKey(vertexV)) {
            this.neighbor.put(vertexV, new ArrayList<>(List.of(vertexE)));
        }
        else {
            this.neighbor.get(vertexV).add(vertexE);
        }

        if (!this.neighbor.containsKey(vertexE)){
            this.neighbor.put(vertexE, new ArrayList<>(List.of(vertexV)));
        }
        else {
            this.neighbor.get(vertexE).add(vertexV);
        }
    }

    public void remove(int vertexV, int vertexE){
        this.neighbor.get(vertexV).remove(vertexE);
    }

    public Integer[] neighbors(int vertex){
        if (this.neighbor.containsKey(vertex)){
            Integer[] result = new Integer[this.neighbor.get(vertex).size()];
            return this.neighbor.get(vertex).toArray(result);
        }
        return new Integer[] {};
    }

    public int V(){
        return this.neighbor.keySet().size();
    }

    public boolean isEmpty(){
        return this.neighbor.isEmpty();
    }
}

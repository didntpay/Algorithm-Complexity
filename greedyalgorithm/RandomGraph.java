package greedyalgorithm;


import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class RandomGraph {
    private Map<Integer, List<Integer>> neighbor;

    public RandomGraph(int n){
        this.neighbor = new HashMap<>();
        for (int i = 0; i < n; i++){
            this.neighbor.put(i, new ArrayList<>());
        }
    }

    public void add(int vertexV, int vertexE){
        this.neighbor.get(vertexV).add(vertexE);
        this.neighbor.get(vertexE).add(vertexV);
    }

    public void remove(Integer vertexV){
        this.neighbor.remove(vertexV);
    }

    public Integer[] neighbors(int vertex){
        if (this.neighbor.containsKey(vertex)){
            Integer[] result = new Integer[this.neighbor.get(vertex).size()];
            return this.neighbor.get(vertex).toArray(result);
        }
        return new Integer[] {};
    }

    public int V(){
        if (this.neighbor.isEmpty()) {
            return 0;
        }
        Integer[] loader = new Integer[this.neighbor.keySet().size()];
        loader = this.neighbor.keySet().toArray(loader);
        return loader[loader.length - 1] + 1;
        //return the max key value in the set to run bfs and print graphs
    }

    public boolean isEmpty(){
        return this.neighbor.isEmpty();
    }

    public Integer[] getAllKeys(){
        Integer[] keys = new Integer[this.neighbor.keySet().size()];
        return this.neighbor.keySet().toArray(keys);
    }
}

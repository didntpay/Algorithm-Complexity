package greedyalgorithm;

import java.util.Random;

public class RandomGraphGenerator {
    private RandomGraph result;
    public RandomGraphGenerator(){


    }

    public void generate(int n, double p){
        Random random = new Random();
        result = new RandomGraph();

        for (int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                if (random.nextDouble() < p){
                    result.add(i, j);
                }
            }
        }
    }

    public RandomGraph getResult(){
        return this.result;
    }




}

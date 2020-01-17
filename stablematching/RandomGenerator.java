package stablematching;

import java.util.Random;
public class RandomGenerator {
    public RandomGenerator(){

    }

    public int[][] generateRandomMatrix(int n){
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++){
            result[i] = generateRandomList(n);
        }
        return result;
    }

    public int[] generateRandomList(int n){
        int[] result = identityList(n);
        Random rand = new Random();
        for (int i = 1; i < result.length; i++){
            int swapIndex = rand.nextInt(i + 1);
            int temp = result[swapIndex];
            result[swapIndex] = result[i];
            result[i] = temp;
        }
        return result;
    }

    public int[] identityList(int n){
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            result[i] = i;
        }
        return result;
    }
}

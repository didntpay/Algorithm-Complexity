package greedyalgorithm;

import java.util.Random;

public class ConnectedComponent {
    public static void main(String[] args){
        RandomGraphGenerator rGG = new RandomGraphGenerator();
        int[] sampleSize = {1, 10, 25, 50, 100, 250, 350, 450, 550, 650, 750, 850, 950, 1000};
        for (int i = 0; i < sampleSize.length; i++){
            rGG.generate(sampleSize[i], 0.2);
            RandomGraph temp = rGG.getResult();
            int count = temp.V();
            for (int j = 0; j < count; j++){

            }
        }
    }


}

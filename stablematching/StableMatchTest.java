package stablematching;
import org.junit.Test;

import java.util.Random;

public class StableMatchTest {
    @Test
    public void givenTestCases(){

        int[][] m = {{2, 0, 1},
                    {2, 0, 1},
                    {2, 1, 0}};
        int[][] w = {{2, 0, 1},
                    {0, 2, 1},
                    {2, 0, 1}};
        StableMatch match = new StableMatch(m, w);
        int[] result = match.findMatching();
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + ", ");
        }
        System.out.println("\n===================================================================================\n");

        int[][] m1 = {{3, 1, 0, 2},
                    {3, 0, 1, 2},
                    {3, 1, 2, 0},
                    {0, 3, 2, 1}};
        int[][] w1 = {{3, 0, 2, 1},
                    {3, 1, 2, 0},
                    {0, 1, 3, 2},
                    {3, 0, 2, 1}};

        match = new StableMatch(m1, w1);
        result = match.findMatching();
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + ", ");
        }
        System.out.println("\n===================================================================================\n");

        int[][] m2 = {{1, 3, 0, 2},
                {3, 0, 2, 1},
                {2, 3, 1, 0},
                {2, 0, 3, 1}};
        int[][] w2 = {{1, 2, 0, 3},
                {0, 3, 2, 1},
                {1, 2, 3, 0},
                {0, 1, 2, 3}};

        match = new StableMatch(m2, w2);
        result = match.findMatching();
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + ", ");
        }
        System.out.println("\n===================================================================================\n");

        int[][] m3 = {{4, 2, 0, 1, 3},
                {0, 1, 4, 2, 3},
                {4, 0, 1, 3, 2},
                {1, 4, 3, 0, 2},
                {0, 1, 3, 4, 2}};
        int[][] w3 = {{2, 3, 4, 0, 1},
                {2, 4, 0, 3, 1},
                {1, 4, 2, 3, 0},
                {3, 0, 1, 4, 2},
                {0, 3, 1, 2, 4}};

        match = new StableMatch(m3, w3);
        result = match.findMatching();
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + ", ");
        }
        System.out.println("\n===================================================================================\n");

        int[][] m4 = {{2, 1, 3, 0},
                {0, 1, 3, 2},
                {0, 1, 2, 3},
                {0, 1, 2, 3}};
        int[][] w4 = {{0, 2, 1, 3},
                {2, 0, 3, 1},
                {3, 2, 1, 0},
                {2, 3, 1, 0}};

        match = new StableMatch(m4, w4);
        result = match.findMatching();
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + ", ");
        }
        System.out.println("\n===================================================================================\n");
    }
}

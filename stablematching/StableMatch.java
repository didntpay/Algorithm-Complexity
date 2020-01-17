package stablematching;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class StableMatch {
    //M proposal algorithm
    private Map<Integer, Integer> mRank;
    private Map<Integer, Integer> mCounter;
    private int[][] M;
    private int[][] W;

    /******************
     * Initialize a stable match object
     * @param m
     * @param w
     */
    public StableMatch(int[][] m, int[][] w){
        this.mRank = new HashMap<>();
        this.mCounter = new HashMap<>();
        this.M = m;
        this.W = w;
        for (int i = 0; i < m.length; i++){
            mCounter.put(i, 0);
        }
    }


    public int[] findMatching(){
        System.out.println("Trace\n");
        //returns an array of connected m and w
        //where int[0] = the w connected with m1
        int[] result = new int[this.M.length];
        int[] realResult = new int[this.M.length];
        int rowCounter = 1;

        Queue<Integer> order = new LinkedList<>();

        for (int i = 0; i < this.M.length; i++){
            result[i] = -1;
            order.add(i);
        }

        while (!order.isEmpty()){
            int mi = order.poll();
            int wi = this.M[mi][mCounter.get(mi)];
            System.out.print("M" + mi + " is proposing to W" + wi);
            if (!this.mRank.containsKey(wi)){
                realResult[mi] = wi;
                System.out.println(" Accepted");
                this.mRank.put(wi, indexOfM(wi, mi));
            }
            else {
                int ranking = indexOfM(wi, mi);
                if (ranking < this.mRank.get(wi)) {
                    int disconnectedM = this.W[wi][this.mRank.get(wi) - 1];
                    mCounter.put(disconnectedM, mCounter.get(disconnectedM) + 1);
                    order.add(disconnectedM);
                    realResult[mi] = wi;
                    this.mRank.put(wi, ranking);
                    System.out.println(" Accepted");
                }
                else {
                    order.add(mi);
                    mCounter.put(mi, mCounter.get(mi) + 1);
                    System.out.println(" Rejected");
                }

            }
        }
        System.out.println("");
        return realResult;
    }

    /**********************************************************
     * returns the index of Mi in the preference list of Wi, which represent the rank of Mi to Wi
     * @param index The ith W
     * @param target The ith M
     * @return the index of Mi in the preference list of Wi
     **********************************************************/
    private int indexOfM(int index, int target){
        for (int i = 0; i < this.W[index].length; i++){
            if (this.W[index][i] == target){
                return i + 1;
            }
        }
        return -1;
    }

    public double mGoodNess(int[] solution){
        double totalMRank = 0;
        for (int i = 0; i < solution.length; i++){
            totalMRank += this.mCounter.get(i) + 1;
        }
        return totalMRank / solution.length;
    }

    public double wGoodNess(int[] solution){
        double totalWRank = 0;
        for (int i = 0; i < solution.length; i++){
            totalWRank += this.mRank.get(i);
        }
        return totalWRank / solution.length;
    }

}

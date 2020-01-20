package couponcollector;

import java.util.HashMap;
import java.util.Random;
import java.util.Map;

public class CouponCollectorVT {
    private int size;
    private int[] couponsID;
    private int currentSetSize;
    private int currentUniqueSize;
    private int currentSize;
    private Map<Integer, Integer> currentCoupons;

    public CouponCollectorVT(int setSize){
        this.size = setSize;
        this.couponsID = new int[this.size];
        this.currentCoupons = new HashMap<>();
        for (int i = 0; i < setSize; i++) {
            couponsID[i] = i;
        }
    }

    public void nextCoupon(){
        Random r = new Random();
        int couponID = r.nextInt(this.size);
        int couponWeight = r.nextInt(this.size) + 1;
        if (!this.currentCoupons.containsKey(couponID)){
            this.currentSetSize++;
            this.currentCoupons.put(couponID, couponWeight);
        }
        else if (couponWeight < this.currentCoupons.get(couponID)){
            this.currentCoupons.put(couponID, couponWeight);
        }
        this.currentSize++;
    }

    public boolean completed(){
        return this.currentSetSize == this.size;
    }

    public int getCurrentSize(){
        return this.currentSize;
    }

    public int getFinishedValue(){
        int total = 0;
        for (int i = 0; i < couponsID.length; i++){
            total += this.currentCoupons.get(couponsID[i]);
        }
        return total;
    }


}

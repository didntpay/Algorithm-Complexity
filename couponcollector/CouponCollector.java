package couponcollector;


import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class CouponCollector {
    private int size;
    private int currentSetSize;
    private int currentUniqueSize;
    private int currentSize;
    private Set<Integer> currentCoupons;

    public CouponCollector(int setSize){
        this.size = setSize;
        this.currentCoupons = new HashSet<>();
    }

    public void nextCoupon(){
        Random r = new Random();
        int couponID = r.nextInt(this.size);
        if (!this.currentCoupons.contains(couponID)){
            this.currentSetSize++;
            this.currentCoupons.add(couponID);
        }
        this.currentSize++;
    }

    public boolean completed(){
        return this.currentSetSize == this.size;
    }

    public int getCurrentSize(){
        return this.currentSize;
    }
}

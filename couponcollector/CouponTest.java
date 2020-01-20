package couponcollector;
import org.junit.Test;

public class CouponTest {
    @Test
    public void testCouponCollector(){
        int[] testSize = {1, 2, 5, 10, 20, 50, 100, 200, 300, 500, 750, 1000, 1250, 1500, 1750, 2000, 2250, 2500,
                2750, 3000, 3250, 3500, 3750, 4000, 4250, 4500, 4750, 5000};
        for (int i = 0; i < testSize.length; i++){
            int average = 0;
            for (int j = 0; j < 100; j++){
                CouponCollector pool = new CouponCollector(testSize[i]);
                while (!pool.completed()){
                    pool.nextCoupon();
                }
                average += pool.getCurrentSize();
            }
            System.out.print(testSize[i] + "\t");
            System.out.println(average / 100);
        }
    }

    @Test
    public void testCouponCollectorVT(){
        int[] testSize = {1, 2, 5, 10, 20, 50, 100, 200, 300, 500, 750, 1000, 1250, 1500, 1750, 2000, 2250, 2500,
                2750, 3000, 3250, 3500, 3750, 4000, 4250, 4500, 4750, 5000};
        for (int i = 0; i < testSize.length; i++){
            int average = 0;
            for (int j = 0; j < 100; j++){
                CouponCollectorVT pool = new CouponCollectorVT(testSize[i]);
                while (!pool.completed()){
                    pool.nextCoupon();
                }
                average += pool.getFinishedValue();
            }
            System.out.print(testSize[i] + "\t");
            System.out.println(average / testSize[i] / 100);
        }
    }
}

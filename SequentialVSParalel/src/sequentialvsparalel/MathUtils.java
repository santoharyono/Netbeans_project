/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sequentialvsparalel;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.DoubleStream;

/**
 *
 * @author Santo_HW432
 */
public class MathUtils {
    private static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
    
    // JAVA 7
//    public static double arraySum(double[] nums, int lowerIndex, int upperIndex) {
//        double sum = 0;
//        for (int i = lowerIndex; i <= upperIndex; i++) {
//            sum += nums[i];
//        }
//        
//        return sum;
//    }
//    
//    public static double arraySum(double[] nums) {
//        return (arraySum(nums, 0, nums.length - 1));
//    }
    
    // JAVA 8
    public static double arraySum(double[] nums) {
        return (DoubleStream.of(nums).sum());
    }
    
    public static Double arraySumParallel(double[] nums) {
        // JAVA 7
//        return (FORK_JOIN_POOL.invoke(new ParallelArraySummer(nums, 0, nums.length-1)));
        
        // JAVA 8
        return (DoubleStream.of(nums).parallel().sum());
    }
    
    public static double[] randomNums1(int length) {
        double[] nums = new double[length];
        for(int i = 0; i < length; i++) {
            nums[i] = Math.random();
        }
        
        return (nums);
    }
}

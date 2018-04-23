/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.parallelarrayprocessor;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author Santo_HW432
 */
public class MathUtils {
    public static Double arraySumParallel(Double[] nums) {
        int parallelSizeCutoff = 1000;
        SequentialArrayProcessor<Double, Double> smallSizeProcessor = new ArrayAdder();
        Combiner<Double> valueCombiner = new Adder();
        ForkJoinPool pool = ParallelArrayProcessor.FORK_JOIN_POOL;
        ParallelArrayProcessor<Double, Double> processor = new ParallelArrayProcessor<>(nums, parallelSizeCutoff, smallSizeProcessor, valueCombiner, 0, nums.length-1);
        
        return (pool.invoke(processor));
    }
    
    public static Double arraySum(Double[] nums, int lowerIndex, int highIndex) {
        double sums = 0;
        for (int i = lowerIndex; i <= highIndex; i++) {
            sums += nums[i];
        }
        
        return (sums);
    }
    
    public static Double arraySum(Double[] nums) {
        return (arraySum(nums, 0, nums.length-1));
    }
    
    public static Double[] randomNums(int length) {
        Double[] nums = new Double[length];
        for (int i = 0; i<length; i++) {
            nums[i] = Math.random();
        }
        
        return (nums);
    }
}

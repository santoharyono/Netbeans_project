/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.parallelarrayprocessor;

/**
 *
 * @author Santo_HW432
 */
public class TimingUtils {
    private static final double ONE_BILLION = 1000000000;
    
    public static void timeOp(Op operation) {
        long startTime = System.nanoTime();
        String resultMessage = operation.runOp();
        long endTime = System.nanoTime();
        System.out.println(resultMessage);
        double elapsedTime = (endTime - startTime)/ONE_BILLION;
        System.out.printf("Elapsed time : %.3f seconds%n", elapsedTime);
    }
}

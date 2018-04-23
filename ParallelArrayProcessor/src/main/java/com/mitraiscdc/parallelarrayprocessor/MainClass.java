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
public class MainClass {

    public static void main(String[] args) {
        String message1 = "Sequential sum of %,d numbers is %,.4f.";
        String message2 = "Parallel sum of %,d numbers is %,.4f.";

        for (int i = 3; i < 9; i++) {
            int arraySize = (int) Math.pow(10, i) / 2;
            Double[] nums = MathUtils.randomNums(arraySize);
            TimingUtils.timeOp(new Op() {
                @Override
                public String runOp() {
                    double sum = MathUtils.arraySum(nums);
                    return (String.format(message1, arraySize, sum));
                }
            });

            TimingUtils.timeOp(new Op() {
                @Override
                public String runOp() {
                    double sum = MathUtils.arraySumParallel(nums);
                    return (String.format(message2, arraySize, sum));
                }
            });
        }
    }
}

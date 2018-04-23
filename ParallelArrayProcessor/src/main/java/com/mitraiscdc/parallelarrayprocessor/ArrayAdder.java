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
public class ArrayAdder implements SequentialArrayProcessor<Double, Double>{

    @Override
    public Double computeValue(Double[] values, int lowerIndex, int highIndex) {
        return (MathUtils.arraySum(values, lowerIndex, highIndex));
    }
    
}

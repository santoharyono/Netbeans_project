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
public class Adder implements Combiner<Double>{

    @Override
    public Double combine(Double val1, Double val2) {
        return (val1 + val2);
    }
    
}

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
public interface Combiner<R> {
    R combine(R val1, R val2);
}

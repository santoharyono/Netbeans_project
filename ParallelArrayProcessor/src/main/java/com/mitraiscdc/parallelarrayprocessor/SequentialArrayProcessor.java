/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.parallelarrayprocessor;

/**
 *
 * @author Santo_HW432
 * @param <T>
 * @param <R>
 */
public interface SequentialArrayProcessor<T, R> {
    R computeValue(T[] values, int lowerIndex, int highIndex);
}

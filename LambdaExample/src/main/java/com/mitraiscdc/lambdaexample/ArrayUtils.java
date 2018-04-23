/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.lambdaexample;

import java.util.Arrays;

/**
 *
 * @author Santo_HW432
 */
public class ArrayUtils {
    public static <T> void printArray(T[] entries) {
        System.out.println(Arrays.asList(entries));
    }
}

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
public class StringSorter1 {
    
    public static void main(String[] args) {
        StringSorter1.doTests();
    }
    
    public static void doTests() {
        String[] testStrings = {"One", "Two", "Three", "Four", "Five", "Six" };
        System.out.println("Original: ");
        ArrayUtils.printArray(testStrings);
        
        // using java 7
//        Arrays.sort(testStrings, new StringLengthComparator());
        // using java 8 (lambda expression)
        Arrays.sort(testStrings, (s1, s2) -> s1.length() - s2.length());
        System.out.println("After sorting by length: ");
        ArrayUtils.printArray(testStrings);
        
        // using java 7
//        Arrays.sort(testStrings, new LastLetterComparator());
        
        // using java 8 (lambda expression)
        Arrays.sort(testStrings, (s1, s2) -> s1.charAt(s1.length() -1) - s2.charAt(s2.length()-1));
        System.out.println("After sorting by last letter: ");
        ArrayUtils.printArray(testStrings);
    }
}

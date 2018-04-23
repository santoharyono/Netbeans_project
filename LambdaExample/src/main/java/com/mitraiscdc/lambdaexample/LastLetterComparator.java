/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitraiscdc.lambdaexample;

import java.util.Comparator;

/**
 *
 * @author Santo_HW432
 */
public class LastLetterComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return (o1.charAt(o1.length() -1) - o2.charAt(o2.length() - 1));
    }
    
}

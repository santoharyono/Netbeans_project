/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forkjoin;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Santo_HW432
 */
public class Solver extends RecursiveAction {

    private int[] list;
    public long result;

    public Solver(int[] list) {
        this.list = list;
    }
        
    @Override
    protected void compute() {
        if (list.length == 1) {
            result = list[0];
        } else {
            int midpoint = list.length / 2;
            int[] i1 = Arrays.copyOfRange(list, 0, midpoint);
            int[] i2 = Arrays.copyOfRange(list, midpoint, list.length);
            Solver s1 = new Solver(i1);
            Solver s2 = new Solver(i2);
        }
    }
    
}

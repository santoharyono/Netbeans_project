/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadedexample;

import java.util.concurrent.Callable;

/**
 *
 * @author Santo_HW432
 */
public class MyCallable implements Callable<Long>{

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (long i = 0; i <= 100; i++) {
            sum += i;
        }
        
        return sum;
    }
    
}

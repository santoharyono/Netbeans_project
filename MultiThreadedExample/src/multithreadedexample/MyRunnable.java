/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadedexample;

/**
 *
 * @author Santo_HW432
 */
public class MyRunnable implements Runnable{
    private final long countUntil;

    public MyRunnable(long countUntil) {
        this.countUntil = countUntil;
    }
    
    @Override
    public void run() {
        long sum = 0;
        for (long i = 0; i < countUntil; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
    
}

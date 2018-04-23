/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadedexample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Santo_HW432
 */
public class MultiThreadedExample {

    /**
     * @param args the command line arguments
     */
    private static final int NTHREADS = 10;

    public static void main(String[] args) {
        // TODO code application logic here
//        RaceCondition race = new RaceCondition();
        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
        List<Future<Long>> list = new ArrayList<Future<Long>>();

        for (int i = 0; i < 20000; i++) {
            Callable<Long> worker = new MyCallable();
            Future<Long> submit = executor.submit(worker);
            list.add(submit);
        }

        long sum = 0;
        System.out.println(list.size());

//        retrieve the result
        for (Future<Long> future : list) {
            try {
                sum += future.get();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            } catch (ExecutionException ee) {
                ee.printStackTrace();
            }
        }
        System.out.println(sum);
        executor.shutdown();
        
//        for (int i = 0; i < 500; i++) {
//            Runnable worker = new MyRunnable(10000000L + i);
//            executor.execute(worker);
//        }
//        executor.shutdown();
//        try {
//            executor.awaitTermination(1, TimeUnit.HOURS);
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }
//
//        System.out.println("Finished all threads");
    }

}

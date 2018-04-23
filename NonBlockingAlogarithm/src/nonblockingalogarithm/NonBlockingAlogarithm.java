/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonblockingalogarithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Santo_HW432
 */
public class NonBlockingAlogarithm {

    /**
     * @param args the command line arguments
     */
    private static final int NTHREADS = 10;

    public static void main(String[] args) {
        // TODO code application logic here
        final Counter counter = new Counter();
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();

        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
        for (int i = 0; i < 500; i++) {
            Callable<Integer> worker = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int number = counter.increment();
                    System.out.println(number);
                    return number;
                }
            };
            Future<Integer> submit = executor.submit(worker);
            list.add(submit);
        }

        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()) {            
            
        }
        Set<Integer> set = new HashSet<Integer>();
        for (Future<Integer> future : list) {
            try {
                set.add(future.get());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        }
        
        if (list.size() != set.size()) {
            throw new RuntimeException("Double Entries");
        }
    }

}

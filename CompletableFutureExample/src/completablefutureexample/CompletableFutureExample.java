/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package completablefutureexample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Santo_HW432
 */
public class CompletableFutureExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long started = System.currentTimeMillis();

//        configure completablefuture
        CompletableFuture<Integer> futureCount = createCompletableFuture();

//        continue to do other work
        System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds");

//        now its time to get the result
        try {
            int count = futureCount.get();
            System.out.println("CompletableFuture took " + (started - System.currentTimeMillis()) + " milliseconds");
            System.out.println("Result " + count);
        } catch (InterruptedException | ExecutionException ex) {

        }
    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) { }
                    return 20;
                });
        return futureCount;
    }

}

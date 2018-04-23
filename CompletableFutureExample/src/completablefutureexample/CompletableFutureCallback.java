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
public class CompletableFutureCallback {
    
    public static void main(String[] args) {
        long started = System.currentTimeMillis();
        
        CompletableFuture<String> data = createCompletableFuture()
                .thenApply((Integer count) -> {
                    int transformedValue = count * 10;
                    return transformedValue;
                })
                .thenApply(transformed -> "Finally create a String " + transformed);
        
        try {
            System.out.println(data.get());
        } catch (InterruptedException | ExecutionException ex) {
            
        }
    }
    
    public static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                
            }
            return 20;
        });
        
        return result;
    }
    
//    public static CompletableFuture<Integer> createCompletableFuture() {
//        CompletableFuture<Integer>  result = CompletableFuture.supplyAsync(() -> {
//            try {
//                // simulate long running task
//                Thread.sleep(5000);
//            } catch (InterruptedException e) { }
//            return 20;
//        });
//        return result;
//    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonblockingalogarithm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Santo_HW432
 */
public class Counter {
    private AtomicInteger value = new AtomicInteger();
    
    public int getValue() {
        return value.get();
    }
    
    public int increment() {
        return value.incrementAndGet();
    }
    
    // Alternative implementation as increment but just make the
    // implementation explicit
    public int incrementLongVersion() {
        int oldValue = value.get();
        while (!value.compareAndSet(oldValue, oldValue+1)) {            
            oldValue = value.get(); 
        }
        return oldValue+1;
    }
}

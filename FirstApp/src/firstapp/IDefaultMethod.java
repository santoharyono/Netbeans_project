/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstapp;

/**
 *
 * @author Santo_HW432
 */
public interface IDefaultMethod {
    default void foo(){
        System.out.println("calling default method IDefaultMethod.foo()");
    }
}

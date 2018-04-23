/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santo_HW432
 */
public class FamilyBL implements IDefaultMethod{
    
    public static List<Family> findFamily(List<Family> families, IFamilyPredicate predicate) {
        List<Family> result = new ArrayList<>();
        families.forEach((family)-> {
            if(predicate.test(family)) {
                result.add(family);
            }
        });
        return result;
    }
    
//    @Override
//    public void foo() {
//        System.out.println("override and calling foo() method");
//    }
}

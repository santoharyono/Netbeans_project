/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstapp;

import static java.time.temporal.ChronoUnit.YEARS;
import java.util.ArrayList;
import static java.util.Comparator.comparing;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Santo_HW432
 */
public class FirstApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Family> families = new ArrayList<>();
        
//        Add employee records
        families.add(new Family("Santo", new Date(1981, 01, 24)));
        families.add(new Family("Mayla", new Date(2009, 05, 23)));
        families.add(new Family("Euis", new Date(1988, 11, 24)));
        
//        families.sort(Comparator.comparing(Family::getName));
//        
//        families.forEach((family) -> {
//            System.out.printf("%s age is %d years old%n", family.getName(), 
//                    LocalDate.of(family.getDateOfBirth().getYear(), family.getDateOfBirth().getMonth(), family.getDateOfBirth().getDate())
//                            .until(LocalDate.now(), YEARS));
//            System.out.println(family.getDateOfBirth().getYear());
//        });
//        
//        List<Family> spesificFamily = FamilyBL.findFamily(families, family -> 
//                family.getName().contains("E") && family.getDateOfBirth().getYear() < 2000);
//        
//        System.out.println("\nFind Spesific family where birthdate under 2000");
//        spesificFamily.forEach((specFam) -> {
//            System.out.println(specFam.getName());
//        });

boolean familyName = families.stream()
//        .filter(family -> family.getDateOfBirth().getYear() < 2000 && family.getName().contains("a"))
        .allMatch(family -> family.getName() == "Santo");
//        .sorted(comparing(Family::getName))
//        .map(Family::getName)
//        .collect(Collectors.toList());

        System.out.println(familyName);
//familyName.forEach(name -> {
//    System.out.println(name);
//});
        
        FamilyBL fbl = new FamilyBL();
        fbl.foo();
    }
    
    
    
}

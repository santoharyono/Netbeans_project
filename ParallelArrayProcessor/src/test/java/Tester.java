
import com.mitraiscdc.parallelarrayprocessor.MathUtils;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santo_HW432
 */
public class Tester {
    @Test
    public void testSums() {
        for (int i = 0; i < 5; i++) {
            int arraySize = (int)Math.pow(10, i);
            Double[] nums = MathUtils.randomNums(arraySize);
            double sum1 = MathUtils.arraySum(nums);
            double sum2 = MathUtils.arraySumParallel(nums);
            System.out.println("sum1 :" + sum1);
            System.out.println("sum2 :" + sum2);
            assertEquals(Math.round(sum1), Math.round(sum2));
        }
    }
}

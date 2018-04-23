
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sequentialvsparalel.MathUtils;
import sequentialvsparalel.Op;
import sequentialvsparalel.TimingUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Santo_HW432
 */
public class Tester1 {

    @Test
    public void testSums() {
        for (int i = 0; i < 5; i++) {
            int arraySize = (int) Math.pow(10, i);
            double[] nums = MathUtils.randomNums1(arraySize);
            double sum1 = MathUtils.arraySum(nums);
            double sum2 = MathUtils.arraySumParallel(nums);
            assertEquals(Math.round(sum1), Math.round(sum2));
        }
    }
}

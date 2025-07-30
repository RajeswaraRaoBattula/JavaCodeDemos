/*
 * Given integer array, remove the duplicate elements and print sum of even 
numbers in the array.
input 1={2,3,54,1,6,7,7}
 */
package myjavacodes;
import java.util.*;

public class SumOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr12 = {2, 3, 54, 1, 6, 7, 7};

        // Step 1: Use Set to remove duplicates
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : arr12) {
            uniqueSet.add(num);
        }

        // Step 2: Sum even numbers
        int sum = 0;
        for (int num : uniqueSet) {
            if (num % 2 == 0) {
                sum += num;
            }
        }

        // Step 3: Print result
        System.out.println("Sum of even numbers (no duplicates): " + sum);
    }
}

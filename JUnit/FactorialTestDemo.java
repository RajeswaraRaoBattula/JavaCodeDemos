/*
 * Write a test class that checks if the method returns correct factorials for 
 * valid inputs and throws IllegalArgumentException for negative numbers.
 */
package myjunitdemos;
import org.junit.Test;
import static org.junit.Assert.*;

class Factorial {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative number: " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}


public class FactorialTestDemo {

	    @Test
	    public void testFactorialValidInputs() {
	        assertEquals(1, Factorial.factorial(0));
	        assertEquals(1, Factorial.factorial(1));
	        assertEquals(2, Factorial.factorial(2));
	        assertEquals(6, Factorial.factorial(3));
	        assertEquals(24, Factorial.factorial(4));
	        assertEquals(120, Factorial.factorial(5));
	        assertEquals(3628800, Factorial.factorial(10));
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testFactorialNegativeInputThrowsException() {
	    	Factorial.factorial(-5);
	    }
	}

/*
 * Scenario: You have a method divide(int a, int b) which throws IllegalArgumentException if b == 0.

Use assertThrows to test this.
 */

package myjunitdemos;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testDivideByZero_ThrowsException() {
        Calculator calculator = new Calculator();

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Divider cannot be zero");

        calculator.divide(10, 0);
    }
}


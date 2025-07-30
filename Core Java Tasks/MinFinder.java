/*
 * .Write a interface method minimum3 that returns the smallest of three floating-point numbers. Use the Math.min method
to implement minimum3. Incorporate the method into an application that reads three values from the user, 
determines the smallest value and displays the result. Use method references syntax.

 */
package myjavacodes;

import java.util.Scanner;

@FunctionalInterface
interface MinimumFinder {
    float minimum3(float a, float b, float c);
}

public class MinFinder {
    // Static method to find minimum of 3 using Math.min
    public static float findMinimum(float a, float b, float c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read 3 float values from user
        System.out.print("Enter first number: ");
        float num1 = sc.nextFloat();

        System.out.print("Enter second number: ");
        float num2 = sc.nextFloat();

        System.out.print("Enter third number: ");
        float num3 = sc.nextFloat();

        // Method reference to the static method
        MinimumFinder minFinder = MinFinder::findMinimum;

        // Use the interface to get the minimum
        float result = minFinder.minimum3(num1, num2, num3);

        System.out.println("The smallest value is: " + result);

        sc.close();
    }
}

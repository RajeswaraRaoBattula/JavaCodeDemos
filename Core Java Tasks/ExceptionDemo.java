/*
 * Write a program to demonstrate the InputMismatchException and StringIndexOutOfBoundsException.
 */

package myjavacodes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Demonstrate InputMismatchException
            System.out.print("Enter an integer: ");
            int number = sc.nextInt();  // will throw InputMismatchException if input is not an integer
            System.out.println("You entered: " + number);
            
            // Clear buffer before reading string
            sc.nextLine();

            // Demonstrate StringIndexOutOfBoundsException
            System.out.print("Enter a string: ");
            String text = sc.nextLine();

            System.out.print("Enter the index to access: ");
            int index = sc.nextInt();

            char ch = text.charAt(index);  // will throw StringIndexOutOfBoundsException if index is invalid
            System.out.println("Character at index " + index + ": " + ch);

        } catch (InputMismatchException e) {
            System.out.println("Caught InputMismatchException: Please enter the correct data type.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: Index is out of bounds.");
        } finally {
            sc.close();
        }
    }
}

/*
 * Read the Register Number and Mobile Number of a student. If the Register Number does not contain exactly 9 characters or 
 * if the Mobile Number does not contain exactly 10 characters, throw an IllegalArgumentException. 
 * If the Mobile Number contains any character other than a digit, raise a NumberFormatException. 
 * If the Register Number contains any character other than digits and alphabets, throw a NoSuchElementException. 
 * If they are valid, print the message ‘valid’ else ‘invalid’
 */
package myjavacodes;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Read inputs
            System.out.print("Enter Register Number: ");
            String regNo = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobileNo = sc.nextLine();

            // Validate Register Number length
            if (regNo.length() != 9) {
                throw new IllegalArgumentException("Register Number must be exactly 9 characters.");
            }

            // Validate Register Number contains only letters and digits
            if (!regNo.matches("[a-zA-Z0-9]+")) {
                throw new NoSuchElementException("Register Number must contain only letters and digits.");
            }

            // Validate Mobile Number length
            if (mobileNo.length() != 10) {
                throw new IllegalArgumentException("Mobile Number must be exactly 10 digits.");
            }

            // Validate Mobile Number is numeric only
            if (!mobileNo.matches("[0-9]+")) {
                throw new NumberFormatException("Mobile Number must contain only digits.");
            }

            // All validations passed
            System.out.println("valid");

        } catch (IllegalArgumentException  | NoSuchElementException e) {
            System.out.println("invalid");
        } finally {
            sc.close();
        }
    }
}

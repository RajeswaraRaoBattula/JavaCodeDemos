/*
 * Write the following methods that return a lambda expression performing a specified action:

PerformOperation isOdd(): The lambda expression must return true  if a number is odd or false  if it is even.
PerformOperation isPrime(): The lambda expression must return  true if a number is prime or false  if it is composite.
PerformOperation isPalindrome(): The lambda expression must return true   if a number is a palindrome or false  if it is not.
 */
package myjavacodes;
import java.util.Scanner;

interface PerformOperation {
    boolean check(int a);
}

public class LambdaExprDemo {

    // Method to return a lambda that checks if number is odd
    public static PerformOperation isOdd() {
        return (int a) -> a % 2 != 0;
    }

    // Method to return a lambda that checks if number is prime
    public static PerformOperation isPrime() {
        return (int a) -> {
            if (a <= 1) return false;
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    // Method to return a lambda that checks if number is palindrome
    public static PerformOperation isPalindrome() {
        return (int a) -> {
            String original = Integer.toString(a);
            String reversed = new StringBuilder(original).reverse().toString();
            return original.equals(reversed);
        };
    }

    // Tester method
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        PerformOperation odd = isOdd();
        PerformOperation prime = isPrime();
        PerformOperation palindrome = isPalindrome();
    
        System.out.println("Number: " + num);
        System.out.println("Is Odd? " + odd.check(num));
        System.out.println("Is Prime? " + prime.check(num));
        System.out.println("Is Palindrome? " + palindrome.check(num));
        System.out.println();
        sc.close();
    }
}

/*
 * Create an enum of the six types of paper currency. Loop through the values( ) and print each value. 
 * Write a switch statement for the enum.  For each
   case, output a description of that particular currency.
 */
package myjavacodes;

public class CurrencyDemo {

    // Step 1: Define the enum
    enum Currency{
    	FIVE, TEN, TWENTY, FIFTY, HUNDRED, FIVEHUNDRED
    }

    public static void main(String[] args) {
        // Step 2: Loop through the enum values and print
        System.out.println("Available Currency Types:");
        for (Currency c : Currency.values()) {
            System.out.println("- " + c);

            // Step 3: Switch statement to describe each currency
            switch (c) {
                case FIVE:
                    System.out.println("The FIVE rupee note is in green color.");
                    break;
                case TEN:
                    System.out.println("The TEN rupee note is in brown color.");
                    break;
                case TWENTY:
                    System.out.println("The TWENTY rupee note is in orange color.");
                    break;
                case FIFTY:
                    System.out.println("The FIFTY rupee note is in blue  color.");
                    break;
                case HUNDRED:
                    System.out.println("The HUNDRED rupee note is in purple color.");
                    break;
                case FIVEHUNDRED:
                	System.out.println("The FIVEHUNDRED rupee note is in green color.");
                    break;
                	
            }
            System.out.println();
        }
    }
}

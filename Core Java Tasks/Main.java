/*
 * Create a Package called house. Create 2 classes namely Hall and Kitchen.

1.  In the Hall class print the message “This is the first room while entering the house” without using 
    the class name System explicitly in the println statement.
2. In the Kitchen class create an array called appliances and initialize with values and print the same. 
3. After printing copy that array into a different array.
 */
package house;
import java.util.Scanner;
import java.util.Arrays;

class Kitchen{
	
	public void show() {
        String[] appliances = {"Fridge", "Oven", "Microwave", "Blender"};
        
        System.out.println("Kitchen Appliances:");
        for (String app : appliances) {
            System.out.println(app);
        }

        // Copy array
        String[] copyAppliances = Arrays.copyOf(appliances, appliances.length);
        
        System.out.println("\nCopied Appliances Array:");
        for (String app : copyAppliances) {
            System.out.println(app);
        }
    }
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kitchen k=new Kitchen();
		k.show();
	}
}
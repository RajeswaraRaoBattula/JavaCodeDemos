/*
 * Create an object called employee whose attributes are emp_id, emp_name and emp_sal.  
 * Write a program to Serialize and deserialize the employee object except for the emp_sal attribute.
 * (Use Scanner class to  get the input from the user).
 */
package myjavacodes;

import java.io.Serializable;
import java.io.*;
import java.util.Scanner;


class Employeee implements Serializable {
    private int emp_id;
    private String emp_name;
    private transient double emp_sal; // not serialized

    public Employeee(int emp_id, String emp_name, double emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sal = emp_sal;
    }

    public void display() {
        System.out.println("Employee ID   : " + emp_id);
        System.out.println("Employee Name : " + emp_name);
        System.out.println("Employee Salary (Not Serialized): " + emp_sal);
    }
}


public class SerializeDeserializeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner scanner = new Scanner(System.in);
        String filename = "employee.ser";

        try {
            // Input employee details
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Employee Salary: ");
            double salary = scanner.nextDouble();

            // Create employee object
            Employeee emp = new Employeee(id, name, salary);

            // Serialize the object
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(emp);
            oos.close();
            System.out.println("\n✅ Employee object serialized to " + filename);

            // Deserialize the object
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            Employeee deserializedEmp = (Employeee) ois.readObject();
            ois.close();

            // Display deserialized object
            System.out.println("\n📄 Deserialized Employee Details:");
            deserializedEmp.display();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            scanner.close();
        }

	}

}

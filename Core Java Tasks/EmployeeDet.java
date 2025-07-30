/*
 * Write a program to read the employee details and validate the employee code.
 * If the employee code is incorrect throw a user-defined exception"InvalidEmployeeCode" else
 *  create the Employee object and display the detailsof the employee.
 */
package myjavacodes;
import java.util.Scanner;

class InvalidEmployeeCode extends Exception {
    public InvalidEmployeeCode(String message) {
        super(message);
    }
}

class EmployeeD {
    private String employeeCode;
    private String name;
    private int age;

    public EmployeeD(String employeeCode, String name, int age) {
        this.employeeCode = employeeCode;
        this.name = name;
        this.age = age;
    }

    public void printDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee Code : " + employeeCode);
        System.out.println("Name          : " + name);
        System.out.println("Age           : " + age);
    }
}


public class EmployeeDet {
	 public static boolean isValidCode(String code) {
	        return code.matches("\\d{2}-[FS]-\\d+");
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        try {
            // Read inputs
            System.out.print("Enter Employee Code: ");
            String code = scanner.nextLine();

            if (!isValidCode(code)) {
                throw new InvalidEmployeeCode("Invalid Employee Code format. Expected: yy-F/S-xxx");
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            // Create and display employee
            Employee emp = new Employee(code, name, age);
            emp.printDetails();

        } catch (InvalidEmployeeCode e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e);
        } finally {
            scanner.close();
        }
    }

}

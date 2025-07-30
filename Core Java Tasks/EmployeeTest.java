package myjavacodes;
import java.util.Scanner;
class LowSalException extends Exception {
    public LowSalException(String message) {
        super(message);
    }
}

class Emp {
    private int empId;
    private String empName;
    private String designation;
    private double basic;
    private final double hra; // Read-only

    // Constructor
    public Emp(int empId, String empName, String designation, double basic) throws LowSalException {
        if (basic < 50000) {
            throw new LowSalException("Basic salary cannot be less than 50000.");
        }

        this.empId = empId;
        this.empName = empName;
        this.designation = designation;
        this.basic = basic;
        this.hra = calculateHRA(); // Set only once
    }

    // Method to calculate HRA based on designation
    private double calculateHRA() {
        switch (designation.toLowerCase()) {
            case "manager":
                return basic * 0.10;
            case "teamleader":
                return basic * 0.12;
            case "hr":
                return basic * 0.05;
            default:
                return 0.0;
        }
    }

    // Method to print employee details
    public void printDET() {
        System.out.println("Employee ID     : " + empId);
        System.out.println("Employee Name   : " + empName);
        System.out.println("Designation     : " + designation);
        System.out.println("Basic Salary    : " + basic);
        System.out.println("HRA             : " + hra);
    }
}
public class EmployeeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input employee details
            System.out.print("Enter Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Designation (Manager / TeamLeader / HR): ");
            String designation = scanner.nextLine();

            System.out.print("Enter Basic Salary: ");
            double basic = scanner.nextDouble();

            // Create employee object
            Emp emp = new Emp(id, name, designation, basic);

            // Print employee details
            emp.printDET();

        } catch (LowSalException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e);
        } finally {
            scanner.close();
        }
    }
}


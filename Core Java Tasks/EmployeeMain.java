package myjavacodes;

class Employee {
    private String employeeId; // format: yy-designation-num
    private String name;
    private int yearOfBirth;

    // Constructor
    public Employee(String employeeId, String name, int yearOfBirth) {
        if (!isValidEmployeeId(employeeId)) {
            throw new IllegalArgumentException("Invalid Employee ID format. Expected format: yy-F/S-num");
        }
        this.employeeId = employeeId;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    // Method to validate Employee ID format
    private boolean isValidEmployeeId(String id) {
        return id.matches("\\d{2}-[FS]-\\d+");  // e.g., 23-F-001 or 22-S-123
    }

    // Method to display employee details
    public void printDetails() {
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Name          : " + name);
        System.out.println("Year of Birth : " + yearOfBirth);

        char designationCode = employeeId.charAt(3); // character after "yy-"
        String designation = (designationCode == 'F') ? "Faculty" :
                             (designationCode == 'S') ? "Staff" : "Unknown";
        System.out.println("Designation   : " + designation);
    }
}

public class EmployeeMain {

	public static void main(String[] args) {
        try {
            Employee emp1 = new Employee("23-F-001", "Alice", 1990);
            emp1.printDetails();

            System.out.println();

            Employee emp2 = new Employee("22-S-123", "Bob", 1985);
            emp2.printDetails();

            // Uncomment to see format validation in action
            // Employee emp3 = new Employee("2023-X-999", "Invalid", 1980); // Will throw exception

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}

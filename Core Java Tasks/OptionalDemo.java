/*
 * Create a class Employee with optional fields for email and department. Use Optional to:

	Safely access employee details.
	
	Provide default values when data is absent.
	
	Throw custom exceptions if required fields are missing.
 */

package myjavacodes;
import java.util.Optional;

class MissingFieldException extends RuntimeException {
    public MissingFieldException(String message) {
        super(message);
    }
}


class Employe {
    private int id;
    private String name;
    private Optional<String> email;
    private Optional<String> department;

    public Employe(int id, String name, Optional<String> email, Optional<String> department) {
        this.id = id;
        this.name = name;
        this.email = email != null ? email : Optional.empty();
        this.department = department != null ? department : Optional.empty();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public Optional<String> getEmail() { return email; }
    public Optional<String> getDepartment() { return department; }
}


public class OptionalDemo {
    public static void main(String[] args) {
        // Employee with missing email
        Employe emp1 = new Employe(101, "Anu", Optional.empty(), Optional.of("HR"));

        // Employee with full details
        Employe emp2 = new Employe(102, "Raja", Optional.of("raja@example.com"), Optional.of("IT"));

        // Employee with missing department
        Employe emp3 = new Employe(103, "Charan", Optional.of("charan@example.com"), Optional.empty());

        printEmployeeDetails(emp1);
        printEmployeeDetails(emp2);
        printEmployeeDetails(emp3);
    }

    public static void printEmployeeDetails(Employe emp) {
        System.out.println("\nID: " + emp.getId());
        System.out.println("Name: " + emp.getName());

        // Provide default email if not present
        String email = emp.getEmail().orElse("No Email Provided");
        System.out.println("Email: " + email);

        // Throw exception if department is missing
        String department = emp.getDepartment().orElseThrow(() ->
            new MissingFieldException("Department is required for employee: " + emp.getName())
        );
        System.out.println("Department: " + department);
    }
}


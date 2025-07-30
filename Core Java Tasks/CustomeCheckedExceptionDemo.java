/*
 * Create a custom checked exception class InvalidSalaryException that extends Exception.

Create a class EmployeeService with the following methods:

validateSalary(double salary) → throws InvalidSalaryException if salary is < 0
processSalary(Employee emp) → calls validateSalary()
startProcess(Employee emp) → calls processSalary()

The main method should:

Create an Employee object with negative salary
Call startProcess()
Catch and handle InvalidSalaryException using try-catch in main()
 */

package myjavacodes;

//Custom checked exception
class InvalidSalaryException extends Exception {
	 public InvalidSalaryException(String message) {
	     super(message);
	 }
}

//Employee class
class Employee1 {
	 private int id;
	 private String name;
	 private double salary;
	
	 // Constructor
	 public Employee1(int id, String name, double salary) {
	     this.id = id;
	     this.name = name;
	     this.salary = salary;
	 }
	
	 // Getters
	 public double getSalary() {
	     return salary;
	 }
	
	 public String getName() {
	     return name;
	 }
}

//Service class to process Employee salary
class EmployeeService {

	 // Validates the salary
	 public void validateSalary(double salary) throws InvalidSalaryException {
	     if (salary < 0) {
	         throw new InvalidSalaryException("Salary cannot be negative: " + salary);
	     }
 }

	 // Calls validateSalary
	 public void processSalary(Employee1 emp) throws InvalidSalaryException {
	     validateSalary(emp.getSalary());
	     System.out.println("Salary processed successfully for " + emp.getName());
	 }
	
	 // Calls processSalary
	 public void startProcess(Employee1 emp) throws InvalidSalaryException {
	     processSalary(emp);
	 }
}

//Main class to test
public class CustomeCheckedExceptionDemo {
	 public static void main(String[] args) {
	     // Create an employee with negative salary
	     Employee1 emp = new Employee1(101, "Anu", 50000);
	
	     EmployeeService service = new EmployeeService();
	
	     try {
	         service.startProcess(emp);
	     } catch (InvalidSalaryException e) {
	         System.out.println("Error: " + e.getMessage());
	     }
	 }
}


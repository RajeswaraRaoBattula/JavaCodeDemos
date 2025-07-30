/*
 * Create a functional interface EmployeeProcessor with a method:

   void process(Employee e);

   Use it to print:

	Name and salary of employees
	Bonus calculation (10% of salary)
 */

package myjavacodes;

//Functional interface
@FunctionalInterface
interface EmployeeProcessor {
	void process(EmployeeE e);
}

//Employee class
class EmployeeE {
	 private int id;
	 private String name;
	 private double salary;
	
	 // Constructor
	 public EmployeeE(int id, String name, double salary) {
	     this.id = id;
	     this.name = name;
	     this.salary = salary;
	 }
	
	 // Getters
	 public String getName() { return name; }
	 public double getSalary() { return salary; }
	}
	
	public class FunctionalInterfaceDemo {
	 public static void main(String[] args) {
	     // Sample employee
	     EmployeeE emp = new EmployeeE(101, "RAJA", 50000);
	
	     // Lambda to print name and salary
	     EmployeeProcessor printDetails = e -> 
	         System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary());
	
	     // Lambda to calculate and print bonus (10%)
	     EmployeeProcessor printBonus = e -> 
	         System.out.println("Bonus (10%): " + (e.getSalary() * 0.10));
	
	     // Execute both processors
	     printDetails.process(emp);
	     printBonus.process(emp);
	 }
}


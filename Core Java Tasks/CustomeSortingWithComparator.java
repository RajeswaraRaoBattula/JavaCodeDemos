package myjavacodes;

import java.util.*;

//Employee class
class Employee123 {
	 private int id;
	 private String name;
	 private double salary;
	
	 // Constructor
	 public Employee123(int id, String name, double salary) {
	     this.id = id;
	     this.name = name;
	     this.salary = salary;
	 }
	
	 // Getters
	 public int getId() { return id; }
	 public String getName() { return name; }
	 public double getSalary() { return salary; }
	
	 // toString for display
	 @Override
	 public String toString() {
	     return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
	 }
}

//Comparator to sort by salary descending
class SalaryDescendingComparator implements Comparator<Employee123> {
	 public int compare(Employee123 e1, Employee123 e2) {
	     return Double.compare(e2.getSalary(), e1.getSalary()); // Descending
	 }
}

public class CustomeSortingWithComparator {
	 public static void main(String[] args) {
	     List<Employee123> employees = new ArrayList<>();
	
	     // Add employees
	     employees.add(new Employee123(101, "Alice", 55000));
	     employees.add(new Employee123(102, "Bob", 75000));
	     employees.add(new Employee123(103, "Charlie", 60000));
	     employees.add(new Employee123(104, "David", 75000));
	     employees.add(new Employee123(105, "Eve", 50000));
	
	     // Sort by salary descending
	     Collections.sort(employees, new SalaryDescendingComparator());
	     System.out.println("Sorted by Salary (Descending):");
	     for (Employee123 e : employees) {
	         System.out.println(e);
	     }
	
	     // Sort by name alphabetically using lambda
	     employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
	     System.out.println("\nSorted by Name (Alphabetically):");
	     for (Employee123 e : employees) {
	         System.out.println(e);
	     }
	 }
}


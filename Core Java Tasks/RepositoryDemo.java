package myjavacodes;

import java.util.*;

//Generic Repository class
class Repository<T, ID> {
	 private Map<ID, T> storage = new HashMap<>();
	
	 // Save or update entity
	 public void save(ID id, T entity) {
	     storage.put(id, entity);
	 }
	
	 // Find by ID
	 public T findById(ID id) {
	     return storage.get(id);
	 }
	
	 // Find all entities
	 public List<T> findAll() {
	     return new ArrayList<>(storage.values());
	 }
	
	 // Delete by ID
	 public void deleteById(ID id) {
	     storage.remove(id);
	 }
}

//Employee class
class Employee12 {
	 private int id;
	 private String name;
	 private double salary;
	
	 // Constructor
	 public Employee12(int id, String name, double salary) {
	     this.id = id;
	     this.name = name;
	     this.salary = salary;
	 }
	
	 // Getters (optional)
	
	 // toString() for display
	 @Override
	 public String toString() {
	     return "Employee { ID: " + id + ", Name: " + name + ", Salary: " + salary + " }";
	 }
}

//Main class
public class RepositoryDemo {
	 public static void main(String[] args) {
	     // Create a repository for Employee
	     Repository<Employee12, Integer> repo = new Repository<>();
	
	     // Add 3 employees
	     repo.save(1, new Employee12(1, "Raja", 50000));
	     repo.save(2, new Employee12(2, "Rajeswar", 60000));
	     repo.save(3, new Employee12(3, "Ramu", 55000));
	
	     // Retrieve and print all employees
	     System.out.println("All Employees:");
	     List<Employee12> allEmployees = repo.findAll();
	     allEmployees.forEach(System.out::println);
	
	     // Retrieve a specific employee by ID
	     System.out.println("\nEmployee with ID 2:");
	     Employee12 emp = repo.findById(2);
	     System.out.println(emp);
	
	     // Delete an employee
	     repo.deleteById(1);
	     System.out.println("\nAfter deleting employee with ID 1:");
	     repo.findAll().forEach(System.out::println);
	 }
}


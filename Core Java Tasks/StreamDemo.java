package myjavacodes;
import java.util.*;
import java.util.stream.*;

class EmployeeDetails {
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public EmployeeDetails(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ "]";
	}
	
	

   
}


public class StreamDemo {
    public static void main(String[] args) {
        List<EmployeeDetails> employees = Arrays.asList(
            new EmployeeDetails(101, "Ravi", "HR", 50000),
            new EmployeeDetails(102, "Priya", "IT", 60000),
            new EmployeeDetails(103, "Arun", "HR", 55000),
            new EmployeeDetails(104, "Kavya", "IT", 70000),
            new EmployeeDetails(105, "Divya", "Sales", 45000)
        );

        // Q1. Print all employee names using Stream
        System.out.println("Employee Names:");
        employees.stream().map(EmployeeDetails::getName).forEach(System.out::println);
        System.out.println();
        
        //Q2. Filter and print employees with salary > 55000
        System.out.println("Employees with salary > 55000:");
        employees.stream().filter(p1 ->p1.getSalary() > 55000)
        .forEach(p1 -> System.out.println(p1.getId()+" "+p1.getName()+" "+p1.getDepartment()+" "+p1.getSalary()));
        System.out.println();
        
       //Q3. Count the number of employees in "HR" department
        long hrCount = employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("HR")).count();

        System.out.println("Number of employees in HR: " + hrCount);
        System.out.println();
        
        //Q4.Sort employees by salary in descending order
        List<EmployeeDetails> sortedBySalaryDesc = employees.stream()
        .sorted(Comparator.comparingDouble(EmployeeDetails::getSalary).reversed())
  	    .collect(Collectors.toList());
        System.out.println("Sorted by salary (desc): " + sortedBySalaryDesc);
        System.out.println();
        
        
        //Q5. Find the highest paid employee (use max)
        EmployeeDetails highestPaid = employees.stream()
        	    .max(Comparator.comparingDouble(EmployeeDetails::getSalary))
        	    .orElse(null);
        System.out.println("Highest paid: " + highestPaid);
        System.out.println();
        
        //Q6. Find the average salary of all employees
        double avgSalary = employees.stream()
        	    .mapToDouble(EmployeeDetails::getSalary)
        	    .average()
        	    .orElse(0.0);
        System.out.println("Average Salary: " + avgSalary);
        System.out.println();
        
        //Q7. Collect all names into a List
        List<String> names = employees.stream()
        	    .map(EmployeeDetails::getName)
        	    .collect(Collectors.toList());
        System.out.println("Names: " + names);
        System.out.println();
        
        //Q8. Group employees by department (use Collectors.groupingBy)
        Map<String, List<EmployeeDetails>> groupedByDept = employees.stream()
        	    .collect(Collectors.groupingBy(EmployeeDetails::getDepartment));
        System.out.println("Grouped by Department: " + groupedByDept);
        System.out.println();
        
        //Q9. Calculate total salary per department
        Map<String, Double> totalSalaryPerDept = employees.stream()
        	    .collect(Collectors.groupingBy(
        	        EmployeeDetails::getDepartment,
        	        Collectors.summingDouble(EmployeeDetails::getSalary)
        	    ));
        System.out.println("Total Salary per Department: " + totalSalaryPerDept);
        System.out.println();
        
        //Q10. Names of employees in IT department sorted by salary
        
        List<String> itNamesSorted = employees.stream()
        	    .filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
        	    .sorted(Comparator.comparingDouble(EmployeeDetails::getSalary))
        	    .map(EmployeeDetails::getName)
        	    .collect(Collectors.toList());
        System.out.println("IT Employees Sorted by Salary: " + itNamesSorted);
        System.out.println();
        
        //Q11. Check if any employee earns less than 40000
        boolean anyBelow40k = employees.stream()
        	    .anyMatch(e -> e.getSalary() < 40000);
        System.out.println("Any employee earns < 40000: " + anyBelow40k);
        System.out.println();

        //Q12. Get a comma-separated string of all employee names
        String nameCSV = employees.stream()
        	    .map(EmployeeDetails::getName)
        	    .collect(Collectors.joining(", "));
        System.out.println("Employee Names CSV: " + nameCSV);
        System.out.println();

        //Q13. Get a list of top 2 highest earning employees
        List<EmployeeDetails> top2 = employees.stream()
        	    .sorted(Comparator.comparingDouble(EmployeeDetails::getSalary).reversed())
        	    .limit(2)
        	    .collect(Collectors.toList());
        System.out.println("Top 2 Earners: " + top2);
        System.out.println();

        //Q14. Skip first 2 employees and print the rest
        List<EmployeeDetails> skipped = employees.stream()
        	    .skip(2)
        	    .collect(Collectors.toList());
        System.out.println("Skipped first 2: " + skipped);
        System.out.println();

        //Q15. Limit to first 3 employees and print their names
        List<String> first3Names = employees.stream()
        	    .limit(3)
        	    .map(EmployeeDetails::getName)
        	    .collect(Collectors.toList());
        System.out.println("First 3 Names: " + first3Names);
        System.out.println();
        
        //Q16. Get employee with minimum salary in HR department
        
        EmployeeDetails minHr = employees.stream()
        	    .filter(e -> e.getDepartment().equalsIgnoreCase("HR"))
        	    .min(Comparator.comparingDouble(EmployeeDetails::getSalary))
        	    .orElse(null);
        System.out.println("Lowest paid in HR: " + minHr);
        System.out.println();


        //Q17. Partition employees by salary > 55000
        

        Map<Boolean, List<EmployeeDetails>> partitioned = employees.stream()
        	    .collect(Collectors.partitioningBy(e -> e.getSalary() > 55000));
        System.out.println("Partitioned by salary > 55000: " + partitioned);
        System.out.println();

        //Q18. Create a Map<Department, AverageSalary>
        Map<String, Double> avgSalaryByDept = employees.stream()
        	    .collect(Collectors.groupingBy(
        	        EmployeeDetails::getDepartment,
        	        Collectors.averagingDouble(EmployeeDetails::getSalary)
        	    ));
        System.out.println("Average Salary per Department: " + avgSalaryByDept);
        System.out.println();

        //Q19. Sort employees by name and then by salary
        List<EmployeeDetails> sortedByNameThenSalary = employees.stream()
        	    .sorted(Comparator.comparing(EmployeeDetails::getName)
        	                      .thenComparing(EmployeeDetails::getSalary))
        	    .collect(Collectors.toList());
        System.out.println("Sorted by Name, then Salary: " + sortedByNameThenSalary);
        System.out.println();

        //Q20. Convert List<Employee> into Map<Id, Name>
        Map<Integer, String> idNameMap = employees.stream()
        	    .collect(Collectors.toMap(EmployeeDetails::getId, EmployeeDetails::getName));
        System.out.println("Map<Id, Name>: " + idNameMap);
        System.out.println();

        //Get employees whose name starts with “D” and ends with “a”
        List<EmployeeDetails> nameStartsDEndsA = employees.stream()
        	    .filter(e -> e.getName().startsWith("D") && e.getName().endsWith("a"))
        	    .collect(Collectors.toList());
        System.out.println("Names starting with 'D' and ending with 'a': " + nameStartsDEndsA);
        System.out.println();

        //List departments with more than 1 employee
        List<String> departmentsWithMultipleEmployees = employees.stream()
        	    .collect(Collectors.groupingBy(EmployeeDetails::getDepartment, Collectors.counting()))
        	    .entrySet().stream()
        	    .filter(entry -> entry.getValue() > 1)
        	    .map(Map.Entry::getKey)
        	    .collect(Collectors.toList());
        System.out.println("Departments with >1 employee: " + departmentsWithMultipleEmployees);
        System.out.println();

        //Find the second highest salary using Streams
        OptionalDouble secondHighestSalary = employees.stream()
        	    .mapToDouble(EmployeeDetails::getSalary)
        	    .distinct()
        	    .sorted()
        	    .skip(employees.stream()
        	        .mapToDouble(EmployeeDetails::getSalary)
        	        .distinct()
        	        .count() > 1 ? employees.stream()
        	                         .mapToDouble(EmployeeDetails::getSalary)
        	                         .distinct()
        	                         .count() - 2 : 0) // For handling less than 2 unique salaries
        	    .findFirst();

        System.out.println("Second Highest Salary: " +(secondHighestSalary.isPresent() ? secondHighestSalary.getAsDouble() : "Not Found"));

        



    }
}


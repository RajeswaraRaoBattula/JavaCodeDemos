/*
 * Create a class Student with fields: id, name, department.
Group the students by department using Map<String, List<Student>>.
Print all departments with their student names.
Bonus: Use Java 8 Stream and Collectors.groupingBy()
 */
package myjavacodes;

import java.util.*;
import java.util.stream.Collectors;

class Student1 {
    private int id;
    private String name;
    private String department;

    // Constructor
    public Student1(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return name;
    }
}

public class StudentGroupingWithStream {
    public static void main(String[] args) {
        List<Student1> students = Arrays.asList(
            new Student1(1, "Raja", "CSE"),
            new Student1(2, "Balayya", "ECE"),
            new Student1(3, "Charan", "CSE"),
            new Student1(4, "David", "IT"),
            new Student1(5, "Murali", "ECE"),
            new Student1(6, "Fhani", "IT")
        );

        // Grouping students by department using Java 8 Stream API
        Map<String, List<Student1>> groupedByDept = students.stream()
            .collect(Collectors.groupingBy(Student1::getDepartment));

        // Printing the grouped result
        System.out.println("Students grouped by department:");
        groupedByDept.forEach((department, studentList) -> {
            System.out.println(department + ": " +
                studentList.stream()
                    .map(Student1::getName)
                    .collect(Collectors.joining(", "))
            );
        });
    }
}

package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 14.Group all employees by department
 * 15.Get the count of employees by department
 * 16.Get the sum of salaries of all employees by department
 * 17.Get the average salaries of all employees per department
 * 18.Check if all employees belong to a specific department
 * 19.List all employees grouping by cities but belong to the same department
 * 20.Find the department with the highest average salary
 */
public class StreamInterviewObjectAdvance {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Vani", 1, "Bengaluru", 1350000, "IT"),
                new Employee("Bhagyashree", 2, "Bengaluru", 1550000, "IT"),
                new Employee("Shirin", 3, "Delhi", 1450000, "IT"),
                new Employee("Mugdha", 4, "Pune", 1200000, "HR"),
                new Employee("Arti", 5, "Raipur", 1100000, "Devops"),
                new Employee("Abhishek", 6, "Noida", 1150000, "HR"),
                new Employee("Dushyant", 7, "Gurgram", 1600000, "Data Science")
        );
        //14
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k, v) -> System.out.println("Department: " + k + "\nEmployees: " + v));
        System.out.println("----------------------------------------");
        //15
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((k, v) -> System.out.println("Department: " + k + "\nCount: " + v));
        System.out.println("-----------------------------------");
        //16
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)))
                .forEach((k, v) -> System.out.println("Department: " + k + "\nTotal Salary: " + v));
        System.out.println("-------------------------------------------");
        //17
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((k, v) -> System.out.println("Department: " + k + "\nAverage Salary: " + v));
        System.out.println("-------------------------------------------");
        //18
        boolean isMatch = employees.stream()
                .allMatch(employee -> employee.getDepartment().equals("IT"));
        if (isMatch) {
            System.out.println("All employess are in IT department.");
        } else {
            System.out.println("All employess are not in IT department.");
        }
        System.out.println("------------------------------------------------");

        //19
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getCity)))
                .forEach((dept, cityMap) -> {
                    System.out.println("Department: " + dept);
                    cityMap.forEach((city, emp) -> {
                        System.out.println("City: " + city);
                        System.out.println("Employee: " + emp);
                    });
                });
        System.out.println("---------------------------------------------");
        //20
        Map<String, Double> deptAvgSalMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        String department = deptAvgSalMap.keySet()
                .stream()
                .max(Comparator.comparingDouble(deptAvgSalMap::get)).get();
        System.out.println(department);
        System.out.println("---------------------------------");
    }
}

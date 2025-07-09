package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 6. Check if all employees have a salary greater than a specific Value
 * 7. Get the sum of salaries of all employees and the average salary
 * 8. Get a Map of Employee Names and their salaries
 * 9. Print the employee details from highest to lowest salary
 * 10. Get the employee with the highest salary
 * 11. Get the employees with the second highest salary
 * 12. Get the employees who are earning above the average salary
 * 13. Get the employee with the longest name
 */
public class StreamInterviewObjectIntermediate {
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

        //6
        boolean salaryMatched = employees.stream()
                .allMatch(employee -> employee.getSalary() > 1100000);
        if (salaryMatched) {
            System.out.println("Every employee has salary greater than 1100000");
        } else {
            System.out.println("Not all employees have salary greater than 1100000");
        }
        System.out.println("---------------------------------------------");
        //7
        double sumSal = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println(sumSal);
        System.out.println();
        double avgSal = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average().getAsDouble();
        System.out.println(avgSal);
        System.out.println("----------------------------------------------");

        //8
        employees.stream()
                .collect(Collectors.toMap(Employee::getEmpName, Employee::getSalary))
                .forEach((k, v) -> System.out.println("Employee Name: " + k + "\n Employee Salary: " + v));
        System.out.println("---------------------------------------------");

        //9
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);
        System.out.println("--------------------------------------------");
        //10
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(1)
                .forEach(System.out::println);
        System.out.println("----------------------------");
        //11
        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(2)
                .skip(1)
                .forEach(System.out::println);
        System.out.println("------------------------------------------");
        //12
        double avgSalary = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        employees.stream()
                .filter(employee -> employee.getSalary() > avgSalary)
                .forEach(System.out::println);
        System.out.println("--------------------------------------");
        //13
        employees.stream()
                .map(Employee::getEmpName)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(1)
                .forEach(System.out::println);

        Employee maxLenName = employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getEmpName().length()))
                .get();
        System.out.println(maxLenName);
    }
}

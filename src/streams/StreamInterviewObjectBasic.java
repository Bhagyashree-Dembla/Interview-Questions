package streams;

import java.util.Arrays;
import java.util.List;

/**
 * 1. Find all employees from a specific city and get the count
 * 2. Find all employees where salary is greater than a particular value
 * 3. Print all the employee names only in upper case and alphabetical order
 * 4. Get the first employee where dept is "HR" and if not available throw exception
 * 5. Get the total salary of all employees in a specific department
 */
public class StreamInterviewObjectBasic {
    public static void main(String[] args){

        List<Employee> employees = Arrays.asList(
                new Employee("Vani", 1, "Bengaluru", 1350000, "IT"),
                new Employee("Bhagyashree", 2, "Bengaluru", 1550000, "IT"),
                new Employee("Shirin", 3, "Delhi", 1450000, "IT"),
                new Employee("Mugdha", 4, "Pune", 1200000, "HR"),
                new Employee("Arti", 5, "Raipur", 1100000, "Devops"),
                new Employee("Abhishek", 6, "Noida", 1150000, "HR"),
                new Employee("Dushyant", 7, "Gurgram", 1600000, "Data Science")
        );
        //1
        long cityCount = employees.stream()
                .filter(employee -> employee.getCity().equals("Bengaluru"))
                .count();
        System.out.println(cityCount);
        System.out.println("----------------------------------------------");

        //2
        employees.stream()
                .filter(employee -> employee.getSalary() > 1100000)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");
        //3
        employees.stream()
                .map(employee -> employee.getEmpName().toUpperCase())
                .sorted()
                .forEach(System.out::println);
        System.out.println("------------------------------------------------");
        //4
        Employee hrEmployee = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .findFirst().orElseThrow();
        System.out.println(hrEmployee);
        System.out.println("------------------------------------------------");

        //5
       employees.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .map(Employee::getSalary)
                .reduce(Double::sum).ifPresent(System.out::println);
    }
}

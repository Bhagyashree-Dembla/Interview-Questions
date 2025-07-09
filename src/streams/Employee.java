package streams;

public class Employee {
    private String empName;
    private Integer empId;
    private String city;
    private double salary;

    private String Department;

    public Employee(String empName, Integer empId, String city, double salary, String department) {
        this.empName = empName;
        this.empId = empId;
        this.city = city;
        this.salary = salary;
        Department = department;
    }

    public String getDepartment() {
        return Department;
    }

    public double getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                ", Department='" + Department + '\'' +
                '}';
    }
}

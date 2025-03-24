package com.practice.poc.Java8Practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecuteJava8 {

    public static List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Alice", 60000, "IT"));
        employees.add(new Employee(102, "Bob", 75000, "Finance"));
        employees.add(new Employee(103, "Charlie", 50000, "HR"));
        employees.add(new Employee(104, "David", 90000, "IT"));
        employees.add(new Employee(105, "Eve", 55000, "Marketing"));

        return employees;
    }

    public static void main(String[] args) {

        //1.Convert List<Employee> to List<String> (names only)
        List<String> empNameList = getAllEmployees().stream().map(Employee::getName).collect(Collectors.toList());

        //2.Find employees whose salary is greater than 50,000
        List<Employee> empSalAbove50KList = getAllEmployees().stream().filter(emp -> emp.getSalary() > 50000).collect(Collectors.toList());

        //3.Find the employee with the highest salary
        Optional<Employee> highestSalEmp = getAllEmployees().stream().max(Comparator.comparing(Employee::getSalary));

        //4.Find the employee with the lowest salary
        Optional<Employee> lowestSalEmp = getAllEmployees().stream().min(Comparator.comparing(Employee::getSalary));

        //5. Sort employees by name
        List<Employee> employeeListSortedByName = getAllEmployees().stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());

        //6. Sort employees by salary in descending order
        List<Employee> employeeSalListInDescOrd = getAllEmployees().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());

        //7. Find employees from the "HR" department
        List<Employee> HREmpList = getAllEmployees().stream().filter(emp -> "HR".equalsIgnoreCase(emp.getDepartment())).collect(Collectors.toList());

        //8. Find distinct departments
        List<String> uniqueDeptList = getAllEmployees().stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        //9. Count employees in the "IT" department
        long deptOfITCount = getAllEmployees().stream().filter(emp -> "IT".equalsIgnoreCase(emp.getDepartment())).count();

        //10. Group employees by department
        Map<String, List<Employee>> deptAndEmpsList = getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));

        //Find the highest salary in each department
        Map<String, Optional<Employee>> deptAndHighestSalEmp = getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        //Get the sum of salaries for each department
        Map<String, Double> deptAndTotalSal = getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));

        //Find the average salary of all employees
        double averageEmpSal = getAllEmployees().stream().mapToDouble(Employee::getSalary).average().orElse(0.0);

        //Find the employee count in each department
        Map<String, Long> deptAndEmpCount = getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        //Check if any employee has a salary greater than 1,00,000
        boolean anyEmpSalGreateThan1L = getAllEmployees().stream().anyMatch(emp -> emp.getSalary() > 100000);

        //Check if all employees earn more than 30,000
        boolean allEmpEarnGreaterThan30k = getAllEmployees().stream().allMatch(emp -> emp.getSalary() > 30000);

        //Check if no employee earns less than 10,000
        boolean noneBelow10k = getAllEmployees().stream().noneMatch(emp -> emp.getSalary() < 10000);

        //Find the first employee in the sorted list
        Optional<Employee> firstEmployee = getAllEmployees().stream().sorted(Comparator.comparing(Employee::getName)).findFirst();

        //Reduce to get total salary of all employees
        Double sumOfAllEmp = getAllEmployees().stream().map(Employee::getSalary).reduce(0.0, Double::sum);

        //Convert employee list to a Set<String> containing unique departments
        Set<String> uniqueDept = getAllEmployees().stream().map(Employee::getDepartment).collect(Collectors.toSet());

        //Get a comma-separated string of all employee names
        String commaSepratedEmpNames = getAllEmployees().stream().map(Employee::getName).collect(Collectors.joining(","));

        //Create a Map<Integer, String> with employee ID as key and name as value
        Map<Integer, String> empIdAndNameMap = getAllEmployees().stream().collect(Collectors.toMap(Employee::getId, Employee::getName));

        //Find the sum of salaries of employees in the "Finance" department
        double totalSalOfFinanceDept = getAllEmployees().stream().filter(emp -> "Finance".equalsIgnoreCase(emp.getDepartment())).mapToDouble(Employee::getSalary).sum();

        //Find the average salary of employees in "IT" department
        double avgSalOfITEmps = getAllEmployees().stream().filter(emp -> "IT".equalsIgnoreCase(emp.getDepartment())).mapToDouble(Employee::getSalary).average().orElse(0.0);

        //Find all employees whose names start with "A"
        List<Employee> nameStartsWithA = getAllEmployees().stream().filter(emp -> emp.getName().startsWith("A")).collect(Collectors.toList());

        //Sort employees by salary, then by name if salaries are equal
        List<Employee> sortedEmployees = getAllEmployees().stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).collect(Collectors.toList());

        //Get a set of all unique employee names
        Set<String> uniqueEmpNames = getAllEmployees().stream().map(Employee::getName).collect(Collectors.toSet());

        //Find employees whose names contain more than 5 letters
        List<Employee> nameLengthGreaterThan5 = getAllEmployees().stream().filter(emp -> emp.getName().length() > 5).collect(Collectors.toList());

        //Find the second highest salary
        Optional<Double> secHighestSal = getAllEmployees().stream().map(Employee::getSalary).skip(1).findFirst();

        //Find the employee with the shortest name
        Optional<Employee> shortEmpName = getAllEmployees().stream().min(Comparator.comparing(emp -> emp.getName().length()));

        //Find the department with the highest total salary
        Optional<Map.Entry<String, Double>> highestPaidDept = getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary))).entrySet().stream().max(Map.Entry.comparingByValue());

        //Find employees earning more than the average salary
        double avgEmpSal = getAllEmployees().stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        List<Employee> aboveAverageSalaries = getAllEmployees().stream().filter(emp -> emp.getSalary() > avgEmpSal).collect(Collectors.toList());

        //Get the top 3 highest-paid employees
        List<Employee> top3HighestPaidEmps = getAllEmployees().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());

        //Find the department with the most employees
        Optional<String> maxEmpsInDept = getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);

        //Count the number of employees in each department
        Map<String, Long> departmentCount = getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    
        //Get the highest-paid employee in each department
        Map<String, Optional<Employee>> highestPaidInEachDept = getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        //Get a list of employees sorted by the last letter of their name
        List<Employee> lastLetterOfTheirName = getAllEmployees().stream().sorted(Comparator.comparing(emp -> emp.getName().charAt(emp.getName().length() - 1))).collect(Collectors.toList());

        //Find employees with at least one duplicate salary
        Set<Employee> uniqueEmployee = new HashSet<>();
        List<Employee> atleastOneDuplicateSalary = getAllEmployees().stream().filter(emp -> !uniqueEmployee.add(emp)).collect(Collectors.toList());
    }
}

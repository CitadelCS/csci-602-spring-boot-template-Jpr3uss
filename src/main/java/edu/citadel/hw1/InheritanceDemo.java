package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class InheritanceDemo {
    private static ArrayList<Employee> employees;

    public static void main(String[] args) {
        employees = new ArrayList<>();
        employees.ensureCapacity(4);

        employees.add(new HourlyEmployee(
            "John Doe",
            LocalDate.of(2009,05,21),
            50.5,
            160
        ));

        employees.add(new HourlyEmployee(
            "Jane Doe",
            LocalDate.of(2005,9,01),
            150.5,
            80
        ));

        employees.add(new SalariedEmployee(
            "Moe Howard",
            LocalDate.of(2004,1,1),
            75000
        ));
        
        employees.add(new SalariedEmployee(
            "Curly Howard",
            LocalDate.of(2018,1,1),
            105000
        ));
        
        
        System.out.println("List of Employees (before sorting)");
        for (Employee employee : employees) 
            System.out.println(employee);

        Collections.sort(employees);

        System.out.println("\nList of Employees (after sorting)");
        for (Employee employee : employees)
            System.out.println(employee);

        System.out.println("\nMonthly Pay");
        
        double totalPay = 0;
        double pay = 0;

        for (Employee employee : employees) {
            pay = employee.getMonthlyPay();

            System.out.printf("%s: $%,.2f\n", employee.getName(), pay);

            totalPay += pay;
        }
        
        System.out.printf("Total Monthly Pay: $,.2f", totalPay);
    }
}

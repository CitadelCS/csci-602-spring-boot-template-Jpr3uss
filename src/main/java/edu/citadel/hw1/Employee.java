package edu.citadel.hw1;

import java.time.LocalDate;

public abstract class Employee implements Comparable<Employee> {
    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public abstract double getMonthlyPay();

    public int compareTo(Employee that) {
        double sal1 = this.getMonthlyPay();
        double sal2 = that.getMonthlyPay();

        if (sal1 < sal2)
            return -1;
        else if (sal1 > sal2)
            return 1;
    
        return 0;
    }
}

package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;

public class SalariedEmployee extends Employee {
    private double annualSalary;

    public SalariedEmployee(String name, LocalDate hireDate,
      double annualSalary) {
        super(name, hireDate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double getMonthlyPay() {
        return annualSalary / 12.0;
    }

    @Override
    public String toString() {
        return "HourlyEmployee[name=" + name + ", hireDate=" + hireDate +
          ", annualSalary=" + annualSalary + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), annualSalary);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) return false;

        // Cast that to employee
        Employee that = (Employee)obj;

        if (this.compareTo(that) == 0 && this.name.equals(that.name)
          && this.hireDate.equals(that.hireDate) 
          && this.getMonthlyPay() == that.getMonthlyPay()) 
    
            return true;
        else
            return false;
    }
}

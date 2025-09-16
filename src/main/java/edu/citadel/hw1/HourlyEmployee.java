package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;

import org.apache.commons.lang3.builder.HashCodeExclude;

public class HourlyEmployee extends Employee{
    private double wageRate;
    private double hoursWorked;

    public HourlyEmployee(String name, LocalDate hireDate,
      double wageRate, double hoursWorked) {
        super(name, hireDate);
        this.wageRate = wageRate;
        this.hoursWorked = hoursWorked;
    }

    public double getWageRate() {
        return wageRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double getMonthlyPay() {
        return wageRate * hoursWorked;
    }

    @Override
    public String toString() {
        return "HourlyEmployee[name=" + name + ", hireDate=" + hireDate +
            ", wagerate=" + wageRate + ", hoursWorked=" + hoursWorked + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wageRate, hoursWorked);
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

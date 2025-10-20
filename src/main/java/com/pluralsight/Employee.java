package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double overTimeHours;
    private double regularHours;

    public Employee() {

    }

    public double getTotalPay() {
        return regularHours + overTimeHours;
    }

    public double getRegularHours() {
        if (hoursWorked <= 40) {
            regularHours = payRate * hoursWorked;
        }
        return regularHours;
    }

    public double getOverTimeHours() {
        if (hoursWorked > 40) {
            overTimeHours = (hoursWorked - 40) * payRate;
        }
        return overTimeHours;
    }
}

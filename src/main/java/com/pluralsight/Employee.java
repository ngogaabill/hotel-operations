package com.pluralsight;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double overTimeHours;
    private double regularHours;
    private double punchIn = 0.0;

    public Employee(String name, int employeeId, String department, double payRate) {
        this.name = name;
        this.employeeId = employeeId;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0.0;

    }

    public double getTotalPay() {
        return getRegularHours() + getOverTimeHours();
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

    public void punchIn(double time) {
        System.out.println(name + "Punched in at: " + time);
        punchIn = time;
        punchIn();
    }

    // Overloaded punchIn using current time
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour() + now.getMinute() / 60.0;
        System.out.println(name + " punched in at: " + time);
        punchIn = time;
    }

    public void punchOut(double time) {
        if (time == 0.0) {
            System.out.println("can't sign out");
        } else
            System.out.println(name + " Punched out at : " + time + " worked total of " + (time - punchIn) + "hours");
        hoursWorked = time - punchIn;
    }

    // Overloaded punchOut using current time
    public void punchOut() {
        LocalDateTime now = LocalDateTime.now();
        double time = now.getHour() + now.getMinute() / 60.0;
        if (time == 0.0) {
            System.out.println("Can't sign out");
        } else {
            hoursWorked = time - punchIn;
            System.out.println(name + " Punched out at : " + time + " worked total of " + (time - punchIn) + "hours");
        }
    }
}

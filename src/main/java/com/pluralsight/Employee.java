package com.pluralsight;


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
        this.department = department;
        this.employeeId = employeeId;
        this.payRate = payRate;

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
    }

    public void punchOut(double time) {
        if(time == 0.0){
            System.out.println("can't sign out");
        }else hoursWorked = time - punchIn;
    }
}

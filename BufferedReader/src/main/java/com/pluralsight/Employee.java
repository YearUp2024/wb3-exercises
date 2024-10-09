package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private float hoursWorked;
    private float payRate;

    public Employee(int employeeId, String name, float hoursWorked, float payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay() {
        if (hoursWorked > 40) {
            double overTimeHours = hoursWorked - 40;
            return (payRate * 40) + (payRate * 1.5 * overTimeHours);
        } else {
            return hoursWorked * payRate;
        }
    }
}

package com.pluralsight.pay;

public class Employee {
    private int id;
    private String name;
    private double payRate;
    private double hrsWorked;
    private double totalPay;

    public Employee(int id, String name, double payRte, double hrsWorked) {
        this.id = id;
        this.name = name;
        this.payRate = payRte;
        this.hrsWorked = hrsWorked;
    }

    public double getTotalPay() {
        double otRate = 1.5;
        double regHours = 40;

        if (hrsWorked > regHours) {
            double otHours = (hrsWorked - regHours);
            return (regHours * payRate) + (otHours * payRate * otRate);
        } else {
            return hrsWorked * payRate;
        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHrsWorked() {
        return hrsWorked;
    }

    public void setHrsWorked(double hrsWorked) {
        this.hrsWorked = hrsWorked;
    }
}


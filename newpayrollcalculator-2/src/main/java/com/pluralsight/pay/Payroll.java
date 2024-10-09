package com.pluralsight.pay;

import java.util.ArrayList;

public class Payroll {

    // Method to display employee pay
    public static void displayEmployeePay(Employee e) {
        System.out.printf("ID: %d, Name: %s, Total Pay: $%.2f%n", e.getId(), e.getName(), e.getTotalPay());
    }

    public static void main(String[] args) {
        // Create an ArrayList to hold Employee objects
        ArrayList<Employee> employees = new ArrayList<>();

        // Add Employee instances to the ArrayList
        employees.add(new Employee(10, "Dana Wyatt", 52.5, 12.50));
        employees.add(new Employee(20, "Erza Aiden", 17, 16.75));
        employees.add(new Employee(30, "Brittney Thibbs", 40, 16.50));
        employees.add(new Employee(40, "Zephaniah Hughes", 2, 10.0));

        // Loop through the ArrayList and display each employee's pay
        for (Employee e : employees) {
            displayEmployeePay(e);
        }
    }
}


package com.pluralsight.payroll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Payroll {

    // Method to display employee pay
    public static void displayEmployeePay(Employee e) {
        System.out.printf("ID: %d, Name: %s, Total Pay: $%.2f%n", e.getId(), e.getName(), e.getTotalPay());
    }

    // Main method to run the payroll process
    public static void main(String[] args) {
        String filePath = "./src/main/resources/employees.csv"; // Path to your CSV file
        ArrayList<Employee> employees = new ArrayList<>();

        // Step 1: Reading the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header row if present
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Step 2: Split the line into parts using '|' delimiter
                String[] data = line.split("\\|");

                // Step 3: Parse the fields to create an Employee object
                int id = Integer.parseInt(data[0]); // Employee ID
                String name = data[1]; // Employee Name
                double hrsWorked = Double.parseDouble(data[2]); // Hours Worked
                double payRate = Double.parseDouble(data[3]); // Pay Rate

                // Step 4: Create a new Employee object and add it to the list
                Employee employee = new Employee(id, name, payRate, hrsWorked);
                employees.add(employee);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Step 5: Display the pay for each employee
        for (Employee employee : employees) {
            displayEmployeePay(employee);
        }
    }
}



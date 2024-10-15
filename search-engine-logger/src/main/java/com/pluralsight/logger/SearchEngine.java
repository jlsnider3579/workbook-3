package com.pluralsight.logger;

import java.io.FileWriter;
import java.io.IOException;

    public class SearchEngine {

        // Method to log actions to the logs.txt file
        public static void logAction(String action) {
            try (FileWriter script = new FileWriter("logs.txt", true)) {
                // Write the action to the log file and add a newline
                script.write(action + "\n");
            } catch (IOException e) {
                // Handle the exception if something goes wrong
                System.out.println("An error occurred while logging the action.");
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            // Example usage of the logAction method
            logAction("Application launched");
            logAction("User searched for: Java");
            logAction("User exited the application");
        }
    }



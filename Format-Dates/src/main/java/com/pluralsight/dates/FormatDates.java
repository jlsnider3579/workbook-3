package com.pluralsight.dates;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

    public class FormatDates {
        public static void main(String[] args) {

            LocalDateTime today = LocalDateTime.now();
            System.out.println("Today is " + today);

            // Specify the date/time format you will want to use
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy ");
            String formattedDate = today.format(fmt);
            System.out.println(formattedDate);

            DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd ");
            String formattedDate1 = today.format(fmt);
            System.out.println(formattedDate1);

            DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
            String formattedDate2 = today.format(fmt2);
            System.out.println(formattedDate2);

            DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
            String formattedDate3 = today.format(fmt3);
            System.out.println(formattedDate3);
        }
    }



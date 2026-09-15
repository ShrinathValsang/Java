package com.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class LogFilter {


    public static void main(String[] args) {
        //Problem: Given a List of logRecords write a method to find the log records between two DateTime using Java Streams API
        //e.g. Given
        List<String> logRecords = Arrays.asList(
                "2023-06-21 14:35:00 INFO Application started successfully",
                "2023-06-21 14:40:00 DEBUG Loading configuration",
                "2023-06-21 14:45:00 INFO Application shutdown",
                "2023-06-21 14:50:00 ERROR Failed to load resource"
        );
        //Find records between “2023-06-21 14:35:0” and “2023-06-21 14:45:00”
        String start = "2023-06-21 14:35:00";
        String end = "2023-06-21 14:45:00";

        LocalDateTime from = LocalDateTime.of(2023, 6, 21, 14, 35, 00);
        LocalDateTime to = LocalDateTime.of(2023, 6, 21, 14, 45, 00);


        List<String> filtered = logRecords.stream()
                .filter(s -> {
                    /*String[] arr = s.split(" ");
                    DateTime dt = DateTime(arr[0] + " " arr[1]);
                    return dt*/
                    //return new LogRecord(arr[0] + " " arr[1], arr[0],  arr[3]);
                    String[] arr = s.split(" ");

                    String date [] = arr[0].split("-");
                    String time [] = arr[1].split(":");
                    LocalDate ld = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                    LocalTime lt = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
                    LocalDateTime ldt = LocalDateTime.of(ld, lt);

                    //return ldt.isAfter(from) && ldt.isBefore(to));
                    return (ldt.isAfter(from) || ldt.isEqual(from)) && (ldt.isBefore(to) || ldt.isEqual(to));
                })
                .toList();

        // Result
        //System.out.println(filtered);

        List<String> filtered1 = findLogs(logRecords, start, end);
        filtered1.stream().forEach(s -> System.out.println(s));
    }


    public static List<String> findLogs(List<String> logRecords, String from, String to) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime from1 = LocalDateTime.parse(from, dateTimeFormatter);
        LocalDateTime to1 = LocalDateTime.parse(to, dateTimeFormatter);

        List<String> filtered = logRecords.stream()
                .filter(s -> {
                        String[] arr = s.split(" ");
                        LocalDateTime ldt = LocalDateTime.parse(arr[0] + " " + arr[1], dateTimeFormatter);
                        return (ldt.isEqual(from1) || ldt.isAfter(from1)) && (ldt.isBefore(to1) || ldt.isEqual(to1));
                }).toList();

        return filtered;
    }

}

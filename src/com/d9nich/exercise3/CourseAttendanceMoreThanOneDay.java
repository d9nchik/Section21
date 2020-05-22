package com.d9nich.exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CourseAttendanceMoreThanOneDay {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("You should provide at least one file");
            System.exit(1);
        }

        Map<String, Integer> courseAttendance = new HashMap<>();
        for (String fileName : args) {
            try (Scanner input = new Scanner(new File(fileName))) {
                while (input.hasNext()) {
                    String name = input.nextLine();
                    courseAttendance.put(name, courseAttendance.containsKey(name) ? courseAttendance.get(name) + 1 : 1);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File not found!");
            }
        }

        System.out.println("Result: ");
        new TreeMap<>(courseAttendance).forEach((key, value)->{
            if (value>1)
                System.out.println(key);
        });
    }
}

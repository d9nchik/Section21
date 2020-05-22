package com.d9nich.exercise3;

import com.d9nich.exercise6.CourseAttendanceSorted;

import java.util.*;

public class CourseAttendanceMoreThanOneDay {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("You should provide at least one file");
            System.exit(1);
        }

        Map<String, Integer> courseAttendance = CourseAttendanceSorted.getStringIntegerMap(args);

        System.out.println("Result: ");
        new TreeMap<>(courseAttendance).forEach((key, value)->{
            if (value>1)
                System.out.println(key);
        });
    }
}

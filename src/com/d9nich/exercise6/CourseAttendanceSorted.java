package com.d9nich.exercise6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.ToIntFunction;

public class CourseAttendanceSorted {
    public static void main(String[] args) {
        Map<String, Integer> courseAttendance = getStringIntegerMap(args);

        System.out.println("Result: ");
        final TreeMap<String, Integer> treeMap = new TreeMap<>(
                Comparator.comparingInt((ToIntFunction<String>) courseAttendance::get).reversed().thenComparing(e -> e));
        treeMap.putAll(courseAttendance);
        treeMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    public static Map<String, Integer> getStringIntegerMap(String[] args) {
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
        return courseAttendance;
    }
}

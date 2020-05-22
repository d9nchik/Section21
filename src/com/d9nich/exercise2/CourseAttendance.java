package com.d9nich.exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CourseAttendance {
    public static void main(String[] args) {
        if (args.length==0){
            System.out.println("You should provide at least one file");
            System.exit(1);
        }

        Set<String> courseAttendance = new HashSet<>();
        for (String fileName: args) {
            try(Scanner input = new Scanner(new File(fileName))) {
                while (input.hasNext())
                    courseAttendance.add(input.next());
            }catch (FileNotFoundException ex){
                System.out.println("File not found!");
            }
        }

        System.out.println("Result: ");
        new TreeSet<>(courseAttendance).forEach(System.out::println);
    }
}

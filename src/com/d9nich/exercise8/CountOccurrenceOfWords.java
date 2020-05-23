package com.d9nich.exercise8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountOccurrenceOfWords {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("You should provide a text file name!");
            System.exit(1);
        }
        Map<String, Integer> hashMap = new HashMap<>();
        try (Scanner input = new Scanner(new File(args[0]))) {
            while (input.hasNext()) {
                String[] words = input.nextLine().split("[ ,;:.?'\"]+");
                for (String word : words) {
                    if (word.matches("^[^a-zA-Z].*")||word.equals(""))
                        continue;
                    word = word.toLowerCase();
                    hashMap.put(word, hashMap.containsKey(word) ? hashMap.get(word) + 1 : 1);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(hashMap);
        sortedMap.forEach((key, value) -> System.out.println(key + " - " + value + " times."));
    }
}

package com.d9nich.exercise7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.ToIntFunction;

public class CountOccurrenceOfWords {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = getWords(args);

        TreeMap<String, Integer> sortedMap = new TreeMap<>(Comparator.comparingInt((ToIntFunction<String>) hashMap::get)
                .reversed().thenComparing(e -> e));
        sortedMap.putAll(hashMap);
        sortedMap.forEach((key, value) -> System.out.println(key + " - " + value + " times."));
    }

    public static Map<String, Integer> getWords(String[] args) {
        if (args.length != 1) {
            System.out.println("You should provide a text file name!");
            System.exit(1);
        }
        Map<String, Integer> hashMap = new HashMap<>();
        try (Scanner input = new Scanner(new File(args[0]))) {
            while (input.hasNext()) {
                String[] words = input.nextLine().split("[ ,;:.?'\"]+");
                for (String word : words) {
                    if (word.matches("^[^a-zA-Z].*") || word.equals(""))
                        continue;
                    word = word.toLowerCase();
                    hashMap.put(word, hashMap.containsKey(word) ? hashMap.get(word) + 1 : 1);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
        return hashMap;
    }
}

package com.d9nich.exercise8;

import java.util.Map;
import java.util.TreeMap;

public class CountOccurrenceOfWords {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = com.d9nich.exercise7.CountOccurrenceOfWords.getWords(args);

        TreeMap<String, Integer> sortedMap = new TreeMap<>(hashMap);
        sortedMap.forEach((key, value) -> System.out.println(key + " - " + value + " times."));
    }
}

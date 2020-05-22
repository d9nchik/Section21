package com.d9nich.exercise1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Set<String> firstSet = new HashSet<>(Arrays.asList("Chemistry", "Mathematics", "Biology", "English"));
        Set<String> secondSet = new HashSet<>(Arrays.asList("Biology", "English", "Geography", "Physics"));
        Set<String> tempSet = new HashSet<>(firstSet);
        tempSet.removeAll(secondSet);
        System.out.println("Only present in first stack: " + tempSet);
        tempSet = new HashSet<>(secondSet);
        tempSet.removeAll(firstSet);
        System.out.println("Only present in first set: " + tempSet);
        firstSet.retainAll(secondSet);
        System.out.println("Preset in both sets: " + firstSet);
    }
}

package com.d9nich.exercise4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsonantsAndVowelsCounter {
    public static void main(String[] args) {
        System.out.print("Enter text file name: ");
        File file = new File(new Scanner(System.in).nextLine());
        long consonant = 0;
        long vowels = 0;
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String line = input.nextLine().toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (symbol >= 'a' && symbol <= 'z') {
                        if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u')
                            vowels++;
                        else
                            consonant++;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonant: " + consonant);
    }
}

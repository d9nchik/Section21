package com.d9nich.exercise12;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;

public class NameForBothGenders {
    public static void main(String[] args) {
        System.out.print("Enter a year: ");
        HashSet<String> notGenderName = getRankingYear(new Scanner(System.in).nextInt());
        System.out.println(notGenderName.size() + " name used for both genders");
        System.out.print("They are ");
        notGenderName.forEach(e -> System.out.print(e + " "));
    }

    private static HashSet<String> getRankingYear(int year) {
        HashSet<String> boys = new HashSet<>();
        HashSet<String> girls = new HashSet<>();
        try {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking"
                    + year + ".txt");
            Scanner input = new Scanner(url.openStream());
            int rankNumber = 1;
            while (input.hasNext()) {
                String[] words = input.nextLine().split("\\s+");
                boys.add(words[1]);
                girls.add(words[3]);
            }
        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        } catch (IOException ex) {
            System.out.println("I/O Errors: no such file");
        }
        boys.retainAll(girls);
        return boys;
    }
}

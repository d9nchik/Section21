package com.d9nich.exercise13;

import java.util.HashMap;
import java.util.Scanner;

import static com.d9nich.exercise11.BabyNameRanking.*;

@SuppressWarnings("unchecked")
public class BabyNamePopularity {
    public static void main(String[] args) {
        HashMap<String, Integer>[] boys = new HashMap[FINISH_YEAR - START_YEAR + 1];
        HashMap<String, Integer>[] girls = new HashMap[FINISH_YEAR - START_YEAR + 1];
        getRankingYearDiapason(boys, girls);

        Scanner input = new Scanner(System.in);
        boolean isLoop = true;

        while (isLoop) {
            System.out.print("Enter the year: ");
            int year = input.nextInt();
            System.out.print("Enter the gender: ");
            char gender = input.next().charAt(0);
            System.out.print("Enter the name: ");
            String name = input.next();
            if (gender == 'M') {
                int rank = getNameRankInYear(boys, year, name);
                System.out.println(rank > 0 ? "Boy name " + name + " is ranked #" + rank +
                        " in year" + year : "Name is not in year list");
            } else {
                int rank = getNameRankInYear(girls, year, name);
                System.out.println(rank > 0 ? "Girl name " + name + " is ranked #" + rank +
                        " in year" + year : "Name is not in year list");
            }
            System.out.print("Enter another inquiry? ");
            isLoop = input.next().charAt(0) == 'Y';
        }
    }
}

package com.d9nich.exercise15;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RepeatAdditionQuiz {
    public static void main(String[] args) {
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);

        // Create a Scanner
        Scanner input = new Scanner(System.in);
        Set<Integer> guesses = new HashSet<>();
        System.out.print(
                "What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();

        while (number1 + number2 != answer) {
            if (guesses.contains(answer))
                System.out.println("You already entered " + answer);
            else
                guesses.add(answer);
            System.out.print("Wrong answer. Try again. What is "
                    + number1 + " + " + number2 + "? ");
            answer = input.nextInt();
        }

        System.out.println("You got it!");
    }
}

package com.d9nich.exercise9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StatesQuiz {
    public static void main(String[] args) {
        String[][] states = {{"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"}
        };//TODO: add more states and capitals
        Map<String, String> statesMap = new HashMap<>();
        for (String[] state : states)
            statesMap.put(state[0], state[1]);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter state name: ");
        String stateName = input.nextLine();
        if (statesMap.containsKey(stateName))
            System.out.println("It`s capital is " + statesMap.get(stateName));
        else
            System.out.println("Sorry, this state is not in our table.");
    }

}

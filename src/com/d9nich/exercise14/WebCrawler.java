package com.d9nich.exercise14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class WebCrawler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine();
        crawler(url); // Traverse the Web from the a starting url
    }

    public static void crawler(String startingURL) {
        Set<String> listOfPendingURLs = new HashSet<>();
        Set<String> listOfTraversedURLs = new HashSet<>();

        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() &&
                listOfTraversedURLs.size() <= 100) {
            Iterator<String> stringIterator = listOfPendingURLs.iterator();
            String urlString = stringIterator.next();
            listOfPendingURLs.remove(urlString);
            listOfTraversedURLs.add(urlString);
            System.out.println("Crawl " + urlString);

            getSubURLs(urlString).forEach(e -> {
                if (!listOfTraversedURLs.contains(e))
                    listOfPendingURLs.add(e);
            });
        }
    }

    public static Set<String> getSubURLs(String urlString) {
        Set<String> set = new HashSet<>();

        try {
            java.net.URL url = new java.net.URL(urlString);
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) { // Ensure that a correct URL is found
                        set.add(line.substring(current, endIndex));
                        current = line.indexOf("http:", endIndex);
                    } else
                        current = -1;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return set;
    }
}

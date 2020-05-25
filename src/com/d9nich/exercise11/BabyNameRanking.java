package com.d9nich.exercise11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class BabyNameRanking extends Application {

    public static final int START_YEAR = 2001;
    public static final int FINISH_YEAR = 2010;

    public static void main(String[] args) {
        launch(args);
    }

    public static void getRankingYearDiapason(HashMap<String, Integer>[] boys, HashMap<String, Integer>[] girls) {
        for (int i = START_YEAR; i <= FINISH_YEAR; i++) {
            HashMap<String, Integer> boy = new HashMap<>();
            boys[i - START_YEAR] = boy;
            HashMap<String, Integer> girl = new HashMap<>();
            girls[i - START_YEAR] = girl;
            getRankingYear(boy, girl, i);
        }
    }

    public static void getRankingYear(HashMap<String, Integer> boys, HashMap<String, Integer> girls, int year) {
        try {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking"
                    + year + ".txt");
            Scanner input = new Scanner(url.openStream());
            int rankNumber = 1;
            while (input.hasNext()) {
                String[] words = input.nextLine().split("\\s+");
                boys.put(words[1], rankNumber);
                girls.put(words[3], rankNumber++);
            }
        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        } catch (IOException ex) {
            System.out.println("I/O Errors: no such file");
        }
    }

    public static int getNameRankInYear(HashMap<String, Integer>[] gender, int year, String name) {
        if (gender[year - START_YEAR].containsKey(name))
            return gender[year - START_YEAR].get(name);
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) {
        HashMap<String, Integer>[] boys = new HashMap[FINISH_YEAR - START_YEAR + 1];
        HashMap<String, Integer>[] girls = new HashMap[FINISH_YEAR - START_YEAR + 1];
        getRankingYearDiapason(boys, girls);

        BorderPane pane = new BorderPane();

        GridPane gridPane = new GridPane();
        pane.setCenter(gridPane);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(new Text("Select a year: "), 0, 0);
        ComboBox<Integer> year = new ComboBox<>();
        gridPane.add(year, 1, 0);
        for (int i = START_YEAR; i <= FINISH_YEAR; i++)
            year.getItems().add(i);
        year.setValue(START_YEAR);

        gridPane.add(new Text("Boy or girl?"), 0, 1);
        ComboBox<String> gender = new ComboBox<>();
        gridPane.add(gender, 1, 1);

        gender.getItems().addAll("Male", "Female");
        gender.setValue("Male");
        gridPane.add(new Text("Enter a name:"), 0, 2);
        TextField name = new TextField();
        gridPane.add(name, 1, 2);

        Button findRanking = new Button("Find Ranking");
        gridPane.add(findRanking, 1, 3);

        Text rankText = new Text("Fill all fields and press 'find'");
        pane.setBottom(rankText);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise 11");
        primaryStage.show();

        findRanking.setOnAction(e -> {
            if (gender.getValue().equals("Male")) {
                int rank = getNameRankInYear(boys, year.getValue(), name.getText());
                rankText.setText(rank > 0 ? "Boy name " + name.getText() + " is ranked #" + rank +
                        "in year" + year.getValue() : "Name is not in year list");
            } else {
                int rank = getNameRankInYear(girls, year.getValue(), name.getText());
                rankText.setText(rank > 0 ? "Girl name " + name.getText() + " is ranked #" + rank +
                        "in year" + year.getValue() : "Name is not in year list");
            }
        });
    }
}

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

public class BabyNameRanking extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        GridPane gridPane = new GridPane();
        pane.setCenter(gridPane);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(new Text("Select a year: "), 0, 0);
        ComboBox<Integer> year = new ComboBox<>();
        gridPane.add(year, 1, 0);
        for (int i = 2001; i <= 2010; i++)
            year.getItems().add(i);
        year.setValue(2001);

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
    }
}

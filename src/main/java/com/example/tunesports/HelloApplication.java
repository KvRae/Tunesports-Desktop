package com.example.tunesports;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements EventHandler {
    Button button ;
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hello There");
        button = new Button();
        button.setText("new text");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        button.setOnAction(this);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(Event event) {
        if (event.getSource()==button)
            System.out.println( "nice gg");
    }
}
package com.example.demo;
import Library_System.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import java.net.ConnectException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.*;
import javafx.stage.*;


public class Main extends Application {
    public static void main(String[] args) {
        ArrayLists.addElementsDemo();
        launch();
    }
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Library");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

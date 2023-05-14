package com.example.demo;

import Library_System.ArrayLists;
import Library_System.Book;
import Library_System.Library;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.List;

public class LibrarianController {
    List<HBoxCell> list = new ArrayList<>();
    List<HBoxCell> list2 = new ArrayList<>();
    HBoxCell x = new HBoxCell(" Book Name", "");
    @FXML
    ListView<HBoxCell> listView;
    public class HBoxCell extends HBox {
        HBoxCell(String labelText, String buttonText) {
            super();
            Label label = new Label();
            Button button;
            ArrayLists.addElementsDemo();
            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            if (labelText.equals(" Book Name")){
                label.setStyle("-fx-font-weight: bold; -fx-font-size: 15");

            }
            HBox.setHgrow(label, Priority.ALWAYS);

            if (! buttonText.equals("")) {
                button = new Button();
                button.setText(buttonText);
                this.getChildren().addAll(label, button);
                if(buttonText.equals("Rent")) {
                    button.setOnAction(e -> {
                        Book x = new Library().Search(labelText);
                        ArrayLists.list2.get(0).AddToOrderList(x);
                        x.Quantity--;
                    });
                }
            }
            else{
                this.getChildren().addAll(label);
            }

        }
    }
    public void viewBooks(ActionEvent e) {
        ArrayLists.addElementsDemo();
        if (list.size() == 0) {
            list.add(new HBoxCell(" Book Name", ""));
            list.get(0).setStyle("-fx-background-color: #0598ff");
            for (int i = 0; i < new Library().Books.size(); i++) {
                list.add(new HBoxCell(new Library().Books.get(i).Name, ""));
            }
            ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
            listView.setItems(myObservableList);
        }
        else{
            list.get(0).setStyle("-fx-background-color: #0598ff");
            ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
            listView.setItems(myObservableList);
        }
    }
}

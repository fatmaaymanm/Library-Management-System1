package com.example.demo;

import Library_System.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.util.Callback;

import java.util.*;


public class readerController {
    List<HBoxCell> list = new ArrayList<>();
    List<HBoxCell> list2 = new ArrayList<>();
    HBoxCell x = new HBoxCell(" Book Name", "");
    @FXML
    ListView<HBoxCell> listView;
    @FXML
    Text readerName;

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
                else if(buttonText.equals("Delete")){
                    button.setOnAction(e -> {
                        ArrayLists.list2.get(0).removeFromOrderList(labelText);
                        System.out.println(list2);
                        refreshList();
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
                list.add(new HBoxCell(new Library().Books.get(i).Name, "Rent"));
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
    public void viewOrderList(ActionEvent ex) {
        refreshList();
    }
    public void refreshList(){
        if (list2.isEmpty()) {
            list2.add(x);
            list2.get(0).setStyle("-fx-background-color: #0598ff");
            ObservableList<HBoxCell> myObservableList2 = FXCollections.observableList(list2);
            listView.setItems(myObservableList2);
        }
        else{
            list2.clear();
            list2.add(x);
            list2.get(0).setStyle("-fx-background-color: #0598ff");
            ArrayLists.addElementsDemo();
            HBoxCell[] arr = new HBoxCell[ArrayLists.list2.get(0).OrderList.size()];
            for (int i = 0; i < ArrayLists.list2.get(0).OrderList.size(); i++) {
                arr[i] = new HBoxCell(ArrayLists.list2.get(0).OrderList.get(i), "Delete");
            }
            for (HBoxCell hBoxCell : arr) {
                if (!list2.contains(hBoxCell)) {
                    list2.add(hBoxCell);
                }
            }
            ObservableList<HBoxCell> myObservableList2 = FXCollections.observableList(list2);
            listView.setItems(myObservableList2);
        }
    }
}

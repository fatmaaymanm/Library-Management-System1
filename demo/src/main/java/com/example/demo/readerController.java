package com.example.demo;

import Library_System.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;
import java.util.*;


public class readerController {
    Readers User;
    List<HBoxCell> list = new ArrayList<>();
    static List<HBoxCell> list2 = new ArrayList<>();
    HBoxCell x = new HBoxCell(" Book Name", "");
    @FXML
    ListView<HBoxCell> listView;
    @FXML
    Text readerName;
    @FXML
    Button logoutbtn;
    public void initialize(){
        User = ArrayLists.getLoggedin();
    }
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
                        Book x = User.Account.Search(labelText);
                        User.AddToOrderList(x);
                        User.Account.Rent(x.Name, User);
                        x.Quantity ++;
                    });
                }
                else if(buttonText.equals("Delete")){
                    button.setOnAction(e -> {
                        User.removeFromOrderList(labelText);
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
            for (int i = 0; i < User.Account.Books.size(); i++) {
                list.add(new HBoxCell(User.Account.Books.get(i).Name, "Rent"));
            }
            ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
            listView.setItems(myObservableList);
        }
        else{
            list.get(0).setStyle("-fx-background-color: #0598ff");
            ObservableList<HBoxCell> myObservableList1 = FXCollections.observableList(list);
            listView.setItems(myObservableList1);
        }
    }
    public void viewOrderList(ActionEvent ex) {
        refreshList();
    }
    public void refreshList(){
        if (list2.isEmpty()) {
            list2.add(x);
            list2.get(0).setStyle("-fx-background-color: #0598ff");
            ObservableList<HBoxCell> myObservableList3 = FXCollections.observableList(list2);
            listView.setItems(myObservableList3);
        }
        else{
            list2.clear();
            list2.add(x);
            list2.get(0).setStyle("-fx-background-color: #0598ff");
            for (int i = 0; i < User.OrderList.size(); i++) {
                list2.add(new HBoxCell(User.OrderList.get(i), "Delete"));
            }
            ObservableList<HBoxCell> myObservableList2 = FXCollections.observableList(list2);
            listView.setItems(myObservableList2);
        }
    }
    public void logout() throws IOException {
        User.isLoggedin = false;
        LoginController.msg = "";
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene homeScene = new Scene(root, Color.TRANSPARENT);
        Stage window = (Stage) (logoutbtn.getScene().getWindow());
        window.setScene(homeScene);
        window.show();
    }
}

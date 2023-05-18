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
    List<HBoxCell> list3 = new ArrayList<>();
    HBoxCell x = new HBoxCell(" Book Name", "");
    @FXML
    ListView<HBoxCell> listView;
    @FXML
    Text readerName;
    @FXML
    Button logoutbtn;
    @FXML
    Text error, success;
    @FXML
    TextField search1;
    @FXML
    Button search2;
    @FXML
    ListView search3;
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static int toInt(String strNum) {
        int d;
        try {
            d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return 0;
        }
        return d;
    }
    public void initialize(){
        User = ArrayLists.getLoggedin();
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
    }
    public class HBoxCell extends HBox {
        public Label label;
        public Button button;
        HBoxCell(String labelText, String buttonText) {
            super();
            label = new Label();
            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            if (labelText.equals(" Book Name")){
                label.setStyle("-fx-font-weight: bold; -fx-font-size: 15");

            }
            HBox.setHgrow(label, Priority.ALWAYS);

            if (! buttonText.equals("")) {
                button = new Button();
                button.setStyle("-fx-cursor: hand; -fx-background-color: #0589ff; -fx-text-fill: white");
                button.setText(buttonText);
                this.getChildren().addAll(label, button);
            }
            else{
                this.getChildren().addAll(label);
            }

        }
    }
    public void viewBooks(ActionEvent e) {
        success.setText("");
        error.setText("");
        listView.setVisible(true);
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
        if (list.size() == 0) {
            list.add(new HBoxCell(" Book Name", ""));
            list.get(0).setStyle("-fx-background-color: #0598ff");
            for (int i = 0; i < User.Account.Books.size(); i++) {
                HBoxCell bookCell = new HBoxCell(User.Account.Books.get(i).Name, "Rent");
                Book temp1 = User.Account.Books.get(i);
                bookCell.button.setOnAction(event -> {
                    if (! User.checkBookOrderList(bookCell.label.getText())) {
                        User.AddToOrderList(temp1);
                        User.Account.Rent(temp1.Name, User);
                        temp1.readersID.add(User.ID);
                        success.setText("Book Rented");
                        error.setText("");
                    }
                    else{
                        error.setText("Book Already in Order List");
                        success.setText("");
                    }
                });
                list.add(bookCell);
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
        success.setText("");
        error.setText("");
        listView.setVisible(true);
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
        list2.clear();
        list2.add(x);
        list2.get(0).setStyle("-fx-background-color: #0598ff");
        for (int i = 0; i < User.OrderList.size(); i++) {
            HBoxCell orderItem = new HBoxCell(User.OrderList.get(i), "Delete");
            orderItem.button.setOnAction(event -> {
                User.removeFromOrderList(orderItem.label.getText());
                for (Book item: User.Account.Books){
                    if (item.Name.equals(orderItem.label.getText())) {
                        item.removeReadID(User.ID);
                        error.setText("Book Deleted");
                        refreshList();
                    }
                }

            });
            list2.add(orderItem);
        }
        ObservableList<HBoxCell> myObservableList2 = FXCollections.observableList(list2);
        listView.setItems(myObservableList2);
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
    public void search(){
        error.setText("");
        success.setText("");
        listView.setVisible(false);
        search1.setVisible(true);
        search2.setVisible(true);
        search3.setVisible(true);
        list3.clear();
        ObservableList<HBoxCell> myObservableList2 = FXCollections.observableList(list3);
        search3.setItems(myObservableList2);
        search2.setOnAction(event -> {
            list3.clear();
            for(int i=0; i<new Library().Books.size();i++){
                if (search1.getText().equals("")){
                    error.setText("Please Enter Text in Search Box");
                    break;
                }
                else if (isNumeric(search1.getText())) {
                    error.setText("Please Search With Book Name");
                    break;
                }
                else{
                    error.setText("");
                }
                if (new Library().Books.get(i).Name.toLowerCase().replaceAll(" ","")
                        .contains(search1.getText().toLowerCase().replaceAll(" ",""))){
                    list3.add(new HBoxCell(new Library().Books.get(i).Name, ""));
                }
            }
            ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list3);
            search3.setItems(myObservableList);
        });
    }
}

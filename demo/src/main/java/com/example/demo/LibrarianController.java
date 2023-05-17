package com.example.demo;

import Library_System.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibrarianController {
    Librarians User;
    List<HBoxCell> list = new ArrayList<>();
    List<HBoxCell> list2 = new ArrayList<>();
    List<HBoxCell> list3 = new ArrayList<>();
    HBoxCell x = new HBoxCell(" Book Name", "");
    @FXML
    TextField search1;
    @FXML
    Button search2;
    @FXML
    ListView search3;
    public void initialize(){
        User = ArrayLists.getLoggedinlib();
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
    }
    @FXML
    ListView<HBoxCell> listView;
    @FXML
    Button logoutbtn;
    @FXML
    Text error;
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
    public class HBoxCell extends HBox {
        Label label;
        Button button;
        TextField textin;
        HBoxCell(String labelText, String buttonText) {
            super();
            label = new Label();
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
        HBoxCell() {
            textin = new TextField();
            button = new Button("Save");
            HBox.setHgrow(textin, Priority.ALWAYS);
            ArrayLists.addElementsDemo();
            this.getChildren().addAll(textin, button);
        }
    }
    public void viewBooks(ActionEvent e) {
        error.setVisible(false);
        listView.setVisible(true);
        ArrayLists.addElementsDemo();
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
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
        error.setVisible(true);
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
    public void readerOrderlist(){
        error.setVisible(false);
        listView.setVisible(true);
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
        ArrayLists.addElementsDemo();
        if (list2.size() == 0) {
            refreshList();
            ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list2);
            listView.setItems(myObservableList);
        }
        else{
            list2.clear();
            refreshList();
        }
    }
    public void refreshList(){
        for (Book item:new Library().Books) {
            list2.add(new HBoxCell(item.Name, "Add"));
            list2.get(list2.size()-1).button.setOnAction(event -> {
//                item.readersID.add(1513);
                list2.clear();
                refreshList();
            });
            for (int j=0; j< item.readersID.size(); j++){
                list2.add(new HBoxCell(item.readersID.get(j).toString(), "Remove"));
                String w = item.Name;
                int temp = item.readersID.get(j);
                list2.get(list2.size()-1).button.setOnAction(event -> {
                    new Library().Search(w).removeReadID(temp, new Library().Search(w));
                    list2.clear();
                    refreshList();
                });
            }
        }
        for (int x = 0; x < list2.size(); x++){
            if(!isNumeric(list2.get(x).label.getText())){
                list2.get(x).label.setStyle("-fx-font-weight: bold; -fx-underline: true;");
            }
        }
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list2);
        listView.setItems(myObservableList);
    }
    public void viewReaders() {
        listView.setVisible(true);
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
        ArrayLists.addElementsDemo();
    }
}

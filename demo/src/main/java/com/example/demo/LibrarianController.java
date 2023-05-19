package com.example.demo;

import Library_System.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
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
    List<HBoxCell> list4 = new ArrayList<>();
    HBoxCell x = new HBoxCell(" Book Name", "");
    @FXML
    TextField search1;
    @FXML
    Button search2;
    @FXML
    ListView search3;
    @FXML
    RadioButton rad1, rad2;
    public void initialize(){
        User = ArrayLists.getLoggedinlib();
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
        book.setVisible(false);
    }
    @FXML
    ListView<HBoxCell> listView;
    @FXML
    Button logoutbtn;
    @FXML
    Text error, success;
    @FXML
    AnchorPane add1, book;
    @FXML
    Text add2, add4, add6, val1, val2, val3;
    @FXML
    TextField add3, book1, book2, book3;
    @FXML
    Button add5, addbook, book4;
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
    public class HBoxCell extends HBox {
        Label label;
        Button button;
        Button button2;
        TextField textin;
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
        HBoxCell(String labelText, String buttonText, String buttonText2) {
            super();
            label = new Label();
            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            if (labelText.equals(" Reader\'s ID")){
                label.setStyle("-fx-font-weight: bold; -fx-font-size: 15");
            }
            HBox.setHgrow(label, Priority.ALWAYS);

            if (! buttonText.equals("")) {
                button = new Button(buttonText);
                button.setStyle("-fx-cursor: hand; -fx-background-color: #0589ff; -fx-text-fill: white");
                button2 = new Button(buttonText2);
                button2.setStyle("-fx-cursor: hand; -fx-background-color: #0589ff; -fx-text-fill: white");
                this.getChildren().addAll(label, button, button2);
            }
            else{
                this.getChildren().addAll(label, button2);
            }

        }
    }
    public Boolean checkBook(String x){
        if (!isNumeric(x) && !x.equals("")){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean checkBook2(String x){
        if (isNumeric(x) && !x.equals("")){
            return true;
        }
        else {
            return false;
        }
    }
    public void viewBooks(ActionEvent e) {
        add1.setVisible(false);
        error.setVisible(false);
        addbook.setVisible(true);
        rad1.setVisible(false);
        rad2.setVisible(false);
        book.setVisible(false);
        success.setText("");
        book1.setText("");
        book2.setText("");
        book3.setText("");
        val1.setText("");
        val2.setText("");
        val3.setText("");
        listView.setVisible(true);
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
        addbook.setOnAction(event -> {
            success.setText("");
            listView.setVisible(false);
            addbook.setVisible(false);
            book.setVisible(true);
            book1.setText("");
            book2.setText("");
            book3.setText("");
            book4.setOnAction(event1 -> {
                val1.setText("");
                val2.setText("");
                val3.setText("");
                if (!checkBook(book1.getText())){
                    val1.setText("Invalid Input");
                }
                if (!checkBook(book2.getText())){
                    val2.setText("Invalid Input");
                }
                if (!checkBook2(book3.getText())){
                    val3.setText("Invalid Input");
                }
                if(checkBook(book1.getText()) && checkBook(book2.getText()) && checkBook2(book3.getText())) {
                    new Library().Books.add(new Book(book1.getText(), book2.getText(), toInt(book3.getText())));
                    listView.setVisible(true);
                    addbook.setVisible(true);
                    book.setVisible(false);
                    success.setText("Book Added To Library");
                    refreshBooks();
                }
            });
        });
        refreshBooks();
    }
    public void refreshBooks(){
        rad1.setVisible(false);
        rad2.setVisible(false);
        add1.setVisible(false);
        book.setVisible(false);
        list.clear();
        list.add(new HBoxCell(" Book Name", ""));
        list.get(0).setStyle("-fx-background-color: #0598ff");
        for (Book item: new Library().Books) {
            HBoxCell temp = new HBoxCell(item.Name, "Remove");
            list.add(temp);
            temp.button.setStyle("-fx-cursor: hand; -fx-background-color: #0589ff; -fx-text-fill: white");
            temp.button.setOnAction(event -> {
                new Library().removeBook(item.Name);
                refreshBooks();
            });
        }
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);
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
        rad1.setVisible(true);
        rad2.setVisible(true);
        rad1.setSelected(true);
        rad2.setSelected(false);
        rad1.setOnAction(event -> {
            rad2.setSelected(false);
            search1.setText("");
            rad1.setSelected(true);
            error.setText("");
            list3.clear();
            ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list3);
            search3.setItems(myObservableList);
        });
        rad2.setOnAction(event -> {
            rad1.setSelected(false);
            search1.setText("");
            rad2.setSelected(true);
            error.setText("");
            list3.clear();
            ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list3);
            search3.setItems(myObservableList);
        });
        add1.setVisible(false);
        success.setText("");
        search1.setText("");
        val1.setText("");
        val2.setText("");
        val3.setText("");
        error.setVisible(true);
        addbook.setVisible(false);
        book.setVisible(false);
        listView.setVisible(false);
        search1.setVisible(true);
        search2.setVisible(true);
        search3.setVisible(true);
        list3.clear();
        ObservableList<HBoxCell> myObservableList2 = FXCollections.observableList(list3);
        search3.setItems(myObservableList2);
        search2.setOnAction(event -> {
            if (rad1.isSelected()) {
                list3.clear();
                for (int i = 0; i < new Library().Books.size(); i++) {
                    if (search1.getText().equals("")) {
                        error.setText("Please Enter Text in Search Box");
                        break;
                    }
                    else if (isNumeric(search1.getText())) {
                        error.setText("Please Search With Book Name");
                        break;
                    } else {
                        error.setText("");
                    }
                    if (new Library().Books.get(i).Name.toLowerCase().replaceAll(" ", "")
                            .contains(search1.getText().toLowerCase().replaceAll(" ", ""))) {
                        list3.add(new HBoxCell(new Library().Books.get(i).Name, ""));
                        break;
                    }
                    else{
                        error.setText("Book Not Found");
                    }
                }
                ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list3);
                search3.setItems(myObservableList);
            }
            else {
                list3.clear();
                error.setText("");
                if (search1.getText().equals("")){
                    error.setText("Please Enter Text in Search Box");
                }
                else if (!isNumeric(search1.getText())) {
                    error.setText("Please Search With Reader ID");
                }
                else {
                    for (int i = 0; i < ArrayLists.list2.size(); i++) {
                        if (ArrayLists.list2.get(i).ID == toInt(search1.getText())) {
                            list3.add(new HBoxCell(Integer.toString(ArrayLists.list2.get(i).ID), ""));
                            error.setText("");
                            break;
                        } else {
                            error.setText("Reader Not Found");
                        }
                    }
                }
                ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list3);
                search3.setItems(myObservableList);
            }
        });
    }
    public void readerOrderlist(){
        rad1.setVisible(false);
        rad2.setVisible(false);
        book.setVisible(false);
        add1.setVisible(false);
        success.setText("");
        val1.setText("");
        val2.setText("");
        val3.setText("");
        error.setVisible(false);
        addbook.setVisible(false);
        listView.setVisible(true);
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
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
        rad1.setVisible(false);
        rad2.setVisible(false);
        book.setVisible(false);
        success.setText("");
        val1.setText("");
        val2.setText("");
        val3.setText("");
        add1.setVisible(false);
        for (Book item:new Library().Books) {
            HBoxCell temp13 = new HBoxCell(item.Name, "Add");
            list2.add(temp13);
            temp13.button.setOnAction(event -> {
                add6.setText("");
                add3.setText("");
                listView.setVisible(false);
                add1.setVisible(true);
                add5.setOnAction(event1 -> {
                    for(Readers reader: ArrayLists.list2) {
                        if (add3.getText().equals("")){
                            add6.setText("Please Input Reader's ID");
                            break;
                        }
                        else if (!isNumeric(add3.getText())){
                            add6.setText("Please Input Valid ID");
                            break;
                        }
                        else if (reader.getReader(toInt(add3.getText())).isBlocked){
                            add6.setText("Reader is Blocked");
                            break;
                        }
                        if (add3.getText().equals(Integer.toString(reader.ID)) && !item.checkReadID(toInt(add3.getText()))) {
                            reader.AddToOrderList(item);
                            item.readersID.add(toInt(add3.getText()));
                            add1.setVisible(false);
                            listView.setVisible(true);
                            add3.setText("");
                            add6.setText("");
                            list2.clear();
                            refreshList();
                            break;
                        }
                        else if (item.checkReadID(toInt(add3.getText()))){
                            add6.setText("Reader Already In Book Order List");
                            break;
                        }
                        else{
                            add6.setText("Reader Not Found");
                        }
                    }
                });
            });
            for (int j=0; j< item.readersID.size(); j++){
                int temp3 = item.readersID.get(j);
                list2.add(new HBoxCell(item.readersID.get(j).toString(), "Remove"));
                int temp = item.readersID.get(j);
                list2.get(list2.size()-1).button.setOnAction(event -> {
                    item.removeReadID(temp);
                    Person.searchReader(temp3).removeFromOrderList(item.Name);
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
        rad1.setVisible(false);
        rad2.setVisible(false);
        book.setVisible(false);
        success.setText("");
        val1.setText("");
        val2.setText("");
        val3.setText("");
        add1.setVisible(false);
        addbook.setVisible(false);
        listView.setVisible(true);
        search1.setVisible(false);
        search2.setVisible(false);
        search3.setVisible(false);
        list4.clear();
        for (Readers reader:ArrayLists.list2){
            if (reader.isBlocked == false) {
                HBoxCell temp = new HBoxCell(Integer.toString(reader.ID), "Remove", "Block");
                temp.setSpacing(10);
                temp.button.setOnAction(event -> {
                    ArrayLists.removeReader(reader.ID);
                    viewReaders();
                });
                temp.button2.setOnAction(event -> {
                    reader.isBlocked = true;
                    temp.button2.setDisable(true);
                });
                list4.add(temp);
            }
            else{
                HBoxCell temp = new HBoxCell(Integer.toString(reader.ID), "Remove", "Block");
                temp.setSpacing(10);
                temp.button2.setDisable(true);
                temp.button.setOnAction(event -> {
                    ArrayLists.removeReader(reader.ID);
                    viewReaders();
                });
                temp.button2.setOnAction(event -> {
                    reader.isBlocked = true;
                    temp.button2.setDisable(true);
                });
                list4.add(temp);
            }
        }
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list4);
        listView.setItems(myObservableList);
    }
}
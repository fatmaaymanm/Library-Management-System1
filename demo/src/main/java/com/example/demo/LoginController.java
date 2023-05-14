package com.example.demo;

import Library_System.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.TextStyle;

public class LoginController {
    static String msg = "";
    @FXML
    RadioButton radio1;
    @FXML
    RadioButton radio2;
    @FXML
    TextField email;
    @FXML
    Text validate;
    @FXML
    Text radcheck;
    @FXML
    PasswordField pass;
    @FXML
    Button loginbtn;
    public LoginController() throws IOException {
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
                this.getChildren().addAll(label);
        }
    }
    public void rad1(){
        radcheck.setText("");
        radio1.setSelected(true);
        radio2.setSelected(false);
    }
    public void rad2(){
        radcheck.setText("");
        radio1.setSelected(false);
        radio2.setSelected(true);
    }
    public void submit() throws IOException {
        ArrayLists.addElementsDemo();
        if(radio1.isSelected()) {
            for (Readers x : ArrayLists.list2) {
                if (x.Email.toLowerCase().equals(email.getText().toLowerCase()) && x.password.equals(pass.getText())) {
                    x.isLoggedin = true;
                    Parent root = FXMLLoader.load(getClass().getResource("Readers.fxml"));
                    Scene homeScene = new Scene(root, Color.TRANSPARENT);
                    Stage window = (Stage) (loginbtn.getScene().getWindow());
                    window.setScene(homeScene);
                    window.show();
                    return;
                }
            }
            validate.setText("Wrong Email or Password");
        }
        else if(radio2.isSelected()){
            for (Librarians x : ArrayLists.list1) {
                if (x.Email.toLowerCase().equals(email.getText().toLowerCase()) && x.password.equals(pass.getText())) {
                    x.isLoggedin = true;
                    Parent root = FXMLLoader.load(getClass().getResource("Librarian.fxml"));
                    Scene homeScene = new Scene(root, Color.TRANSPARENT);
                    Stage window = (Stage) (loginbtn.getScene().getWindow());
                    window.setScene(homeScene);
                    window.show();
                    return;
                }
            }
            validate.setText("Wrong Email or Password");
        }
        else {
            radcheck.setText("Please Select One Button");
        }
        msg = "";
    }
    public void reset(){
        validate.setText("");
    }
    public void createAcc() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAcc.fxml"));
        Scene homeScene = new Scene(root, Color.TRANSPARENT);
        Stage window = (Stage) (loginbtn.getScene().getWindow());
        window.setScene(homeScene);
        window.show();
    }
    public void initialize(){
        if (validate != null && !msg.equals("")){
            validate.setText(msg);
        }
    }
}

package com.example.demo;

import Library_System.ArrayLists;
import Library_System.Readers;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Create_Acc_Controller {
    @FXML
    TextField firstname;
    @FXML
    TextField lastname;
    @FXML
    TextField address;
    @FXML
    TextField mobile;
    @FXML
    TextField email;
    @FXML
    TextField password;
    @FXML
    Button createbtn;
    @FXML
    Text created;
    @FXML
    Text created1;
    @FXML
    Text firsterror;
    @FXML
    Text seconderror;
    @FXML
    Text addresserror;
    @FXML
    Text emailerror;
    @FXML
    Text mobilerror;
    @FXML
    AnchorPane back1;


    @FXML
    boolean checkfirstname(){
        for (int i = 0; i < firstname.getText().length(); i++) {
            char ch = firstname.getText().charAt(i);
            if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
                firsterror.setText("Name Can only contain letters");
                return false;
            }
        }
        if(firstname.getText().equals("")){
            firsterror.setText("You Must Fill The Blank");
            return false;
        }
        firsterror.setText("");
        return true;
    }
    boolean checklastname(){
        for (int i = 0; i < lastname.getText().length(); i++) {
            char ch = lastname.getText().charAt(i);
            if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
                seconderror.setText("Name Can only contain letters");
                return false;
            }
        }
        if(lastname.getText().equals("")){
            seconderror.setText("You Must Fill The Blank");
            return false;
        }
        seconderror.setText("");
        return true;
    }
    boolean checkaddress(){
        for (int i = 0; i < address.getText().length(); i++) {
            char ch = address.getText().charAt(i);
            if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
                addresserror.setText("Address Can only contain letters");
                return false;
            }
        }
        if(address.getText().equals("")){
            addresserror.setText("You Must Fill The Blank");
            return false;
        }
        addresserror.setText("");
        return true;
    }
    boolean checkemail(){
       if( email.getText().indexOf('@')==-1){
           if(email.getText().equals("")){
               emailerror.setText("You Must Fill The Blank");
               return false;
           }
           emailerror.setText("Write a valid email");
           return false;
       }
        emailerror.setText("");
       return true;
    }
    boolean checknumber(){
        if(mobile.getText().equals("")){
            mobilerror.setText("You Must Fill The Blank");
            return false;
        }
        try {
            Double.parseDouble(mobile.getText());

        } catch(NumberFormatException e){
            mobilerror.setText("Number Can only contain numbers");
            return false;
        }
        mobilerror.setText("");
        return true;
    }
    @FXML
    void CreateUser() throws IOException {
        checkfirstname();
        checklastname();
        checkaddress();
        checknumber();
        checkemail();
        if (checkfirstname() && checklastname() && checkaddress() && checknumber() && checkemail()) {
            Random rand = new Random();
            int ID = rand.nextInt(10000);
            ArrayLists.list2.add(new Readers(ID, firstname.getText(), lastname.getText(), address.getText(),
                    password.getText(), mobile.getText(), email.getText()));
            LoginController.msg = "Welcome " + firstname.getText() + " " + lastname.getText();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene homeScene = new Scene(root, Color.TRANSPARENT);
            Stage window = (Stage)(createbtn.getScene().getWindow());
            window.setScene(homeScene);
            window.show();
        }
        else{
            created1.setText("Recheck Inputs");
        }
    }
    @FXML
    void gohome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene homeScene = new Scene(root, Color.TRANSPARENT);
        Stage window = (Stage)(createbtn.getScene().getWindow());
        window.setScene(homeScene);
        window.show();
    }


}

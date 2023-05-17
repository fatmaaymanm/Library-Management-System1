package Library_System;

import java.util.Scanner;

public abstract class Person {
    public int ID;
    public String firstName;
    public String lastName;
    public String address;
    public String password;
    public String cellPhone;
    public String Email;
    public Boolean isBlocked;
    public Boolean isLoggedin = false;

    public Person(int ID, String firstName, String lastName, String address, String password, String cellPhone, String email) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.cellPhone = cellPhone;
        this.Email = email;
    }

    public static Readers searchReader(int id) {
        ArrayLists.addElementsDemo();

        for(int i = 0; i < ArrayLists.list2.size(); ++i) {
            if ((ArrayLists.list2.get(i)).ID == id) {
                return ArrayLists.list2.get(i);
            }
        }
        return null;
    }
}
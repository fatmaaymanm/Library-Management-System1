package Library_System;

import java.util.ArrayList;
import java.util.List;

public class Readers extends Person {
    public static int ReadersCounter = 0;
    Library Account;
    ArrayList OrderList;
    public Readers(int ID, String firstName, String lastName, String address, String password, String type, int cellPhone, String email, Boolean isBlocked) {
        super(ID, firstName, lastName, address, password, type, cellPhone, email, isBlocked);
        List<String> OrderList=new ArrayList<String>();
        ReadersCounter++;
    }
    public void AddToOrderList(Book Name){
        OrderList.add(Name);
    }
    }



package Library_System;

import java.util.ArrayList;
import java.util.List;

public class Readers extends Person {
    public static int ReadersCounter = 0;
    public Library Account = new Library();
    public List<String> OrderList=new ArrayList<String>();
    public Readers(int ID, String firstName, String lastName, String address, String password, String type, int cellPhone, String email, Boolean isBlocked) {
        super(ID, firstName, lastName, address, password, type, cellPhone, email, isBlocked);
        ReadersCounter++;
    }
    public void AddToOrderList(Book book_sent){
        OrderList.add("Book Name: " + book_sent.Name);
        book_sent.Quantity--;
    }
}

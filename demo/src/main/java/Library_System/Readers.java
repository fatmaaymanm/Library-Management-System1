package Library_System;

import java.util.ArrayList;
import java.util.List;

public class Readers extends Person {
    public static int ReadersCounter = 0;
    public Library Account = new Library();
    public List<String> OrderList=new ArrayList<String>();
    public Readers(int ID, String firstName, String lastName, String address, String password, String cellPhone, String email) {
        super(ID, firstName, lastName, address, password, cellPhone, email);
        ReadersCounter++;
    }
    public void AddToOrderList(Book book_sent){
        OrderList.add(book_sent.Name);
        book_sent.Quantity--;
    }
    public boolean checkBookOrderList(String book){
        for (int i=0; i<this.OrderList.size(); i++){
            if (this.OrderList.get(i).equals(book)){
                return true;
            }
        }
        return false;
    }
    public void removeFromOrderList(String x) {
        for (int i = 0; i < OrderList.size(); i++)
            if (OrderList.get(i).equals(x)){
                OrderList.remove(i);
            }
    }
}
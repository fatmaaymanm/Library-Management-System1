package Library_System;

import java.util.ArrayList;

public class Book{
    public ArrayList<Integer> readersID = new ArrayList<Integer>();;
    public String Name;
    public String Author;
    public int No_Pages;
    public int Quantity = 0;
    public Book(String name, String auth, int no_p){
        this.Name=name;
        this.Author=auth;
        this.No_Pages = no_p;
        this.Quantity++;
    }
    public void removeReadID(Integer id, Book o){
        for (int i=0; i<o.readersID.size();i++){
            if (o.readersID.get(i).equals(id)){
                o.readersID.remove(i);
            }
        }
    }
}

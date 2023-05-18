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
    public void removeReadID(Integer id){
        for (int i=0; i<this.readersID.size();i++){
            if (this.readersID.get(i).equals(id)){
                this.readersID.remove(i);
            }
        }
    }
    public Boolean checkReadID(int ID){
        for (Integer item: this.readersID){
            if (item.equals(ID))
                return true;
        }
        return false;
    }
}

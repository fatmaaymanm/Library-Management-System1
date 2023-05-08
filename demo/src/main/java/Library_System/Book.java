package Library_System;

public class Book{
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
}

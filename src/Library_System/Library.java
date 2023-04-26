package Library_System;
import java.lang.*;
import java.util.*;
public class Library {
    public static List<Book> Books=new ArrayList<Book>();
    public static List<Readers> libReaders=new ArrayList<Readers>();
    public static List<String> RentedBooks=new ArrayList<String>();
    public Library(){
    }
    public boolean Search(String Key){
        for (Book book : Books) {
            if (book.Name.equals(Key)) {
                if (book.Quantity > 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public void Rent(Book BookName, Readers Obj){
        if(Search(BookName.Name)){
            AddToOrderList(BookName, Obj);
        }
        else{
            System.out.println("Book not found in library");
        }
    }


    public void AddToOrderList(Book Book_sent, Readers Obj){
        Book_sent.ReaderNames.add(Obj);
        Book_sent.Quantity--;
        RentedBooks.add("Book Name: " + Book_sent.Name + "\nReader ID: " + Obj.ID);
    }
}
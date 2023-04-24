package Library_System;
import java.lang.*;
import java.util.*;
public class Library {
    static List<Book> Books=new ArrayList<Book>();
    static List<Readers> libReaders=new ArrayList<Readers>();
    List<String> RentedBooks=new ArrayList<String>();
    public Library(){
    }
    boolean Search(String Key){
        for (Book book : Books) {
            if (book.Name.equals(Key)) {
                if (book.Quantity > 0) {
                    System.out.println("Book Found");
                    return true;
                } else {
                    System.out.println("The Book is Out Of Stock");
                }
            }
        }
        System.out.println("Book not found");
        return false;
    }


    void Rent(Book BookName, Readers Obj){
        if(Search(BookName.Name)){
            RentedBooks.add(BookName.Name);
        }
        else{
            System.out.println("Book not found in library");
        }
        AddToOrderList(BookName, Obj);
    }


    void AddToOrderList(Book Name, Readers Obj){
        Name.ReaderNames.add(Obj);
        Name.Quantity--;
    }
}

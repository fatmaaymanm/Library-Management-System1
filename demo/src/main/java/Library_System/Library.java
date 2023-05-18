package Library_System;

import java.util.ArrayList;
import java.util.List;
public class Library {
    public static List<Book> Books=new ArrayList<Book>();
    public static List<Readers> libReaders=new ArrayList<Readers>();
    public static List<String> RentedBooks=new ArrayList<String>();
    public Library(){
    }
    public Book Search(String Key){
        for (Book book : Books) {
            if (book.Name.equals(Key)) {
                if (book.Quantity > 0) {
                    return book;
                }
            }
        }
        return null;
    }


    public void Rent(String BookName, Readers Obj){

        if(Search(BookName) != null){
            AddToOrderList(Search(BookName), Obj);
        }
    }


    private void AddToOrderList(Book Book_sent, Readers Obj){
        Book_sent.Quantity--;
        Book_sent.readersID.add(Obj.ID);
        RentedBooks.add(Book_sent.Name + "," + Obj.ID);
    }
    public void removeBook(String x){
        for (int i=0; i<Books.size(); i++){
            if (Books.get(i).Name.equals(x)){
                Books.remove(i);
            }
        }
    }
}
package Library_System;
import java.util.ArrayList;
import java.util.List;

public class Book{
    String Name;
    static int Quantity = 0;
    List<Readers> ReaderNames=new ArrayList<Readers>();
    public Book(String x){
        this.Name=x;
        this.Quantity++;
    }
}

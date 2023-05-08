package Library_System;
import Library_System.*;
import java.util.ArrayList;

public class ArrayLists {
    public static ArrayList<Librarians> list1 = new ArrayList();
    public static ArrayList<Readers> list2 = new ArrayList();

    public ArrayLists() {
    }

    public static void addElementsDemo() {
        Librarians l1 = new Librarians(8164, "Ahmed", "Mohsen", "zzz", "1a2b", "admin", 12345, "oo@example.com", false);
        Librarians l2 = new Librarians(3014, "Shreef", "3arfa", "zxz", "3c4d", "admin", 67890, "pp@example.com", false);
        Librarians l3 = new Librarians(2348, "Dalia", "Selim", "zyz", "5e6f", "admin", 10110, "qq@example.com", false);
        list1.add(0, l1);
        list1.add(1, l2);
        list1.add(2, l3);
        Readers r1 = new Readers(7639, "Abdelrahman", "Barakat", "zzz", "1A2B", "reader", 12345, "oo@example.com", false);
        Readers r2 = new Readers(1643, "Fatma", "Ayman", "zxz", "3C4D", "reader", 67890, "pp@example.com", true);
        Readers r3 = new Readers(5046, "Omar", "Alaa", "zyz", "5E6F", "reader", 10110, "qq@example.com", false);
        Readers r4 = new Readers(4359, "Tsneam", "Ahmed", "zyz", "5E6F", "reader", 10110, "qq@example.com", false);
        list2.add(r1);
        list2.add(r2);
        list2.add(r3);
        list2.add(r4);
        l1.addBook("Oliver Twist", "Steven", 650);
        l1.addBook("Blue Elephant1", "Mark", 486);
        l1.addBook("Blue Elephant2", "Omar", 513);
        l1.addBook("Blue Elephant3", "Barakat", 560);
        l1.addBook("Blue Elephant4", "John", 513);
    }
    public Readers getReader(int ID){
        for(int i=0; i<ArrayLists.list2.size();i++) {
            if(ArrayLists.list2.get(i).ID == ID){
                return ArrayLists.list2.get(i);
            }
        }
        return null;
    }
    public Librarians getLibrarian(int ID){
        for(int i=0; i<ArrayLists.list2.size();i++) {
            if(ArrayLists.list1.get(i).ID == ID){
                return ArrayLists.list1.get(i);
            }
        }
        return null;
    }
}
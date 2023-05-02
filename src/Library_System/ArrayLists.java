package Library_System;

import java.util.ArrayList;

public class ArrayLists {
    public static ArrayList<Librarians> list1= new ArrayList<>();
    public static ArrayList<Readers> list2= new ArrayList<>();



    public static void addElementsDemo() {

        Librarians l1 = new Librarians(123, "xxx", "yyy", "zzz", "1a2b",
                "admin", 12345, "oo@example.com", false);
        Librarians l2 = new Librarians(456, "xyx", "yxy", "zxz", "3c4d",
                "admin", 67890, "pp@example.com", false);
        Librarians l3 = new Librarians(789, "xzx", "yzy", "zyz", "5e6f",
                "admin", 10110, "qq@example.com", false);

        list1.add(0,l1);
        list1.add(1,l2);
        list1.add(2,l3);

        Readers r1 = new Readers(123, "xxx", "yyy", "zzz", "1A2B",
                "reader", 12345, "oo@example.com", true);
        Readers r2 = new Readers(456, "xyx", "yxy", "zxz", "3C4D",
                "reader", 67890, "pp@example.com", true);
        Readers r3 = new Readers(789, "xzx", "yzy", "zyz", "5E6F",
                "reader", 10110, "qq@example.com", true);

        list2.add(r1);
        list2.add(r2);
        list2.add(r3);
    }
}

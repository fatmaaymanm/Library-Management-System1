import Library_System.*;

public class Main {
    public static void main(String[] args) {
        Book y = new Book("Harry Potter", "Qube", 300);
        Readers x = new Readers(3,"Trial1", "Last", " ", " ", " ",3 ," ", true);
        Librarians z = new Librarians(36," ", " ", " ", " ", " ",3 ," ", true);
        z.addBook("Harry Potter", "Qube", 300);
        x.Account.Rent(y, x);
        System.out.println(z.Account.RentedBooks.get(0));
//        Person.startMenu();
    }
}
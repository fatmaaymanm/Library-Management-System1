package Library_System;

public class Librarians extends Person {
    Library Account;
    static int LibrariansCounter = 0;
    public Librarians(int ID, String firstName, String lastName, String address, String password,
               String type, int cellPhone, String email, Boolean isBlocked){
        super(ID, firstName, lastName, address, password, type, cellPhone, email, isBlocked);
        LibrariansCounter++;
    }
    public void addBook(String book_name){
        for (int i=0;i<Account.Books.size();i++) {
            if (Account.Books.get(i).Name.equals(book_name)){
                Account.Books.get(i).Quantity++;
                return;
            }
        }
        Book New_book = new Book(book_name);
        Account.Books.add(New_book);
    }
    public void removeBook(String book_name){
        for (int i=0;i<Account.Books.size();i++) {
            if (Account.Books.get(i).Name.equals(book_name)){
                Account.Books.remove(i);
                return;
            }
        }
        System.out.println("This Book Doesn't Exist in Library");
    }
    public void removeUser(int id){
        for (int i=0;i<Account.libReaders.size();i++) {
            if (Account.libReaders.get(i).ID == id) {
                Account.libReaders.remove(i);
                return;
            }
        }
        System.out.println("User Doesn't Exist");
    }
}

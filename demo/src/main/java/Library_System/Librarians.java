package Library_System;

public class Librarians extends Person {
    public Library Account = new Library();
    public static int LibrariansCounter = 0;
    public Librarians(int ID, String firstName, String lastName, String address, String password,
                      String type, String cellPhone, String email,Boolean isBlocked){
        super(ID, firstName, lastName, address, password, cellPhone, email);
        LibrariansCounter++;
    }
    public void addBook(String book_name,String auth , int no_p){
        for (int i=0;i<Account.Books.size();i++) {
            if (Account.Books.get(i).Name.equals(book_name)){
                Account.Books.get(i).Quantity++;
                return;
            }
        }
        Account.Books.add(new Book(book_name,auth ,no_p));
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

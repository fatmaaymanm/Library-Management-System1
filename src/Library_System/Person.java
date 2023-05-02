package Library_System;

import java.util.Scanner;

public abstract class Person {
    public int ID;
    public String firstName;
    public String lastName;
    public String address;
    public String password;
    public String type;
    public int cellPhone;
    public String Email;
    public Boolean isBlocked;

    public Person(int ID, String firstName, String lastName, String address, String password,
                  String type, int cellPhone, String email, Boolean isBlocked) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.type = type;
        this.cellPhone = cellPhone;
        Email = email;
        this.isBlocked = isBlocked;
    }




    public static void registration() {

    }

    public static void login() {
        System.out.println("Library Management System");
        System.out.println("Enter 1 or 2 to choose user type");
        System.out.println("1. Librarian");
        System.out.println("2. Reader");
        System.out.println("3. Back to start menu");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> Person.loginLibrarian();
            case 2 -> Person.loginReader();
            case 3 -> Person.startMenu();
            default -> {
                System.out.println("Error!");
                login();
            }
        }
    }

    public static void logout() {
        startMenu();
    }




    public static void startMenu() {
        System.out.println("Library Management System");
        System.out.println("Enter 1, 2 or 3");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> Person.login();
            case 2 -> Person.registration();
            case 3 -> System.exit(0);
            default -> {
                System.out.println("Error!");
                startMenu();
            }
        }
    }

    public static void mainMenu() {
        System.out.println("Library Management System");
        System.out.println("Enter 1, 2 or 3");
        System.out.println("1. Logout");
        System.out.println("2. Register");


        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> Person.logout();
            case 2 -> Person.registration();
            default -> {
                System.out.println("Error!");
                mainMenu();
            }
        }
    }

    public static boolean searchUserLib(int id, String password) {
        ArrayLists.addElementsDemo();
        boolean flag = false;
        for (int i = 0; i < ArrayLists.list1.size(); i++) {
            if ((ArrayLists.list1.get(i).ID) == id && (ArrayLists.list1.get(i).password).compareTo(password) == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void loginLibrarian() {
        ArrayLists.addElementsDemo();
        System.out.println("Library Management System");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter User ID:" );
        int id = input.nextInt();
        System.out.print("Enter Password:" );
        String password = input.next();

        for (int i = 0; i < ArrayLists.list1.size() ; i++) {
            if (searchUserLib(id, password)) {
                mainMenu();
            } else {
                System.out.println("ID or password is incorrect. Try Again!");
                loginLibrarian();
            }
        }
    }

    public static boolean searchUserRea(int id, String password) {
        ArrayLists.addElementsDemo();
        boolean flag = false;
        for (int i = 0; i < ArrayLists.list2.size(); i++) {
            if ((ArrayLists.list2.get(i).ID) == id && (ArrayLists.list2.get(i).password).compareTo(password) == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void loginReader() {
        ArrayLists.addElementsDemo();
        System.out.println("Library Management System");
        Scanner input = new Scanner(System.in);

        System.out.print("Enter User ID:" );
        int id = input.nextInt();
        System.out.print("Enter Password:" );
        String password = input.next();

        for (int i = 0; i < ArrayLists.list2.size() ; i++) {
            if (searchUserRea(id, password)) {
                mainMenu();
            } else {
                System.out.println("ID or password is incorrect. Try Again!");
                loginReader();
            }
        }
    }





}


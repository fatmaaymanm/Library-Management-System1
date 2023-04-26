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

        mainMenu();
    }

    public static void logout() {
        clearScreen();
        startMenu();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
}


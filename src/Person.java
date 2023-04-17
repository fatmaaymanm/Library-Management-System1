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

    public void registration() {

    }

    public void login() {

    }

    public void logout() {

    }
}


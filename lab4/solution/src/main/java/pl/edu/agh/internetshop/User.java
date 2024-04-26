package pl.edu.agh.internetshop;

public class User {
    private static int FIRST_FREE_ID = 0;
    private final int userId;
    private String firstname;
    private String surname;

    public User(String firstname, String surname) {
        if (firstname == null || surname == null)
            throw new IllegalArgumentException("Firstname, surname cannot be null.");

        this.userId = getFirstFreeId();
        this.firstname = firstname;
        this.surname = surname;
    }

    private int getFirstFreeId() {
        int result = FIRST_FREE_ID;
        FIRST_FREE_ID += 1;
        return result;
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
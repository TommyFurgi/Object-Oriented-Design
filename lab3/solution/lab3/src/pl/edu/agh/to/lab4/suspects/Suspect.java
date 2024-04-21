package pl.edu.agh.to.lab4.suspects;

public abstract class Suspect {
    private final String firstName;

    private final String lastName;


    public Suspect(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String display() {
        return firstName + " " + lastName;
    }

    public abstract int getAge();

    public abstract boolean canBeAccused();
}

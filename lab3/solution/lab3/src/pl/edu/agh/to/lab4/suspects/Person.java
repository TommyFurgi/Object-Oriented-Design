package pl.edu.agh.to.lab4.suspects;

public class Person extends Suspect {
    private final int age;

    public Person(String firstName, String lastName, int age) {
        super(firstName, lastName);
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean canBeAccused(){
        return this.age >= 18;
    }

}

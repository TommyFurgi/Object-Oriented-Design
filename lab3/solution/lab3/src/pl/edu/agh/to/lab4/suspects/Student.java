package pl.edu.agh.to.lab4.suspects;

public class Student extends Suspect{
    private final String index;
    private final int age;

    public Student(String firstName, String lastName, String index, int age){
        super(firstName, lastName);
        this.age = age;
        this.index = index;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public boolean canBeAccused() {
        return this.age >= 18;
    }
}

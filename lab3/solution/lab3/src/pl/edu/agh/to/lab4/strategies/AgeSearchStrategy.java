package pl.edu.agh.to.lab4.strategies;

import pl.edu.agh.to.lab4.suspects.Suspect;

public class AgeSearchStrategy implements SearchStrategy {
    private final int age;

    public AgeSearchStrategy(int age) {
        this.age = age;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getAge() == this.age;
    }
}

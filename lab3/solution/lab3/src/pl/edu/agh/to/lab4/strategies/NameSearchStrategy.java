package pl.edu.agh.to.lab4.strategies;

import pl.edu.agh.to.lab4.suspects.Suspect;

public class NameSearchStrategy implements SearchStrategy {
    private final String name;

    public NameSearchStrategy(String name){
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getFirstName().equals(this.name);
    }
}

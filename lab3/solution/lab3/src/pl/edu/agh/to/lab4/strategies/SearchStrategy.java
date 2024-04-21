package pl.edu.agh.to.lab4.strategies;

import pl.edu.agh.to.lab4.suspects.Suspect;

public interface SearchStrategy {

    public boolean filter(Suspect suspect);
}

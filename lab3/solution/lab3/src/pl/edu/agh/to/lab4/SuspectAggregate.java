package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.suspects.Suspect;

import java.util.Iterator;

public interface SuspectAggregate {
    Iterator<Suspect> iterator();

}

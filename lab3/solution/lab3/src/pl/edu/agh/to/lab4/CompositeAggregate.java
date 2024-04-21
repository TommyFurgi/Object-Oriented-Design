package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.suspects.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CompositeAggregate {
    private final Collection<SuspectAggregate> aggregates;

    public CompositeAggregate(Collection<SuspectAggregate> aggregates) {
        this.aggregates = aggregates;
    }

    public Collection<Suspect> getAllSuspects() {
        Collection<Suspect> result = new ArrayList<>();

        for (SuspectAggregate aggregate : aggregates) {
            Iterator<Suspect> suspectIterator = aggregate.iterator();
            while (suspectIterator.hasNext())
                result.add(suspectIterator.next());
        }
        return result;
    }
}
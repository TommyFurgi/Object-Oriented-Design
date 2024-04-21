package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.strategies.CompositeSearchStrategy;
import pl.edu.agh.to.lab4.strategies.SearchStrategy;
import pl.edu.agh.to.lab4.suspects.Person;
import pl.edu.agh.to.lab4.suspects.Prisoner;
import pl.edu.agh.to.lab4.suspects.Suspect;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {
    private final CompositeAggregate dataAggregate;

    public Finder(Collection<SuspectAggregate> data) {
        this.dataAggregate = new CompositeAggregate(data);
    }


    public Collection<Suspect> display(SearchStrategy strategy) {
        Collection<Suspect> suspects = new ArrayList<>();

        if (strategy == null)
            strategy = new CompositeSearchStrategy(new ArrayList<>());

        for (Suspect suspect : dataAggregate.getAllSuspects()) {
            if (strategy.filter(suspect)) {
                suspects.add(suspect);
            }
            if (suspects.size() >= 10)
                break;
        }

        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");

        for (Suspect sus : suspects) {
            System.out.println(sus);
        }

        return suspects;
    }

    public void displayAllSuspectsWithName(String name) {
        Collection<Suspect> suspects = new ArrayList<>();

        for (Suspect sus : dataAggregate.getAllSuspects()) {
            if (sus.getClass().equals(Prisoner.class) && sus.getFirstName().equals(name))
                suspects.add(sus);
            if (sus.getClass().equals(Person.class) && sus.getFirstName().equals(name))
                suspects.add(sus);
            if (suspects.size() >= 10)
                break;
        }


        int t = suspects.size();
        System.out.println("Znalazlem " + t + " pasujacych podejrzanych!");

        for (Suspect sus : suspects) {
            System.out.println(sus.display());
        }
    }
}

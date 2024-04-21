package pl.edu.agh.to.lab4.strategies;

import pl.edu.agh.to.lab4.suspects.Suspect;

import java.util.Collection;

public class CompositeSearchStrategy implements SearchStrategy {
    private final Collection<SearchStrategy> searchStrategies;
    public CompositeSearchStrategy(Collection<SearchStrategy> strategies) {
        this.searchStrategies = strategies;
    }

    @Override
    public boolean filter(Suspect suspect) {
        for (SearchStrategy strategy : this.searchStrategies) {
            if (!strategy.filter(suspect)) {
                return false;
            }
        }
        return true;
    }
}

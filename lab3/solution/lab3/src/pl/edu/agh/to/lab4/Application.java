package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.data.PersonDataProvider;
import pl.edu.agh.to.lab4.data.PrisonerDataProvider;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Finder suspects = new Finder(Arrays.asList(
                new PersonDataProvider(), new PrisonerDataProvider()));
        suspects.displayAllSuspectsWithName("Janusz");
    }
}

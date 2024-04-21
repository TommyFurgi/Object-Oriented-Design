package pl.edu.agh.to.lab4.suspects;

import pl.edu.agh.to.lab4.suspects.Suspect;

import java.util.Calendar;

public class Prisoner extends Suspect {
    private final int judgementYear;

    private final int sentenceDuration;

    private final String pesel;


    public Prisoner(String firstName, String lastName, String pesel, int judgementYear, int sentenceDuration) {
        super(firstName, lastName);
        this.pesel = pesel;
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    @Override
    public int getAge() {
        final int peselYear = Integer.parseInt(pesel.substring(0, 2));
        final int peselMonth = Integer.parseInt(pesel.substring(2, 4));

        final int birthYear = (peselMonth >= 20) ? 2000 + peselYear : 1900 + peselYear;
        final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - birthYear;
    }

    public String getPesel() {
        return pesel;
    }

    public boolean isSuspect() {
        return judgementYear + sentenceDuration <= getCurrentYear();
    }

    public int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    @Override
    public boolean canBeAccused() {
        return !isSuspect() && getAge() >= 18;
    }

}

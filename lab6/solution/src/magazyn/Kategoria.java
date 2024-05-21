package magazyn;

import java.util.ArrayList;

public class Kategoria implements Drzewo {
    private String nazwa;
    private ArrayList<Towar> towary;

    public Kategoria(String nazwa) {
        this.nazwa = nazwa;
        this.towary = new ArrayList<>();
    }

    public void addTowar(Towar towar) {
        towary.add(towar);
    }

    @Override
    public void wyswietl() {
        System.out.println("Kategoria: " + nazwa);
        for (Towar towar: towary) {
            System.out.println(" - " + towar.getNazwa() + ": " + towar.getCena());
        }
    }
}

package magazyn;

import java.util.ArrayList;

public class PodKategoria implements Drzewo {
    private String nazwa;
    private ArrayList<Drzewo> wezly;

    public PodKategoria(String name) {
        this.nazwa = name;
        this.wezly = new ArrayList<>();
    }

    public void addWezel(Drzewo wezel) {
        wezly.add(wezel);
    }

    @Override
    public void wyswietl() {
        System.out.println("Podkategoria: " + nazwa);
        for (Drzewo wezel : wezly) {
            wezel.wyswietl();
        }
    }
}

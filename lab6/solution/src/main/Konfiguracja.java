package main;

import main.wydrukFaktury.PodstawowaFaktura;
import main.wydrukFaktury.DrukujFakture;
import rabaty.ObliczCenePoRabacie;
import rabaty.ObliczCenePoRabacieKwotowym;

public class Konfiguracja {
    public static Konfiguracja instance;
    private ObliczCenePoRabacie rabat = new ObliczCenePoRabacieKwotowym();
    private DrukujFakture wydruk = new PodstawowaFaktura();

    private Konfiguracja () {

    }

    public static Konfiguracja getKonfiguragcja() {
        if (instance == null) {
            instance = new Konfiguracja();
        }
        return instance;
    }

    public ObliczCenePoRabacie getObliczanieRabatu() {
        return rabat;
    }


    public double getKwotaRabatu() {
        return 1;
    }

    public double getProcentRabatu() {
        return 0.10;
    }

    public DrukujFakture getWydrukFaktury(){
        return wydruk;
    }

}

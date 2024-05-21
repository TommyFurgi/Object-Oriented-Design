package main.wydrukFaktury;

import dokumenty.Faktura;

public abstract class DrukujFakture {

    public DrukujFakture() {}


    public final void wypiszFakture(Faktura faktura) {
        drukujNaglowek(faktura);
        drukujPozycje(faktura);
        drukujStopke(faktura);
    }

    // Metody abstrakcyjne, które będą implementowane przez podklasy
    protected abstract void drukujNaglowek(Faktura faktura);
    protected abstract void drukujPozycje(Faktura faktura);
    protected abstract void drukujStopke(Faktura faktura);
}


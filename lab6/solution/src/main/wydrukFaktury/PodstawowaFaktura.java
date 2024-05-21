package main.wydrukFaktury;

import dokumenty.Faktura;
import dokumenty.Pozycja;

import java.util.Iterator;

public class PodstawowaFaktura extends DrukujFakture {

    public PodstawowaFaktura() {
        super();
    }

    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("Wystawiona dla: "+faktura.getKontrahent());
        System.out.println("FA z dnia: "+faktura.getDataSprzedazy().toString());
    }

    @Override
    protected void drukujPozycje(Faktura faktura) {
        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
        }
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("Na kwote: "+faktura.getSuma());
        System.out.println("=====================================================");
    }
}


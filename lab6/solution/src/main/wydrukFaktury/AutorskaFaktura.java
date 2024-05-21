package main.wydrukFaktury;

import dokumenty.Faktura;
import dokumenty.Pozycja;

import java.util.Iterator;

public class AutorskaFaktura extends DrukujFakture {

    public AutorskaFaktura() {
        super();
    }

    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("Wystawiona dla: "+faktura.getKontrahent());
    }

    @Override
    protected void drukujPozycje(Faktura faktura) {
        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Towar: "+pozycja.getNazwa()+" Wartosc:" + pozycja.getWartosc());
        }
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("Na kwote: "+faktura.getSuma());
        System.out.println("=====================================================");
    }
}

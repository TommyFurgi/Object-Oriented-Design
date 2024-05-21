package main;

import java.util.Calendar;

import magazyn.Kategoria;
import magazyn.PodKategoria;
import magazyn.Towar;

import dokumenty.Faktura;

//ZEWNETRZNY RABAT
import main.wydrukFaktury.WydrukFaktury;
import rabatlosowy.LosowyRabat;


public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();
		
		//Tworzymy towary
		Towar t1=new Towar(10,"buty");
		Towar t2=new Towar(2,"skarpety");
		
		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");
		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);


		Konfiguracja wydrukFaktury = Konfiguracja.getKonfiguragcja();
		wydrukFaktury.getWydrukFaktury().wypiszFakture(f);
//		WydrukFaktury.wypiszFakture(f);

		
		//TEST ZEWN. rabatu
		LosowyRabat lr=new LosowyRabat();
		System.out.println(lr.losujRabat());

		testComposite();
	}

	public static void testComposite(){
		Towar t1=new Towar(10,"buty");
		Towar t2=new Towar(2,"skarpety");
		Towar t3=new Towar(5, "trzwiki");

		Kategoria buty = new Kategoria("Buty");
		Kategoria skarpety = new Kategoria("Skarpety");
		buty.addTowar(t1);
		buty.addTowar(t3);
		skarpety.addTowar(t2);
		PodKategoria sklep = new PodKategoria("Sklep");
		sklep.addWezel(buty);
		sklep.addWezel(skarpety);

		sklep.wyswietl();

	}
}

package rabaty;

import main.Konfiguracja;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie {

    @Override
    public double obliczCenePoRabacie(double cena) {
        Konfiguracja konfiguracja = Konfiguracja.getKonfiguragcja();
        return cena * konfiguracja.getProcentRabatu();
    }
}

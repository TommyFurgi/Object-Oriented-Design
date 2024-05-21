package rabaty;

import rabatlosowy.LosowyRabat;
public class ObliczCenePoRabacieKlasowym extends LosowyRabat implements ObliczCenePoRabacie{
    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena -= cena * losujRabat();
    }
}

package rabaty;

import rabatlosowy.LosowyRabat;

public class ObliczCenePoRabacieObiektowym implements ObliczCenePoRabacie{

    private LosowyRabat lr;

    @Override
    public double obliczCenePoRabacie(double cena) {
        lr = new LosowyRabat();
        return cena - lr.losujRabat();
    }
}

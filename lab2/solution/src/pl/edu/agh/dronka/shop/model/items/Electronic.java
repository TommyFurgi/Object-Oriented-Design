package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Electronic extends Item {

    private boolean wireless;

    private boolean guarantee;

    public Electronic() {
        super();
    }

    public Electronic(String name, Category category, int price, int quantity, boolean wireless, boolean guarantee) {
        super(name, category, price, quantity);
        this.wireless = wireless;
        this.guarantee = guarantee;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public boolean isWireless() {
        return wireless;
    }

    public void setGuarantee(boolean guarantee) {
        this.guarantee = guarantee;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }
}

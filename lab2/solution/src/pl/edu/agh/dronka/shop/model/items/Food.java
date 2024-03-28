package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.time.LocalDate;

public class Food extends Item {
    private final LocalDate bestBeforeDate;

    public Food(String name, Category category, int price, int quantity, LocalDate bestBeforeDate) {
        super(name, category, price, quantity);
        this.bestBeforeDate = bestBeforeDate;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

}

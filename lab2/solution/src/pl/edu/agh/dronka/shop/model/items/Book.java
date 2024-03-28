package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Book extends Item {
    private int numberOfPages;

    private boolean hardcover;

    public Book(){
        super();
        this.numberOfPages = 0;
    }

    public Book(String name, Category category, int price, int quantity, int numberOfPages, boolean hardcover) {
        super(name, category, price, quantity);
        this.numberOfPages = numberOfPages;
        this.hardcover = hardcover;
    }


    public boolean isHardcover() {
        return hardcover;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }
}

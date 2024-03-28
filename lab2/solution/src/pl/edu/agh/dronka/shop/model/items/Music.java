package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

public class Music extends Item {
    private MusicType type;
    private boolean video;

    public Music() {
        super();
        this.type = null;
    }

    public Music(String name, Category category, int price, int quantity, MusicType type, boolean video) {
        super(name, category, price, quantity);
        this.type = type;
        this.video = video;
    }

    public MusicType getType() {
        return type;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

}

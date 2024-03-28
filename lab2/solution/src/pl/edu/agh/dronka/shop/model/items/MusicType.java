package pl.edu.agh.dronka.shop.model.items;

public enum MusicType {
    POP("Pop"),
    RAP("Rap"),
    ROCK("Rock");

    private final String displayName;
    MusicType(String type) {
        this.displayName = type;
    }
    public String getDisplayName() {
        return displayName;
    }

    public static MusicType parse(String string) {
        return switch (string) {
            case "POP" -> POP;
            case "RAP" -> RAP;
            case "ROCK" -> ROCK;
            default -> throw new IllegalStateException("Unexpected value: " + string);
        };
    }
}

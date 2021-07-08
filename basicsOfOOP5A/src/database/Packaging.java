package database;

public class Packaging {
    private String name;
    private String color;
    private int prise;
    private boolean isAvailable;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getPrise() {
        return prise;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Packaging (String name, String color, int prise, boolean isAvailable) {
        this.name = name;
        this.color = color;
        this.prise = prise;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return name + " " + color;
    }
}

package database;

public class FlowerComposition {
    private Flower flower;
    private Packaging packaging;
    private int quantityFlowers;

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public void setQuantityFlowers(int quantityFlowers) {
        this.quantityFlowers = quantityFlowers;
    }

    @Override
    public String toString() {
        return "Композиция из " + quantityFlowers + " " + flower + " обойдется вам в " + (flower.getPrise() * quantityFlowers) + " рублей";
    }
}

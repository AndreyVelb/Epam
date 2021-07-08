package database;

import java.io.IOException;

public abstract class FlowerCompositionBuilder {
    FlowerComposition flowerComposition;

    public void createFlowerComposition(){
        flowerComposition = new FlowerComposition();
    }

    abstract void buildFlower() throws IOException;
    abstract void buildPackaging() throws IOException;
    abstract void buildQuantityFlowers() throws IOException;

    public FlowerComposition getFlowerComposition(){
        return flowerComposition;
    }
}

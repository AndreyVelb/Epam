package database;

import java.io.IOException;

public class Seller {
    FlowerCompositionBuilder builder;

    public void setFlowerCompositionBuilder(FlowerCompositionBuilder flowerCompositionBuilder){
        this.builder = flowerCompositionBuilder;
    }

    FlowerComposition buildFlowerComposition() throws IOException {
        builder.createFlowerComposition();
        builder.buildFlower();
        builder.buildPackaging();
        builder.buildQuantityFlowers();

        FlowerComposition flowerComposition = builder.getFlowerComposition();
        return flowerComposition;
    }
}

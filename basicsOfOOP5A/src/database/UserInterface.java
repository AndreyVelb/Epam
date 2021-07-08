package database;

import java.io.IOException;

public class UserInterface {

    public static void main(String[] args) throws IOException {
        Seller seller = new Seller();
        seller.setFlowerCompositionBuilder(new FlowerCompositionBuilderBuyersChoice());

        FlowerComposition flowerComposition = seller.buildFlowerComposition();

        System.out.println(flowerComposition.toString());
    }
}

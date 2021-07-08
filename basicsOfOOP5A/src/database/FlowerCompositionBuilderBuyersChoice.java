package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlowerCompositionBuilderBuyersChoice extends FlowerCompositionBuilder{

    @Override
    void buildFlower() throws IOException {
        AdminFlowerDataBase adminFlowerDataBase = new AdminFlowerDataBase();
        adminFlowerDataBase.createAdminFlowerDataBase();
        flowerComposition.setFlower(adminFlowerDataBase.printForPurchaseFlowerDataBase());
    }

    @Override
    void buildPackaging() throws IOException {
        AdminPackagingDataBase adminPackagingDataBase = new AdminPackagingDataBase();
        adminPackagingDataBase.createPackagingDataBase();
        flowerComposition.setPackaging(adminPackagingDataBase.printForPurchasePackagingDataBase());
    }

    @Override
    void buildQuantityFlowers() throws IOException {
        System.out.println("Введите колличество цветов которое вы бы хотели приобрести");

        int selectedNumber = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            selectedNumber  = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            System.out.println("Вы ввели не число");
        }

        reader.close();

        if (selectedNumber <= 0){
            System.out.println("Вы ввели неправильное число");
        }
        else flowerComposition.setQuantityFlowers(selectedNumber);
    }
}

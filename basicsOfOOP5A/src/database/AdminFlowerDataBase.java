package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdminFlowerDataBase {
    private List<Flower> adminFlowerDataBase;

    public void createAdminFlowerDataBase(){
        Flower redRosa = new Flower("роза", "красная", 13, true);
        Flower pinkRosa = new Flower("роза", "розовая", 12, true);
        Flower blueRosa = new Flower("роза", "синяя", 25, true);
        Flower whiteLilia = new Flower("лилия", "красная", 13, true);
        Flower yelowLilia = new Flower("лилия", "красная", 16, true);
        Flower redCarnation = new Flower("гвоздика", "красная", 11, true);
        Flower blueCarnation = new Flower("гвоздика", "синяя", 12, true);
        Flower yelowCarnation = new Flower("гвоздика", "желтая", 13, true);
        Flower whiteCarnation = new Flower("гвоздика", "белая", 15, true);

        this.adminFlowerDataBase = new ArrayList<>();
        adminFlowerDataBase.add(redRosa);
        adminFlowerDataBase.add(pinkRosa);
        adminFlowerDataBase.add(blueRosa);
        adminFlowerDataBase.add(whiteLilia);
        adminFlowerDataBase.add(yelowLilia);
        adminFlowerDataBase.add(redCarnation);
        adminFlowerDataBase.add(blueCarnation);
        adminFlowerDataBase.add(yelowCarnation);
        adminFlowerDataBase.add(whiteCarnation);
    }
    public Flower printForPurchaseFlowerDataBase() throws IOException {
        ArrayList<Flower> availableFlowers = new ArrayList<>();
        for(Flower flower : adminFlowerDataBase){
            if(flower.isAvailable() == true) {
                availableFlowers.add(flower);
            }
        }

        for (int i = 0; i < availableFlowers.size(); i++){
            System.out.println((i + 1) + " " + availableFlowers.get(i).toString());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите номер строки тех цветов которые бы вы хотели купить");

        int selectedNumber = 0;
        try {
            selectedNumber  = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            System.out.println("Вы ввели не число");
        }

        if (selectedNumber <= 0 || selectedNumber >= availableFlowers.size()){
            System.out.println("Вы ввели неправильное число");
        }
        else return availableFlowers.get(selectedNumber - 1);

        return null;
    }
}

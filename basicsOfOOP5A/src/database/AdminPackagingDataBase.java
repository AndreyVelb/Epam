package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdminPackagingDataBase {
    private List<Packaging> adminPackagingDataBase;

    public void createPackagingDataBase(){
        Packaging craftPaper = new Packaging("бумага", "крафтовый", 5, true);
        Packaging whitePaper = new Packaging("бумага", "белая", 3, true);
        Packaging redPaper = new Packaging("бумага", "красная", 6, true);
        Packaging bluePaper = new Packaging("бумага", "синяя", 4, true);

        adminPackagingDataBase =  new ArrayList<>();
        adminPackagingDataBase.add(craftPaper);
        adminPackagingDataBase.add(whitePaper);
        adminPackagingDataBase.add(redPaper);
        adminPackagingDataBase.add(bluePaper);
    }

    public Packaging printForPurchasePackagingDataBase() throws IOException {
        ArrayList<Packaging> availablePackaging = new ArrayList<>();
        for(Packaging packaging : adminPackagingDataBase){
            if(packaging.isAvailable() == true) {
                availablePackaging.add(packaging);
            }
        }

        for (int i = 0; i < availablePackaging.size(); i++){
            System.out.println((i + 1) + " " + availablePackaging.get(i).toString());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите номер строки той упаковки которую бы вы хотели купить");

        int selectedNumber = 0;
        try {
            selectedNumber  = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e){
            System.out.println("Вы ввели не число");
        }

        if (selectedNumber <= 0 || selectedNumber >= availablePackaging.size()){
            System.out.println("Вы ввели неправильное число");
        }
        else return availablePackaging.get(selectedNumber - 1);

        return null;
    }

    public List<Packaging> getAdminPackagingDataBase() {
        return adminPackagingDataBase;
    }

}

package menu;

import dragon.Dragon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String start = new String();

        do {
            System.out.println("Чтобы начать игру нажмите клавишу Enter");
            try {
                start = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (!start.equals(""));

        System.out.println("Введите имя дракона");
        String name = "Дракарис";
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Dragon dragon = new Dragon(name);
        System.out.println(dragon.getName());

        String command = null;
        do {
            System.out.printf("Нажмите 1 чтобы дракон " + dragon.getName() + " смог осмотреть свои сокровища" + "\n" +
                    "Нажмите 2 чтобы дракон " + dragon.getName() + " смог отыскать самое дорогое свое сокровище" + "\n" +
                    "Нажмите 3 чтобы дракон " + dragon.getName() + " смог взять сокровищ на заданную сумму"  + "\n" +
                    "Нажмите 4 чтобы выйти из программы" + "\n");
            try {
                command = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(command.equals("1")){
                dragon.seeTreasures();
                System.out.println("==========================================================================");
            }
            else if(command.equals("2")){
                dragon.seeMostExpensiveTreasure();
                System.out.println("==========================================================================");
            }
            else if(command.equals("3")){
                System.out.println("Введите целое число - оно и будет являться суммой на которую дракон совершит покупки");
                int amout = 0;
                try {
                    String s = reader.readLine();
                    boolean isInteger = true;
                    try {
                        Integer.parseInt(s);
                    }
                    catch (NumberFormatException e){
                        isInteger = false;
                    }
                    catch (NullPointerException e){
                        isInteger = false;
                    }

                    if(isInteger) {
                        amout = Integer.parseInt(s);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                dragon.choiseTreasureForAmount(amout);
                System.out.println("==========================================================================");
            }
        }
        while (!command.equals("4"));
        reader.close();
    }
}

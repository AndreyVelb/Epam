package dragon;


import treasures.CreateTreasures;
import treasures.Treasure;

import java.util.ArrayList;
import java.util.List;

public class Dragon {
    private String name;
    CreateTreasures createTreasures;
    Treasure [] treasures;

    public String getName() {
        return name;
    }

    public Dragon(String name) {
        this.name = name;
        createTreasures = new CreateTreasures();
        treasures = createTreasures.treasuresToGame();
    }

    public void seeTreasures(){
        System.out.println("Так, что там у меня есть из сокровищ...");
        for(Treasure treasure : treasures){
            System.out.println(treasure.toString());
        }
    }

    public void seeMostExpensiveTreasure(){
        System.out.println("Таааак, что там у меня самое дорогое, самое ценное...");
        int biggestPrice = 0;
        Treasure mostExpensive = new Treasure();
        for(Treasure treasure : treasures){
            if(treasure.getCost() > biggestPrice){
                mostExpensive = treasure;
                biggestPrice = treasure.getCost();
            }
        }
        System.out.println(mostExpensive.toString());
    }

    public void choiseTreasureForAmount(int amount){
            System.out.println("Слетаю ка я на ярмарку в деревню, посмортю что там продают. Возьму с собой самых дешевых сокровищ на сумму " + amount);

            int maxAmount = 0;
            int minCost = treasures[0].getCost();

            for (Treasure treasure : treasures){
                maxAmount += treasure.getCost();
                if(treasure.getCost() < minCost){
                    minCost = treasure.getCost();
                }
            }

            if(amount <= 0){
                System.out.println("На такую сумму я точно ничего не куплю!!!");
                return;
            }

            if(amount < minCost){
                System.out.println("Мое самое дешевое сокровище дороже чем сумма для шоппинга...уже лучше съесть продавца и взять что нужно...");
            }

            if (amount > maxAmount){
                System.out.println("Даже моих сокровищ не хватит чтобы посетить ярмарку =((");
                return;
            }
            else if(amount == maxAmount){
                System.out.println("Чтобы получилась эта сумма, мне нужно будет взять с собой все мои сокровища");
                return;
            }
            List<Treasure> choisedTreasures = new ArrayList<>();
            int choisedTreasuresSumCost = 0;

            for(int i = 0; i < treasures.length; i++){
                if(choisedTreasuresSumCost + treasures[i].getCost() < amount){
                    System.out.println(treasures[i].toString());
                    choisedTreasuresSumCost += treasures[i].getCost();
                }
            }
        System.out.println("Итого я взял сокровищ на сумму " + choisedTreasuresSumCost + ", а остальное добавят горожане чтобы я их не съел ");
        }

    }




package treasures;

import dragon.Dragon;

public class CreateTreasures {

    public static Treasure[] treasuresToGame(){
        Treasure [] resultTreasures = new Treasure[100];
        int allCountTreasures = 0;

        int countSimpleTreasures;
        int countDearTreasures;
        int countEliteTreasures;
        int countLegendaryTreasures;
        ManagerBilder managerBilder = new ManagerBilder();

        countSimpleTreasures = (int) (Math.random() * 101);
        countDearTreasures = (int) (Math.random() * (101 - countSimpleTreasures));
        countEliteTreasures = (int) (Math.random() * (101 - (countSimpleTreasures + countDearTreasures)));
        countLegendaryTreasures = (100 - (countSimpleTreasures + countEliteTreasures + countDearTreasures));

        for (int i = 0; i < countSimpleTreasures; i++, allCountTreasures ++) {
            managerBilder.setBuider(new SimpleTreasure());
            Treasure treasure = managerBilder.createOneTreasure();
            resultTreasures[allCountTreasures] = treasure;
        }

        for (int i = 0; i < countDearTreasures; i++, allCountTreasures ++) {
            managerBilder.setBuider(new DearTreasure());
            Treasure treasure = managerBilder.createOneTreasure();
            resultTreasures[allCountTreasures] = treasure;
        }

        for (int i = 0; i < countEliteTreasures; i++, allCountTreasures ++) {
            managerBilder.setBuider(new EliteTreasure());
            Treasure treasure = managerBilder.createOneTreasure();
            resultTreasures[allCountTreasures] = treasure;
        }

        for (int i = 0; i < countLegendaryTreasures; i++, allCountTreasures ++) {
            managerBilder.setBuider(new LegendaryTreasure());
            Treasure treasure = managerBilder.createOneTreasure();
            resultTreasures[allCountTreasures] = treasure;
        }

        return resultTreasures;
    }

}

package treasures;

abstract class TreasureBuilder {  //Builder в названии метода означает что применяется паттерн Builder
    Treasure treasure;

    void createTreasure(){
        treasure = new Treasure();
    }

    protected abstract void buildName();
    protected abstract void buildCost();

    protected int rundomiser(int minValue, int maxValue){
        int result = 0;
        if(minValue == 0) {
            result = (int) (Math.random() * maxValue + 1);
        }
        else if(minValue != 0){
            result = (int) (minValue + Math.random() * (maxValue + 1 - minValue));
        }
        return result;
    }

    public TreasuresNames rundomiserNames(){
        int rundomValue = (int) (Math.random() * TreasuresNames.values().length + 1);
        switch (rundomValue){
            case 0 : return TreasuresNames.MIGHT;
            case 1 : return TreasuresNames.RING;
            case 2 : return TreasuresNames.CROWN;
            case 3 : return TreasuresNames.AXE;
            case 4 : return TreasuresNames.ARMOR;
            case 5 : return TreasuresNames.AMULET;
            case 6: return TreasuresNames.BOOTS;
        }
        return TreasuresNames.MIGHT;
    }

    Treasure getTreasure(){
        return treasure;
    }
}

package treasures;

public class ManagerBilder {
    private TreasureBuilder buider;

    public void setBuider(TreasureBuilder buider) {
        this.buider = buider;
    }

    protected Treasure createOneTreasure(){
        buider.createTreasure();

        buider.buildName();
        buider.buildCost();

        Treasure treasure = buider.getTreasure();
        return treasure;
    }
}

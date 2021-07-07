package treasures;

class SimpleTreasure extends TreasureBuilder{
    private TreasuresNames treasuresNames;

    @Override
    protected void buildName() {
        treasuresNames = rundomiserNames();
        treasure.setName(treasuresNames.toString());
    }

    @Override
    protected void buildCost() {
        treasure.setCost(super.rundomiser(0, 10));
    }
}

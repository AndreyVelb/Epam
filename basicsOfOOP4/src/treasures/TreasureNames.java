package treasures;
enum TreasuresNames {
    MIGHT, RING, CROWN, AXE, ARMOR, AMULET, BOOTS;

    @Override
    public String toString() {
        switch (this){
            case MIGHT : return "Меч";
            case RING: return "Кольцо";
            case CROWN: return "Корона";
            case AXE: return "Топор";
            case ARMOR: return "Доспехи";
            case AMULET: return "Амулет";
            case BOOTS: return "Сапоги";
        }
        return "_____________________________________________________";
    }
}

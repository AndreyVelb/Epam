package catalog;

public enum TypeOfBook {
    PAPER ("бумажная"),
    ELECTRONIC ("электронная");

    private final String type;

    TypeOfBook(String s) {
        this.type = s;
    }

    @Override
    public String toString() {
        return type;
    }

    public boolean equalsType (String otherType){
        return type.equals(otherType);
    }
}

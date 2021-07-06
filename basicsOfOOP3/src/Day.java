public enum Day {
    WEEKDAY, DAYOFF, HOLIDAY;


    @Override
    public String toString() {
        switch (this){
            case DAYOFF : return "выходным";
            case HOLIDAY: return "праздничным";
            case WEEKDAY: return "будним";
        }
        return "_________________________________________";
    }
}

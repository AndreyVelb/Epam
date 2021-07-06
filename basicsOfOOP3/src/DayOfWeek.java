public enum DayOfWeek {
    MON, TUE, WED, THU, FRI, SAT, SUN;

    @Override
    public String toString() {
        switch (this){
            case MON:  return "понедельник";
            case TUE: return "вторник";
            case WED: return "среда";
            case THU: return "четверг";
            case FRI: return "пятница";
            case SAT: return "суббота";
            case SUN: return "воскресенье";
        }
        return "_________________________________________";
    }
}

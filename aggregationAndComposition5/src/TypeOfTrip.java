public enum TypeOfTrip {
    REAST, EXCURSION, TREATMENT, SHOPPING, CRUISE;

    @Override
    public String toString() {
        switch (this){
            case REAST:return " для отдыха ";
            case EXCURSION:return " для походов на экскурсии ";
            case TREATMENT:return " для лечения ";
            case SHOPPING:return " для шоппинга ";
            case CRUISE:return " в круиз ";
        }
        return "aaaaaaaaaaaaaaaaaaaaa";
    }
}

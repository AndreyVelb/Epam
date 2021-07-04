public enum Food {
    ONEMEAL, TWOMEAL, THREEMEAL, WITHOUTFOOD;

    @Override
    public String toString() {
        switch (this){
            case ONEMEAL:return "одноразовым";
            case TWOMEAL:return "двухразовым";
            case THREEMEAL:return "трехразовым";
            case WITHOUTFOOD:return "без питания";
        }
        return "aaaaaaaaaaaaaaaaaaaaa";
    }
}

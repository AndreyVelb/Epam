public enum Transport {
    ByAUTOBUS, ByTRAIN, ByAIRPLANE, BySTEAMER;

    @Override
    public String toString() {
        switch (this){
            case ByAUTOBUS:return "на автобусе ";
            case ByAIRPLANE:return "на самолете ";
            case ByTRAIN:return "на поезде ";
            case BySTEAMER:return "на параходе ";
        }
        return "aaaaaaaaaaaaaaaaaaaaa";
    }
}

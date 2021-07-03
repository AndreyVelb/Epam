public class City {
    private String name;
    private int numberInhabitantsInCity;

    public String getName() {
        return name;
    }

    public int getNumberInhabitantsInCity() {
        return numberInhabitantsInCity;
    }

    public void setNumberInhabitants(int numberInhabitantsInCity) {
        this.numberInhabitantsInCity = numberInhabitantsInCity;
    }

    public City(String name, int numberInhabitantsInCity){
        this.name = name;
        this.numberInhabitantsInCity = numberInhabitantsInCity;
    }


}

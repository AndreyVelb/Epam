public class District {
    private City city;
    private String name;
    private int numberInhabitantsInDistrict;
    private double areaDistrict;

    public double getAreaDistrict() {
        return areaDistrict;
    }

    public City getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getNumberInhabitantsInDistrict() {
        return numberInhabitantsInDistrict;
    }

    public void setNumberInhabitantsInDistrict (int numberInhabitantsInDistrict) {
        this.numberInhabitantsInDistrict = numberInhabitantsInDistrict;
    }

    public District(City city, String name, int numberInhabitantsInDistrict, double areaDistrict){
        this.city = city;
        this.name = name;
        this.numberInhabitantsInDistrict = numberInhabitantsInDistrict;
        this.areaDistrict = areaDistrict;
    }
}

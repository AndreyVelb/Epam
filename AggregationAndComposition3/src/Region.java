import java.util.ArrayList;
import java.util.List;

public class Region {
    private String name;
    private List<District> allDistrictsInRegion = new ArrayList<District>();
    private double areaRegion;
    private int numberInhabitantsInRegion;
    private String regionalCenter;

    public void setNumberInhabitants(int numberInhabitantsInRegion) {
        this.numberInhabitantsInRegion = numberInhabitantsInRegion;
    }

    public String getRegionalCenter() {
        return regionalCenter;
    }

    public String getName() {
        return name;
    }

    public List<District> getDistricts() {
        return allDistrictsInRegion;
    }

    public int getNumberInhabitantsInRegion() {
        return numberInhabitantsInRegion;
    }

    public double getAreaRegion() {
        return areaRegion;
    }

    public Region(String name, String regionalCenter, District ... districts) {
        this.name = name;
        this.regionalCenter = regionalCenter;

        for (int i = 0; i < districts.length; i++){
            allDistrictsInRegion.add(districts[i]);
            this.areaRegion += districts[i].getAreaDistrict();
            this.numberInhabitantsInRegion += districts[i].getNumberInhabitantsInDistrict();
        }
    }
}

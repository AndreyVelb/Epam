import java.util.ArrayList;
import java.util.List;

public class TheState {
    private String name;
    private String capital;
    private List<Region> regionsAsPartOfState = new ArrayList<Region>();
    private int numberInhabitantsInState;
    private double areaState;

    public TheState(String name, String capital, Region... regions) {
        this.name = name;
        this.capital = capital;

        for (int i = 0; i < regions.length; i++){
            regionsAsPartOfState.add(regions[i]);
            areaState += regions[i].getAreaRegion();
            numberInhabitantsInState += regions[i].getNumberInhabitantsInRegion();
        }
        this.regionsAsPartOfState = regionsAsPartOfState;
        this.numberInhabitantsInState = numberInhabitantsInState;
        this.areaState = areaState;
    }

    public void printCapital() {
        System.out.println("Столица " + capital);
    }

    public void printNumberOfRegions(){
        System.out.println("Колличество областей в стране - " + regionsAsPartOfState.size());
    }

    public void printAreaOfState(){
        System.out.println("Общая площадь " + areaState);
    }

    public void printRegionalCenters(){
        System.out.println("В страну " + name + " входят следующие региональные центры: ");
        for (int i = 0; i < regionsAsPartOfState.size(); i++){
            System.out.println("- " + regionsAsPartOfState.get(i).getRegionalCenter());
        }
    }
}

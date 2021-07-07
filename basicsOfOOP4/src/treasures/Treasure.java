package treasures;

public class Treasure {
    private String name;
    private int cost;

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(cost >= 0 && cost <= 10){
            sb.append("Простой предмет ") ;
        }
        else if(cost >= 11 && cost <= 20){
            sb.append("Дорогой предмет ") ;
        }
        else if(cost >= 21 && cost <= 40){
            sb.append("Элитный предмет ") ;
        }
        else if(cost >= 41 && cost <= 65){
            sb.append("Легендарный предмет ") ;
        }

        sb.append(name + ", его стоимость " + cost);
        return sb.toString();
    }
}

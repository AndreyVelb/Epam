public class Ship {
    private final int maxRoominess = 10;
    private final int minRoominess = 0;
    private int quantityCargo;

    public Ship(int quantityCargo) {
        if(quantityCargo >= minRoominess && quantityCargo <= maxRoominess){
            this.quantityCargo = quantityCargo;
        }
    }

    public void addCargo(){
        quantityCargo++;
    }

    public void subtractCargo(){
        quantityCargo--;
    }

    public int getMaxRoominess() {
        return maxRoominess;
    }

    public int getMinRoominess() {
        return minRoominess;
    }

    synchronized public int getQuantityCargo() {
        return quantityCargo;
    }
}

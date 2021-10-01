import java.util.concurrent.Semaphore;

public class Port {
    private final int maxRoominess = 100;
    private final int minRoominess = 0;
    private int currentQuantity = 0;
    private Pier [] pierQuantity;
    private ShipDistributor shipDistributor;

    public Port(ShipDistributor shipDistributor) {
        this.shipDistributor = shipDistributor;
        this.pierQuantity = new Pier[3];
        Pier pier1 = new Pier(this, shipDistributor);
        Pier pier2 = new Pier(this, shipDistributor);
        Pier pier3 = new Pier(this, shipDistributor);
        pierQuantity[0] = pier1;
        pierQuantity[1] = pier2;
        pierQuantity[2] = pier3;

    }

    public void startPort(){
        for (int i = 0; i < pierQuantity.length; i++) {
            pierQuantity[i].start();
        }
    }

    synchronized public void addCargo(){
        currentQuantity++;
        System.out.println(getCurrentQuantity());
    }

    synchronized public void subtractCargo(){
        currentQuantity--;
        System.out.println(getCurrentQuantity());
    }

    public int getMaxRoominess() {
        return maxRoominess;
    }

    public int getMinRoominess() {
        return minRoominess;
    }

    synchronized public int getCurrentQuantity() {
        return currentQuantity;
    }
}

public class Main {
    public static void main(String[] args) {
        ShipDistributor shipDistributor = createShipDistributor();
        Port port = new Port(shipDistributor);
        port.startPort();
    }

    private static ShipDistributor createShipDistributor(){
        Ship ship1 = new Ship(10);
        Ship ship2 = new Ship(0);
        Ship ship3 = new Ship(4);
        Ship ship4 = new Ship(10);
        Ship ship5 = new Ship(1);
        Ship ship6 = new Ship(0);


        ShipDistributor shipDistributor = new ShipDistributor(ship1, ship2, ship3, ship4, ship5, ship6);

        return shipDistributor;
    }
}

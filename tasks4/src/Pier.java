public class Pier extends Thread{
    private Port port;
    private ShipDistributor shipDistributor;

    Pier (Port port, ShipDistributor shipDistributor){
        this.port = port;
        this.shipDistributor = shipDistributor;
    }

    public void run(){
        Ship ship = shipDistributor.distributeShip();
        while ((ship != null)){
            serviceShip(ship);
            ship = shipDistributor.distributeShip();
        }
        if (ship == null){
            interrupt();
        }
    }

    synchronized private void serviceShip(Ship ship){
        if(ship.getQuantityCargo() > 0){
            unloadShip(ship);
        }
        else{
            downloadShip(ship);
        }
    }

    synchronized private void unloadShip(Ship ship){
        while (ship.getQuantityCargo() > ship.getMinRoominess()) {
            if (port.getCurrentQuantity() == port.getMaxRoominess()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(port.getCurrentQuantity() < port.getMaxRoominess()){
                port.addCargo();
                ship.subtractCargo();
                notify();
            }
        }
    }

    synchronized private void downloadShip(Ship ship){
        while (ship.getQuantityCargo() < ship.getMaxRoominess()){
            if (port.getCurrentQuantity() == port.getMinRoominess()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(port.getCurrentQuantity() > port.getMinRoominess()){
                port.subtractCargo();
                ship.addCargo();
                notify();
            }
        }
    }
}

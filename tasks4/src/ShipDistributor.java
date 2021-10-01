import java.util.ArrayList;

public class ShipDistributor{
    private ArrayList<Ship> list = new ArrayList<Ship>();
    public static int count = -1;

    public ShipDistributor(Ship ... ships) {
	  for (Ship s : ships){
		list.add(s);
	  }
	  this.list = list;
    }

    synchronized public Ship distributeShip(){
	  count++;
	  if(count < list.size()) {
		return list.get(count);
	  }
	  else return null;
    }
}

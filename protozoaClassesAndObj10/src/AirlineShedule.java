import java.util.ArrayList;

public class AirlineShedule {
    private ArrayList<Airline> shedule = new ArrayList<>();

    public AirlineShedule(Airline...airline){
        for(int i = 0; i < airline.length; i++) {
            shedule.add(airline[i]);
        }
    }

    public void flightListByDestination(String destination){
        for(int i = 0; i < this.shedule.size(); i++){
            if(shedule.get(i).getDestination().compareTo(destination) == 0){
                System.out.println(shedule.get(i).toString());
            }
        }
        System.out.println("_________________________________________________________________________");
    }

    public void flightListByDayOfWeek(DayOfWeek dayOfWeek){
        for(int i = 0; i < this.shedule.size(); i++){
            DayOfWeek [] array = shedule.get(i).getFlyingDays();
            for(int j = 0; j < array.length; j++){
                if(dayOfWeek == array[j]){
                    System.out.println(shedule.get(i).toString());
                }
            }
        }
        System.out.println("_________________________________________________________________________");
    }

    public void flightListByDayOfWeekAndTime(DayOfWeek dayOfWeek, int time){
        for(int i = 0; i < this.shedule.size(); i++){
            boolean markerByDay = false;
            DayOfWeek [] array = shedule.get(i).getFlyingDays();
            for(int j = 0; j < array.length; j++){
                if(dayOfWeek == array[j]){
                    markerByDay = true;
                }
            }
            if(markerByDay == true && shedule.get(i).getDepartureTime() > time){
                System.out.println(shedule.get(i).toString());
            }
        }
        System.out.println("_________________________________________________________________________");
    }
}

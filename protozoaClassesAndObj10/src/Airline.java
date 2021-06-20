import java.util.Arrays;

public class Airline {
    private String destination;
    private int flightNumber;
    private String AirplaneType;
    private int departureTime;
    private DayOfWeek [] flyingDays = new DayOfWeek[7];

    public Airline(String destination, int flightNumber, String airplaneType, int departureTime, DayOfWeek[] flyingDays) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        AirplaneType = airplaneType;
        this.departureTime = departureTime;
        this.flyingDays = flyingDays;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirplaneType() {
        return AirplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        AirplaneType = airplaneType;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        if(departureTime >=0 && departureTime <= 24) {
            this.departureTime = departureTime;
        }
        else System.out.println("Introduced time is incoreect!");
    }

    public DayOfWeek[] getFlyingDays() {
        return flyingDays;
    }

    public void setFlyingDays(DayOfWeek[] flyingDays) {
        this.flyingDays = flyingDays;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNumber=" + flightNumber +
                ", AirplaneType='" + AirplaneType + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", flyingDays=" + Arrays.toString(flyingDays) +
                '}';
    }
}

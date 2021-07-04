public class Voucher {
    private String place;
    private int numberOfDays;
    private Transport transport;
    private Food food;
    private TypeOfTrip typeOfTrip;

    public Voucher(String place, int numberOfDays, Transport transport, Food food, TypeOfTrip typeOfTrip) {
        this.place = place;
        this.numberOfDays = numberOfDays;
        this.transport = transport;
        this.food = food;
        this.typeOfTrip = typeOfTrip;
    }

    public String getPlace() {
        return place;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Transport getTransport() {
        return transport;
    }

    public Food getFood() {
        return food;
    }

    public TypeOfTrip getTypeOfTrip() {
        return typeOfTrip;
    }

    @Override
    public String toString() {
        return "Путевка в " + place + " на " + numberOfDays + " дней с переездом на" + transport + " c " + food.toString() + " питанием" + typeOfTrip.toString();
    }
}

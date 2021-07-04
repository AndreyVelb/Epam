import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Client {
    private String place;
    private int numberOfDays;
    private Transport transport;
    private Food food;
    private TypeOfTrip typeOfTrip;

    public Client(String place, int numberOfDays, Transport transport, Food food, TypeOfTrip typeOfTrip) {
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

    public void searchVoucherByClient(List<Voucher> vouchers){
        List<Voucher> suitableVouchers = new ArrayList<Voucher>();
        for(Voucher v : vouchers){
            if(v.getPlace() == place ){
                if(v.getNumberOfDays() >= numberOfDays){
                    if(v.getTransport() == transport){
                        if(v.getTypeOfTrip() == typeOfTrip){
                            if(v.getFood() == food){
                                suitableVouchers.add(v);
                            }
                        }
                    }
                }
            }
        }

        if(suitableVouchers.size() > 0){
            for (Voucher v : suitableVouchers){
                System.out.println(v.toString());
            }
        }
        else System.out.println("Потходящая путевка не найдена. Попробуйте изменить параметры поиска");
    }
}

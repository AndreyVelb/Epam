
//5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
//различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
//возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок

import java.util.ArrayList;
import java.util.List;

public class AggregationAndComposition5 {
    public static void main(String[] args) {
        Voucher egypet1 = new Voucher("Египет", 7, Transport.ByAUTOBUS, Food.ONEMEAL, TypeOfTrip.CRUISE);
        Voucher egypet2 = new Voucher("Египет", 15, Transport.ByAUTOBUS, Food.ONEMEAL, TypeOfTrip.CRUISE);
        Voucher egypet3 = new Voucher("Египет", 10, Transport.ByAIRPLANE, Food.ONEMEAL, TypeOfTrip.EXCURSION);
        Voucher egypet4 = new Voucher("Египет", 21, Transport.ByAIRPLANE, Food.THREEMEAL, TypeOfTrip.CRUISE);
        Voucher egypet5 = new Voucher("Египет", 14, Transport.ByTRAIN, Food.WITHOUTFOOD, TypeOfTrip.REAST);
        Voucher malaga1 = new Voucher("Малага", 7, Transport.ByAUTOBUS, Food.TWOMEAL, TypeOfTrip.CRUISE);

        List<Voucher> vouchers = new ArrayList<>();
        vouchers.add(egypet1);
        vouchers.add(egypet2);
        vouchers.add(egypet3);
        vouchers.add(egypet4);
        vouchers.add(egypet5);
        vouchers.add(malaga1);

        Client ivanovIvan = new Client("Египет", 5,Transport.ByAUTOBUS, Food.ONEMEAL, TypeOfTrip.CRUISE);

        ivanovIvan.searchVoucherByClient(vouchers);
    }
}

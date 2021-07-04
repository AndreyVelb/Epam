
//4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
//счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
//всем счетам, имеющим положительный и отрицательный балансы отдельно

public class AggregationAndComposition4 {
    public static void main(String[] args) {
        BankAccount vtb1 = new BankAccount("12341aBn", "VTB-Bank", false,1234.15);
        BankAccount belveb1 = new BankAccount("16411FBn", "BEL-VEB", false,2514.1);
        BankAccount belarusBank1 = new BankAccount("113131ytn", "PRIOR-Bank", false,-104.187);
        BankAccount prior1 = new BankAccount("75341aJJn", "BELARUS-Bank", false,-34.01);

        Client ivanovIvan = new Client("Ivanov", "Ivan", vtb1, belveb1, belarusBank1, prior1);

        ivanovIvan.compareByAmount();
        System.out.println("======================================================");
        ivanovIvan.searchByAccountNumber("12341aBn");
        System.out.println("======================================================");
        System.out.println(ivanovIvan.totalAmount());
        System.out.println("======================================================");
        System.out.println(ivanovIvan.totalAmountByNegativeAccount());
        System.out.println("======================================================");
        System.out.println(ivanovIvan.totalAmountByPositiveAccount());



    }
}

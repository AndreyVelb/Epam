
//Задача 2.
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.

public class BasicsOfOOP2 {
    public static void main(String[] args) {
        Payment payment = new Payment("Магазин Пятерочка");

        payment.setProductDateBase("молоко", 15);
        payment.setProductDateBase("хлеб", 21);
        payment.setProductDateBase("батон", 24);
        payment.setProductDateBase("кефир", 12);
        payment.setProductDateBase("шоколад", 13);

        payment.buyerNeed("молоко", "хлеб", "шоколад", "мороженное");

    }
}

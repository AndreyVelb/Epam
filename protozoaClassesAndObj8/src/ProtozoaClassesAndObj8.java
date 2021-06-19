
//8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
//и методами. Задать критерии выбора данных и вывести эти данные на консоль.
    //Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
    //Найти и вывести:
    //a) список покупателей в алфавитном порядке;
    //b) список покупателей, у которых номер кредитной карточки находится в заданном интервале

import java.util.List;

public class ProtozoaClassesAndObj8 {
    public static void main(String[] args) {
        Customer egor = new Customer(123, "Petrov", "Egor", "Egorovich", "Lidskay st. h.13, q.2", 321314, 1244151);
        Customer andrey = new Customer(223, "Ivanov", "Andrey", "Ivanovich", "Moskovskaya st. h.16, q.1", 329810, 1348152);
        Customer igor = new Customer(323, "Petrov", "Victor", "Alexeevich", "Sovetskaya st. h.83, q.95", 312231, 6784341);

        AgregationCustomers listCustomers = new AgregationCustomers();
        listCustomers.add(egor);
        listCustomers.add(andrey);
        listCustomers.add(igor);

        listCustomers.buyerList();
        System.out.println();
        listCustomers.creditCardNumRange(311313,320000);
    }
}

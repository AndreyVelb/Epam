
//10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//Найти и вывести:
//a) список рейсов для заданного пункта назначения;
//b) список рейсов для заданного дня недели;
//c) список рейсов для заданного дня недели, время вылета для которых больше заданного

public class ProtozoaClassesAndObj10 {
    public static void main(String[] args) {
        Airline an2 = new Airline("Minsk", 123, "Small", 15, new DayOfWeek[]{DayOfWeek.MON, DayOfWeek.FRI});
        Airline il76 = new Airline("Moskva", 243, "Big", 18, new DayOfWeek[]{DayOfWeek.THU, DayOfWeek.WED});
        Airline an8 = new Airline("Grozny", 555, "Big", 12, new DayOfWeek[]{DayOfWeek.MON, DayOfWeek.SAT});

        AirlineShedule shedule = new AirlineShedule(an2, an8, il76);

        shedule.flightListByDestination("Minsk");
        shedule.flightListByDayOfWeek(DayOfWeek.MON);
        shedule.flightListByDayOfWeekAndTime(DayOfWeek.MON, 13);
    }
}

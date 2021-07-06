
//Задача 3.
//Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//выходных и праздничных днях.

public class BasicsOfOOP3 {
    public static void main(String[] args) {
        NewCalendar calendar = new NewCalendar("Июль", 31);

        calendar.setDayInCalendar(1, DayOfWeek.THU, Day.WEEKDAY);
        calendar.setDayInCalendar(2, DayOfWeek.FRI, Day.WEEKDAY);
        calendar.setDayInCalendar(3, DayOfWeek.SAT, Day.HOLIDAY);
        calendar.setDayInCalendar(4, DayOfWeek.SUN, Day.DAYOFF);
        calendar.setDayInCalendar(5, DayOfWeek.MON, Day.WEEKDAY);
        calendar.setDayInCalendar(6, DayOfWeek.TUE, Day.WEEKDAY);
        calendar.setDayInCalendar(7, DayOfWeek.WED, Day.WEEKDAY);
        calendar.setDayInCalendar(8, DayOfWeek.THU, Day.WEEKDAY);
        calendar.setDayInCalendar(9, DayOfWeek.FRI, Day.WEEKDAY);
        calendar.setDayInCalendar(10, DayOfWeek.SAT, Day.DAYOFF);
        calendar.setDayInCalendar(11, DayOfWeek.SUN, Day.DAYOFF);
        calendar.setDayInCalendar(12, DayOfWeek.MON, Day.WEEKDAY);
        calendar.setDayInCalendar(13, DayOfWeek.TUE, Day.WEEKDAY);
        calendar.setDayInCalendar(14, DayOfWeek.WED, Day.WEEKDAY);
        calendar.setDayInCalendar(15, DayOfWeek.THU, Day.WEEKDAY);
        calendar.setDayInCalendar(16, DayOfWeek.FRI, Day.WEEKDAY);
        calendar.setDayInCalendar(17, DayOfWeek.SAT, Day.DAYOFF);
        calendar.setDayInCalendar(18, DayOfWeek.SUN, Day.DAYOFF);
        calendar.setDayInCalendar(19, DayOfWeek.MON, Day.WEEKDAY);
        calendar.setDayInCalendar(20, DayOfWeek.TUE, Day.WEEKDAY);
        calendar.setDayInCalendar(21, DayOfWeek.WED, Day.WEEKDAY);
        calendar.setDayInCalendar(22, DayOfWeek.THU, Day.WEEKDAY);
        calendar.setDayInCalendar(23, DayOfWeek.FRI, Day.WEEKDAY);
        calendar.setDayInCalendar(24, DayOfWeek.SAT, Day.DAYOFF);
        calendar.setDayInCalendar(25, DayOfWeek.SUN, Day.DAYOFF);
        calendar.setDayInCalendar(26, DayOfWeek.MON, Day.WEEKDAY);
        calendar.setDayInCalendar(27, DayOfWeek.TUE, Day.WEEKDAY);
        calendar.setDayInCalendar(28, DayOfWeek.WED, Day.WEEKDAY);
        calendar.setDayInCalendar(29, DayOfWeek.THU, Day.WEEKDAY);
        calendar.setDayInCalendar(30, DayOfWeek.FRI, Day.WEEKDAY);
        calendar.setDayInCalendar(31, DayOfWeek.SAT, Day.DAYOFF);

        calendar.printDay(3);
    }
}

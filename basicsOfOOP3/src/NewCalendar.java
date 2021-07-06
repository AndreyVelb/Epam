import java.util.ArrayList;
import java.util.List;

public class NewCalendar {
    String nameMonth;
    DayInCalendar [] month;

    public NewCalendar(String nameMonth, int daysInMonth){
        if (daysInMonth <= 31 && daysInMonth > 0) {
            this.nameMonth = nameMonth;
            month = new DayInCalendar[daysInMonth];
        }
        else System.out.println("Обратите внимание на вводимое колличетсво дней в месяце");
    }

    public void setDayInCalendar(int numDay, DayOfWeek dayOfWeek, Day day){
        if(isIncludedInTheMonth(numDay)) {
            DayInCalendar thisDay = new DayInCalendar(numDay, dayOfWeek, day);
            month[numDay - 1] = thisDay;
        }
        else System.out.println("Обратите внимание на номер дня который вы ввели");
    }

    public void printDay(int numDay){
        if(isIncludedInTheMonth(numDay)){
            System.out.println("День " + month[numDay - 1].numDay + " месяца " + nameMonth + " " + month[numDay - 1].dayOfWeek + " является " + month[numDay - 1].day);
        }
        else System.out.println("Ну такого дня не существует, постыдились бы уже...");
    }

    private boolean isIncludedInTheMonth(int numDay){
        if(numDay > 0 && numDay <= month.length + 1){
            return true;
        }
        else return false;
    }

    private class DayInCalendar{
        int numDay;
        DayOfWeek dayOfWeek;
        Day day;

        public DayInCalendar() {
            super();
        }

        public DayInCalendar(int numDay, DayOfWeek dayOfWeek, Day day) {
            this.numDay = numDay;
            this.dayOfWeek = dayOfWeek;
            this.day = day;
        }

    }

}

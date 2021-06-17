import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Time {
    private Calendar calendar = new GregorianCalendar();
    private SimpleDateFormat format1 = new SimpleDateFormat("HH.mm.ss");

    public void setTime() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String newDate = new String();

        System.out.println("Введите время в формате 01.02.08, где 01 - 1 час, 02 - 2 минуты, 08 - 8 секунд");
        try{
            newDate = reader.readLine();
            reader.close();

        }
        catch (IOException e ){
            System.out.println("Вы не правильно ввели время. Попробуйте еще раз после перезапуска программы");
            System.exit(0);
        }

        String [] decomposedDate = new String[3];
        try {
            decomposedDate = newDate.split("\\.");

            if(Integer.parseInt(decomposedDate[0]) > 24){
                decomposedDate[0] = "00";
            }
            if(Integer.parseInt(decomposedDate[1]) > 60){
                decomposedDate[1] = "00";
            }
            if(Integer.parseInt(decomposedDate[2]) > 60){
                decomposedDate[2] = "00";
            }

            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(decomposedDate[0]));
            calendar.set(Calendar.MINUTE, Integer.parseInt(decomposedDate[1]));
            calendar.set(Calendar.SECOND, Integer.parseInt(decomposedDate[2]));
        }
        catch (NumberFormatException e){
            System.out.println("Вы не правильно ввели время. Попробуйте еще раз после перезапуска программы");
            System.exit(0);
        }
    }

    public void printTime() {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);

        System.out.println( hour + "." + min + "." + sec);
    }

    public void changeHour(int hour){
        if(hour > 24){
            calendar.set(Calendar.HOUR_OF_DAY, 00);
        }
        else calendar.set(Calendar.HOUR_OF_DAY, hour);
    }

    public void changeMinute(int minute){
        if(minute > 60){
            calendar.set(Calendar.MINUTE, 00);
        }
        else calendar.set(Calendar.MINUTE, minute);
    }

    public void changeSecond(int second){
        if(second > 60){
            calendar.set(Calendar.SECOND, 00);
        }
        else calendar.set(Calendar.SECOND, second);
    }

    public void setPresetTime(){
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 12);
        calendar.set(Calendar.SECOND, 12);
    }
}

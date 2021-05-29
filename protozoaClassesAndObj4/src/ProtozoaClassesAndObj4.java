
//4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
//Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
//номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
//Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
//назначения должны быть упорядочены по времени отправления.

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProtozoaClassesAndObj4 {
    public static void main(String[] args) throws ParseException, IOException {
        Train [] shedule = new Train[5];
        Train train1 = new Train("Минск",1,"2021-05-14 14:51");
        Train train2 = new Train("Гродно",4,"2021-05-14 18:40");
        Train train3 = new Train("Минск",5,"2021-05-14 17:13");
        Train train4 = new Train("Лида",2,"2021-05-14 16:28");
        Train train5 = new Train("Минск",8,"2021-05-15 15:33");

        shedule[0] = train1;
        shedule[1] = train2;
        shedule[2] = train3;
        shedule[3] = train4;
        shedule[4] = train5;

        train1.sortByNumber(shedule);
        printObjArr(shedule);
        System.out.println();

        train1.sortByDestinationName(shedule);
        printObjArr(shedule);
        System.out.println();

        train1.printTrainByNum(shedule);
    }

    public static void printObjArr(Object[] objArr){
        for(int i = 0; i < objArr.length; i++){
            System.out.println(objArr[i].toString());
        }
    }
}


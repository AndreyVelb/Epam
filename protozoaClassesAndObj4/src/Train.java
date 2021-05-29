import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Train {

    String destinationName;
    int trainNumber;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Date departureTime = new Date();

    public Train(){}

    public Train(String destinationName, int trainNumber, String depatureStr) throws ParseException {
        this.destinationName = destinationName;
        this.trainNumber = trainNumber;
        this.departureTime = format.parse(depatureStr);
    }


    @Override
    public String toString() {
        return "Поезд до " + this.destinationName + " номер " + this.trainNumber + " отправляется в " + departureTime;
    }
    public void sortByDestinationName(Train[] shedule){
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < shedule.length - 1; i++) {
                if (shedule[i].destinationName.compareTo(shedule[i + 1].destinationName) > 0)   {
                    Train train;
                    train = shedule[i];
                    shedule[i] = shedule[i + 1];
                    shedule[i + 1] = train;
                    isSorted = false;
                }
                else if(shedule[i].destinationName.compareTo(shedule[i + 1].destinationName) == 0){
                    if(shedule[i].departureTime.compareTo(shedule[i + 1].departureTime) > 0){
                        Train train;
                        train = shedule[i];
                        shedule[i] = shedule[i + 1];
                        shedule[i + 1] = train;
                        isSorted = false;
                    }
                }
            }
        }
    }

    public void sortByNumber(Train[] shedule){
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < shedule.length - 1; i++) {
                if (shedule[i].trainNumber > shedule[i + 1].trainNumber) {
                    Train train;
                    train = shedule[i];
                    shedule[i] = shedule[i + 1];
                    shedule[i + 1] = train;
                    isSorted = false;
                }
            }
        }
    }


    public void printTrainByNum (Train [] shedule) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int introducedNumberOfTrain;
        int numberOfTrainInArr = 0;
        do{
            System.out.println("Введите требуемый номер поезда: ");
            introducedNumberOfTrain = Integer.parseInt(reader.readLine());
        }
        while (introducedNumberOfTrain < 0);

        boolean isFound = false;
        for(int i = 0; i < shedule.length; i++){
            if(shedule[i].trainNumber == introducedNumberOfTrain){
                numberOfTrainInArr = i;
                isFound = true;
                break;
            }
        }
        if(isFound){
            System.out.println(shedule[numberOfTrainInArr].toString());
        }
        else
            System.out.println("Поезда с таким номером не существует");
    }
}

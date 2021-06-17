public class ProtozoaClassesAndObj6 {
    public static void main(String[] args) {
        Time time = new Time();

        time.setTime();
        time.printTime();

        time.changeHour(9);
        time.printTime();

        time.setPresetTime();
        time.printTime();
    }
}


//2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
//менять колесо, вывести на консоль марку автомобиля.

public class AggregationAndComposition2 {
    public static void main(String[] args) {
        Wheel fr = new Wheel("переднее правое");
        Wheel fl = new Wheel("переднее левое");
        Wheel rr = new Wheel("заднее правое");
        Wheel rl = new Wheel("заднее левое");

        Engine bmvEngine = new Engine("BMV 3001");

        Car bmvX6 = new Car(bmvEngine, "BMV X6", fr, fl, rr, rl);

        bmvX6.printCarModel();
        bmvX6.rideOnTheCar();
        bmvX6.refuel(30);
        bmvX6.frontLeft.changeWheel();
    }
}

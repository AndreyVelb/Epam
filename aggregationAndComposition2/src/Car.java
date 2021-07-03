public class Car {
    private String carModel;
    Wheel frontRight;
    Wheel frontLeft;
    Wheel rearRight;
    Wheel rearLeft;
    Engine carEngine;

    public Car(Engine carEngine, String carModel, Wheel frontRight, Wheel frontLeft, Wheel rearRight, Wheel rearLeft){
        this.carEngine = carEngine;
        this.carModel = carModel;
        this.frontRight = frontRight;
        this.frontLeft = frontLeft;
        this.rearRight = rearRight;
        this.rearLeft = rearLeft;
    }

    public void printCarModel(){
        System.out.println(this.carModel);
    }

    public void rideOnTheCar(){
        System.out.println("Заводим двигатель " + carEngine.setModel() + " и едем");
    }

    public void refuel(int liters){
        System.out.println("Автомобиль заправлен " + liters + " литрами топлива");
    }
}

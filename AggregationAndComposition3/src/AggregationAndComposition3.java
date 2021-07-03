
//3. Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
//столицу, количество областей, площадь, областные центры.

public class AggregationAndComposition3 {
    public static void main(String[] args) {
        City lida = new City("Лида", 100000);
        City ive = new City("Ивье", 60000);
        City skidel = new City("Скидель", 70000);

        District lidskiy = new District(lida,"Лидский район", 160000, 100.5);
        District ivevskiy = new District(ive,"Ивьевский район", 100000, 60.8);
        District skidelskiy = new District(skidel,"Скидельский район", 110000, 85.1);

        Region grodnenskaya = new Region("Гродненская область", "Гродно", lidskiy,ivevskiy,skidelskiy);

        TheState belarus = new TheState("Беларусь", "Минск", grodnenskaya);

        belarus.printAreaOfState();
        belarus.printCapital();
        belarus.printNumberOfRegions();
        belarus.printRegionalCenters();

    }
}

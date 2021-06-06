
//5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
//на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
//произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
//позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.

public class ProtozoaClassesAndObjects5 {
    public static void main(String[] args) {
        Counter counter1 = new Counter();
        counter1.increment(12);
        System.out.println(counter1.getCurrent());

        Counter counter2 = new Counter(0,10);
        counter2.decrement(7);
        System.out.println(counter2.getCurrent());

        Counter counter3 = new Counter(1,100,10);
        System.out.println(counter3.getCurrent());
        counter3.increment(10);
        System.out.println(counter3.getCurrent());
    }
}

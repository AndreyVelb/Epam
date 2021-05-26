
//1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
//переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
//наибольшее значение из этих двух переменных.

public class ProtozoaClassesAndObj1 {
    public static void main(String[] args) {
        Text1 text1 = new Text1();
        text1.setA(3);
        text1.setB(6);
        text1.sum(text1.a, text1.b);
        text1.compareValues(text1.a, text1.b);
    }
}
class Text1{
    int a;
    int b;
    protected void printValue(int value){
        System.out.println(value);
    }
    protected void setA(int newValue){
        a = newValue;
    }
    protected void setB(int newValue){
        b = newValue;
    }
    protected void sum(int a, int b){
        int sum = a + b;
        printValue(sum);
    }
    protected void compareValues(int a, int b){
        if(a > b) System.out.println(a + " больше " + b);
        else if(b > a) System.out.println(b + " больше " + a);
        else System.out.println(a + " равно " + b);
    }
}

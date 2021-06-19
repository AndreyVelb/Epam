
//7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
//площади, периметра и точки пересечения медиан.

public class ProtozoaClassesAndObj7 {
    public static void main(String[] args) {
        Triangle tr1 = new Triangle();
        tr1 = tr1.equilateralTriangle(14);
        System.out.println(tr1.areaTriangle(tr1));

        Triangle tr2 = new Triangle();
        tr2 = tr2.allParametrsTriangle(5,6,8,6,4,2);
    }
}

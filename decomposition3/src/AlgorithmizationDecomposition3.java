//. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
//треугольника.

public class AlgorithmizationDecomposition3 {
    public static void main(String[] args) {
        int hexagonSide = 4;
        System.out.println(areaRegularHexagon(hexagonSide));

    }
    public static double areaRegularHexagon(int side){
        double area = 6 * areaRegularTriangle(side);
        return area;
    }
    public static double areaRegularTriangle(int side){
        double area = (pow(side,2) * Math.sqrt(3)) / 4;
        return area;
    }
    public static int pow(int value, int power){
        int result = value;
        for(int i = 1; i < power; i++){
            result *= value;
        }
        return result;
    }
}

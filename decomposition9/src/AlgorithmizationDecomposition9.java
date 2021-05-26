
//9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
//если угол между сторонами длиной X и Y— прямой.

public class AlgorithmizationDecomposition9 {
    public static void main(String[] args) {
        int x = 5;
        int y = 4;
        int z = 6;
        int t = 3;
        int xy = 90;

        System.out.println(quadrangleArea(x, y, z, t, xy));

    }
    public static double quadrangleArea(int x, int y, int z, int t, int xy){
        double angleZT = angleZT(z, t, hypotenuseLength(x,y));
        double angleXY = convertDegreesRad(xy);

        double p = semiPerimeter(x, y, z, t);
        double area = Math.sqrt((p - x) * (p - y) * (p - z) * (p - t) - (x * y * z * t) *
                Math.pow((Math.cos((angleXY + angleZT) / 2)) , 2));
        return area;
    }
    public static double semiPerimeter (int x, int y, int z, int t){
        int p = (x + y + z + t) / 2;
        return p;
    }
    public static double angleZT(int z, int t, double c){
        double angleZT = Math.acos((Math.pow(z, 2) + Math.pow(t, 2) - Math.pow(c, 2)) / (2 * z * t));
        return angleZT;
    }
    public static double hypotenuseLength (int leg1, int leg2){
        double hypotenuse = Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2));
        return hypotenuse;
    }
    public static double convertDegreesRad(int degrees){
        double rad = (degrees * Math.PI) / 180;
        return rad;
    }
}

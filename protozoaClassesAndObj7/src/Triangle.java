import java.util.regex.Matcher;

public class Triangle {
    private float side1;
    private float side2;
    private float side3;

    private float angle12;
    private float angle23;
    private float angle31;

    public Triangle equilateralTriangle(float side){
        Triangle triangle = new Triangle();

        triangle.side1 = side;
        triangle.side2 = side;
        triangle.side3 = side;

        triangle.angle12 = 60;
        triangle.angle23 = 60;
        triangle.angle31 = 60;

        return triangle;
    }

    public Triangle isoscelesTriangle(float side, float bottom, float vertex){
        Triangle triangle = new Triangle();

        if((side1+side2 >= side3) && (side2+side3 >= side1) && (side1+side3 >= side2)) {
            triangle.side1 = side;
            triangle.side2 = side;
            triangle.side3 = bottom;
        }
        else {
            System.out.println("Такой треугольник не может существовать!");
            return null;
        }

        triangle.angle12 = vertex;
        triangle.angle23 = (180 - angle12) / 2;
        triangle.angle31 = angle23;

        return triangle;
    }

    public Triangle rectangularTriangle(float hypotenuse, float catet1, float angle1, float angle2 ){
        Triangle triangle = new Triangle();

        triangle.side1 = catet1;
        triangle.side2 = hypotenuse;
        triangle.side3 = (float) Math.sqrt(Math.abs(hypotenuse) - Math.abs(catet1));

        if(angle12 + angle23 + angle31 == 360) {
            triangle.angle12 = angle1;
            triangle.angle23 = angle2;
            triangle.angle31 = 90;
        }
        else {
            System.out.println("Такой треугольник не может существовать!");
            return null;
        }
        return triangle;
    }

    public Triangle allParametrsTriangle(float side1, float side2, float side3, float angle12, float angle23, float angle31){
        Triangle triangle = new Triangle();
        if((side1+side2 >= side3) && (side2+side3 >= side1) && (side1+side3 >= side2)) {
            triangle.side1 = side1;
            triangle.side2 = side2;
            triangle.side3 = side3;
        }
        else {
            System.out.println("Такой треугольник не может существовать!");
            return null;
        }
        if(angle12 + angle23 + angle31 == 360) {
            triangle.angle12 = angle12;
            triangle.angle23 = angle23;
            triangle.angle31 = angle31;
        }
        else {
            System.out.println("Такой треугольник не может существовать!");
            return null;
        }
        return triangle;
    }

    public double perimeterTriangle(Triangle triangle){
        double perimeter = triangle.side1 + triangle.side2 + triangle.side3;
        return perimeter;
    }

    public double areaTriangle(Triangle triangle){
        double halfPer = perimeterTriangle(triangle) / 2;
        double area = Math.sqrt(halfPer * (halfPer - triangle.side1) * (halfPer - triangle.side2) * (halfPer - triangle.side3));
        return area;
    }
}

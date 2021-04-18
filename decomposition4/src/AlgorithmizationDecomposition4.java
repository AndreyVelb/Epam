
//4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
//из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.

public class AlgorithmizationDecomposition4 {
    public static class Coordinates {
        int x;
        int y;
        public Coordinates(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "["+ x + ", " + y + "]";
        }
    }

    public static void main(String[] args) {
        Coordinates[] coordinates = createCoordArray();
        printCoordinates(maxDistance(coordinates));
    }

    public static void printCoordinates(Coordinates[] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i].toString());
        }
    }

    public static Coordinates[] createCoordArray(){
        int[] arrayX = new int[] {3,-1,5,0,6};
        int[] arrayY = new int[] {4,1,-4,6,1};
        Coordinates[] coordArray = new Coordinates[arrayX.length];
        for(int i=0; i<coordArray.length; i++){
            coordArray[i] = new Coordinates(arrayX[i], arrayY[i]);
        }
        return coordArray;
    }

    public static Coordinates[] maxDistance(Coordinates[] coordinates){
        Coordinates[] greatestDistancePoints = new Coordinates[2];
        double maxDist = 0;
        int maxPoint1 = 0;
        int maxPoint2 = 0;
        for(int i=0; i<coordinates.length; i++){
            for(int j=0; j<coordinates.length; j++) {
                double distance = distanceBetweenPoints(coordinates[i].x, coordinates[i].y, coordinates[j].x, coordinates[j].y);
                if(distance > maxDist){
                    maxDist = distance;
                    maxPoint1 = i;
                    maxPoint2 = j;
                }
            }
        }
        greatestDistancePoints[0] = coordinates[maxPoint1];
        greatestDistancePoints[1] = coordinates[maxPoint2];

        return greatestDistancePoints;
    }

    public static double distanceBetweenPoints(int x1, int y1, int x2, int y2){
        double distance = Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2));
        return distance;
    }
}
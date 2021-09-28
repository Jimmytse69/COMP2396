/**
 * Tester class for Circle class
 * @author Tse Chung Wan, 3035689324
 */

public class CircleTester {
    public static void main(String[] args){
        System.out.println("Start to testing Circle class");
        System.out.println("-------------------------------------------------------------------------------------");

        Circle c = new Circle();
        System.out.println("a new Circle object is created with reference variable c");

        c.setVertices(3.14d);
        int[] cVerticeX = new int[2];
        int[] cVerticeY = new int[2];
        cVerticeX = c.getX();
        cVerticeY = c.getY();
        System.out.println("The \"Vertices\" of this Square bounding Circle is (" + 
                            cVerticeX[0] + ',' + cVerticeY[0] + ") (" +
                            cVerticeX[1] + ',' + cVerticeY[1] + ')' +
                            ", It access both 3 overwritten methods of Circle class.");

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("The end testing Circle class");
    }
}

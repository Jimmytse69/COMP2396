/**
 * Tester class for Triangle class
 * @author Tse Chung Wan, 3035689324
 */

public class TriangleTester {
    public static void main(String[] args){
        System.out.println("Start to testing Triangle class");
        System.out.println("-------------------------------");

        Triangle t = new Triangle();
        System.out.println("a new Triangle object is created with t reference variable");

        t.setVertices(3.14d);
        int[] tVerticeX = t.getX();
        int[] tVerticeY = t.getY();
        System.out.println("It's vertices is set to (" + 
                            tVerticeX[0] + ',' + tVerticeY[0] + ") (" +
                            tVerticeX[1] + ',' + tVerticeY[1] + ") (" +
                            tVerticeX[2] + ',' + tVerticeY[2] + ')' +
                            ", It is the only overwritten class in Triangle class");

        System.out.println("------------------------------");
        System.out.println("The end testing Triangle class");

    }
}

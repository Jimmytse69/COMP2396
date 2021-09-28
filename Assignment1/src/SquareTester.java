/**
 * Tester class for Square class
 * @author Tse Chung Wan, 3035689324
 */

public class SquareTester {
    public static void main(String[] args){
        System.out.println("Start to testing Square class");
        System.out.println("------------------------------------------------------------------------------------");

        Square sq = new Square();
        System.out.println("a new Square object is created with reference variable sq");

        sq.setVertices(3.14d);
        int[] sideHalfLengths = sq.getX();
        System.out.println("The Vertice is set to " + sideHalfLengths[0] + " each side away from origin for both x,y coordinate, it's only overwriteen method in square class");
        
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("The end testing Square class");

    }
}

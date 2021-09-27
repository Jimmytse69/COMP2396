/**
 * Tester class for Square class
 * @author Tse Chung Wan, 3035689324
 */

public class SquareTester {
    public static void main(String[] args){
        System.out.println("Start to testing Square class");
        System.out.println("-----------------------------");

        Square sq = new Square();
        System.out.println("a new Square object is created and sq is it's reference variable");

        sq.setVertices(3.14d);
        int[] sideLengths = sq.getX();
        System.out.println("The Vertice is set to " + sideLengths[0] + " each side of the square, it's only overwriteen parameters in square class");
        
        System.out.println("----------------------------");
        System.out.println("The end testing Square class");

    }
}

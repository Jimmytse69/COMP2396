import java.awt.Color;

/**
 * Test Shape.java (access all instance variables and methods) for test and debug.
 * @author Tse Chung Wan, 3035689324
 */

public class ShapeTester {
    public static void main(String[] args){
        System.out.println("Start to testing Shape class");
        System.out.println("------------------------------------------------------------------------------------");

        Shape s = new Shape();
        System.out.println("a new shape object is created with reference variable s");

        s.color = new Color(0, 0, 0);
        System.out.println("It's color instance variable is refered to Color object with Black parameters");

        s.filled = true;
        System.out.println("It's filled = " + s.filled);

        s.theta = 0;
        System.out.println("It's theta = " + s.theta + "radian");

        s.xc = 0; s.yc = 0;
        System.out.println("It's center set to (" + s.xc + ',' + s.yc + ')');

        s.setSize((int) ((Math.random() * 4) + 3));      //generate a random "polygon" with i = 3-6 vertices
        System.out.println("It has " + s.xLocal.length + " num. of xLocal, " + s.yLocal.length + " num. of yLocal");

        for (int i = 0; i < s.xLocal.length; i++){
            s.xLocal[i] = 3.14d; s.yLocal[i] = -3.14d;
            System.out.println("vertex" + (i+1) +" : x = " + s.xLocal[i] + ", y = " + s.yLocal[i]);
        }
        
        System.out.println("----------------------------------------------------------");
        System.out.println("End of Debugged Instances variable, Start to Debug Methods");
        System.out.println("----------------------------------------------------------");

        s.setVertices(3.14d);   //dummy

        s.translate(2.7181d, 2.7181d);
        System.out.println("the new center: (xc,yc) = (" + s.xc + ',' + s.yc + ')' );

        s.rotate(1);
        System.out.println("the new theta = " + s.theta);

        int[] screenCoorX = new int[s.xLocal.length];
        int[] screenCoorY = new int[s.yLocal.length];
        screenCoorX = s.getX();
        screenCoorY = s.getY();
        System.out.println("This is Screen Coordinate");
        for (int i = 0; i < s.xLocal.length; ++i){
            System.out.println("vertex" + (i+1) +" : x = " + screenCoorX[i] + ", y = " + screenCoorY[i]);
        }
        
        
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("The End of testing of Shape class");

            
    }
}

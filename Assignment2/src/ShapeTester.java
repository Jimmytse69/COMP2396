import java.awt.Color;
/**
 * This is Tester class for Shape class
 * @author Tse Chung Wan, 3035689324
 */

public class ShapeTester{
    public static void main(String[] args){
        System.out.println("Start to Test Shape Class:");
        System.out.println("-----------------------------------------------");
        Shape s = new Shape();
        System.out.println("a new shape is created with s be the ref variable");

        s.setColor(new Color(0,0,0));
        System.out.println("Color set to "+s.getColor());

        s.setFilled(true);
        System.out.println("s is filled = "+s.getFilled());

        s.setTheta(3.14);
        System.out.println("Theta of s = "+s.getTheta());

        s.setXc(2.71);
        s.setYc(-2.71);
        System.out.println("Center of s = "+s.getXc()+','+s.getYc());

        double[] xLocal = {1.2, 3.4, 5.6, 7.8};
        double[] yLocal = {8.7, 6.5, 4.3, 2.1};
        s.setXLocal(xLocal);
        s.setYLocal(yLocal);
        System.out.println("vertices of the shape are defined");
        System.out.println("shape's vertices in local coordinate system are: ");
        for(int i = 0; i < s.getXLocal().length; i++)
        System.out.println("vertex" + (i+1) +" : x = " + s.getXLocal()[i] + ", y = " + s.getYLocal()[i]);

        s.translate(-2.71, 2.71);
        System.out.println("the new Center = "+s.getXc()+','+s.getYc()+" translated by dx = -2.71 and dy = 2.71");

        s.rotate(3.14);
        System.out.println("s is rotated, new theta = "+s.getTheta());

        System.out.println("screen coordinate vertices of the shape are defined");
        System.out.println("shape's screen coordinate vertices in local coordinate system are: ");
        for(int i = 0; i < s.getX().length; i++)
        System.out.println("vertex" + (i+1) +" : x = " + s.getX()[i] + ", y = " + s.getY()[i]);

        System.out.println("End of Testing");


    }
}
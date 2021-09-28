import java.awt.Color;

/**
 * The Shape Class is used to model general shapes. The detailed instance variable and methods see below.
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * 
 */


public class Shape {

    /**
     * Color object from java.awt.Color libary. specified by RGB value, e.g. Color(0, 255, 0).
     * {@see https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html}
     */
    public Color color;

    /**Boolean value specifying the shape is filled or not. */
    public boolean filled;

    /**double value specifying the orientation (radian) of the shape in screen coordinate system. */
    public double theta;

    /**double value specifying the x-coordinate of the center of the shpae in screen coordinate system. */
    public double xc;

    /**double value specifying the y-coordinate of the center of the shape in screen coordinate system. */
    public double yc;

    /**array of double values specifying the x-coordinate of the vertices (in counter-clockwise order) of the shape in local coordinate system. */
    public double[] xLocal;

    /**array of double value specifying the y-coordinate of the vertices (in counter-clockwise order) of the shape in local coordinate system. */
    public double[] yLocal;
    


    /**
     * a method for setting the local coordinates of the vertices of a shape. dummy to be overridden by its subclasses.
     * @param {double} d - dummy parameter to be overridden, double
     */
    public void setVertices(double d){ 
        System.out.println("I am the debuggine msg for dummy method");
    }     

    /**
     * a method for translating the center of the shape by dx and dy, respectively.
     * @param dx - how many x-coordinate to translate, double
     * @param dy - how many y-coordinate to translate, double
     */
    public void translate(double dx, double dy){
        this.xc += dx;  //"this" referring to current object
        this.yc += dy;
    }

    /**
     * a method for rotating the shape about its center by angle dt (radian).
     * @param dt - how many theta to rotate, double
     */
    public void rotate(double dt){
        this.theta += dt;
    }

    /**
     * a method for retrieving the x-coordinates of the vertices (in counter-clockwise order).
     * @return screen coordinate of X vertices of the shape rounded to nearest intergers.
     */
    public int[] getX(){
        int[] xr = new int[xLocal.length];
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        for (int i = 0; i < xLocal.length; i++){
            xr[i] = (int) Math.round(xLocal[i] * cosTheta - yLocal[i] * sinTheta + xc);
        }
        return xr;
    }

    /**
     * a method for retrieving the y-coordinates of the vertices (in counter-clockwise order).
     * @return screen coordinate of Y vertices of the shape rounded to nearest intergers.
     */
    public int[] getY(){
        int[] yr = new int[yLocal.length];
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        for (int i = 0; i < yLocal.length; i++){
            yr[i] = (int) Math.round(xLocal[i] * sinTheta + yLocal[i] * cosTheta + yc);
        }
        return yr;
    }



    //for tester and debug only
    public void setSize(int i){     //i = no. of local vertices
        this.xLocal = new double[i];
        this.yLocal = new double[i];
    }
}


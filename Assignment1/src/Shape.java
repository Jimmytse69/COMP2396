import java.awt.Color;

/**
 * This is the Shape Class
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 * 
 */


public class Shape {
    public Color color;
    public boolean filled;
    public double theta;
    public double xc;
    public double yc;
    public double[] xLocal;
    public double[] yLocal;
    

    public void setVertices(double d){  //dummy to be overridden by its subclasses
        System.out.println("I am the debuggine msg for dummy method");
    }     

    public void translate(double dx, double dy){
        this.xc += dx;  //"this" referring to current object
        this.yc += dy;
    }
    public void rotate(double dt){
        this.theta += dt;
    }
    public int[] getX(){
        int[] xr = new int[xLocal.length];
        double cosTheta = Math.cos(theta);
        double sinTheta = Math.sin(theta);
        for (int i = 0; i < xLocal.length; i++){
            xr[i] = (int) Math.round(xLocal[i] * cosTheta - yLocal[i] * sinTheta + xc);
        }
        return xr;
    }
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


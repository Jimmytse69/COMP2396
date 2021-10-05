import java.awt.Color;

/**
 * This Shape class is used to model general shape objects, the detail instance variable and methods are shown below.
 * @author Tse Chung Wan 3035689324
 * @version 1.0
 */

public class Shape {
    private Color color;
    private boolean filled;
    private double theta;   //radian, Screen Coordinate system(SCS)
    private double xc;  //SCS
    private double yc;  //SCS
    private double[] xLocal;
    private double[] yLocal;

    public Color getColor(){
        return this.color;
    }
    public boolean getFilled(){
        return this.filled;
    }
    public double getTheta(){
        return this.theta;
    }
    public double getXc(){
        return this.xc;
    }
    public double getYc(){
        return this.yc;
    }
    public double[] getXLocal(){
        return this.xLocal;
    }
    public double[] getYLocal(){
        return this.yLocal;
    }

    public void setColor(Color color){
        this.color = color;
    }
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    public void setTheta(double theta){
        this.theta = theta;
    }
    public void setXc(double xc){
        this.xc = xc;
    }
    public void setYc(double yc){
        this.yc = yc;
    }
    public void setXLocal(double[] xLocal){
        this.xLocal = xLocal;
    }
    public void setYLocal(double[] yLocal){
        this.yLocal = yLocal;
    }
    public void translate(double dx, double dy){
        xc += dx;
        yc += dy;
    }
    public void rotate(double dt){
        theta += dt;
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

}

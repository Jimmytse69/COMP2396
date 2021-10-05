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

    public int[] getX(){
        double[] screenXLocal = new double[xLocal.length];
        int[] roundedScreenXLocal = new int[xLocal.length];
        for (int i = 0; i < xLocal.length; i++){
            screenXLocal[i] = xLocal[i]*Math.cos(theta) - yLocal[i]*Math.sin(theta) + xc;
        } 
        for (int i = 0; i < xLocal.length; i++){
            roundedScreenXLocal[i] = (int) Math.round(screenXLocal[i]);
        }
        return roundedScreenXLocal;
    }
    public int[] getY(){
        double[] screenYLocal = new double[yLocal.length];
        int[] roundedScreenYLocal = new int[yLocal.length];
        for (int i = 0; i < yLocal.length; i++){
            screenYLocal[i] = xLocal[i]*Math.sin(theta) + yLocal[i]*Math.cos(theta) + yc;
        } 
        for (int i = 0; i < yLocal.length; i++){
            roundedScreenYLocal[i] = (int) Math.round(screenYLocal[i]);
        }
        return roundedScreenYLocal;

    }

}

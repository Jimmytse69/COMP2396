import java.awt.Color;

/**
 * This Shape class is used to model general shape objects, the detail instance variable and methods are shown below.
 * @author Tse Chung Wan 3035689324
 * @version 1.0
 */

public class Shape {
    private Color color;
    private boolean filled;
    private double theta;
    private double xc;
    private double yc;
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
        return xLocal;
    }
    public double[] getYlocal(){
        return yLocal;
    }

    public void setColor(Color color){

    }
    public void setFilled(boolean filled){

    }
    public void setTheta(double theta){

    }
    public void setXc(double xc){

    }
    public void setYc(double yc){

    }
    public void setXLocal(double[] xLocal){

    }
    public void setYLocal(double[] yLocal){

    }
    public void translate(double dx, double dy){

    }
    public void rotate(double dt){

    }
    public int[] getX(){
        int[] dummy = new int[3];
        return dummy;
    }
    public int[] getY(){
        int[] dummy = new int[3];
        return dummy;
    }

}

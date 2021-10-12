import java.awt.Color;

/**
 * This Shape class is used to model general shape objects, the detail instance variable and methods are shown below.
 * @author Tse Chung Wan 3035689324
 * @version 1.0
 */

public class Shape {
    /** a Color object specifying the color of the shape. */
    private Color color;

    /** a boolean value specifying whether the shape is filled or not filled. */
    private boolean filled;

    /** a double value specifying the orientation (in radians) of the shape in the 
screen coordinate system */
    private double theta;

    /** a double value specifying the x-coordinate of the center of the shape in the 
screen coordinate system. */
    private double xc;  

    /** a double value specifying the y-coordinate of the center of the shape in the 
screen coordinate system. */
    private double yc; 

    /** an  array  of  double  values  specifying  the  x-coordinates  of  the 
vertices (in counter-clockwise order) of the shape in its local coordinate system.  */
    private double[] xLocal;

    /** an  array  of  double  values  specifying  the  y-coordinates  of  the 
vertices (in counter-clockwise order) of the shape in its local coordinate system.  */
    private double[] yLocal;

    /** getter method of retriving instance variable of Color in that object 
     * @return {Color} color of that obj.
    */
    public Color getColor(){
        return this.color;
    }

    /** getter method of retriving instance variable of filled in that object 
     * @return {Boolean} filled of that obj.
    */
    public boolean getFilled(){
        return this.filled;
    }

    /** getter method of retriving instance variable of theta in that object 
     * @return {double} theta of that obj.
    */
    public double getTheta(){
        return this.theta;
    }

    /** getter method of retriving instance variable of xc in that object 
     * @return {double} X coordinate of center of that obj.
    */
    public double getXc(){
        return this.xc;
    }

    /** getter method of retriving instance variable of yc in that object 
     * @return {double} Y coordinate of center of that obj.
    */
    public double getYc(){
        return this.yc;
    }

    /** getter method of retriving instance variable of XLocal double array in that object 
     * @return {double[]} X coordinates of Vertices of that obj in Local coor. sys..
    */
    public double[] getXLocal(){
        return this.xLocal;
    }

    /** getter method of retriving instance variable of YLocal double array in that object 
     * @return {double[]} Y coordinates of Vertices of that obj in Local coor. sys..
    */    
    public double[] getYLocal(){
        return this.yLocal;
    }


    /** setter method of set color attribute in that object 
     * @param color (Color type) represented in RGB value, ref: https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html
    */       
    public void setColor(Color color){
        this.color = color;
    }

    /** setter method of set filled attribute in that object 
     * @param filled (boolean type)
    */     
    public void setFilled(boolean filled){
        this.filled = filled;
    }

    /** setter method of set theta attribute in that object 
     * @param theta (double type), it is in radian from positive x-axis of Screen coordinate
    */
    public void setTheta(double theta){
        this.theta = theta;
    }

    /** setter method of set x center attribute in that object 
     * @param xc (double type)
    */
    public void setXc(double xc){
        this.xc = xc;
    }

    /** setter method of set y center attribute in that object 
     * @param yc (double type)
    */
    public void setYc(double yc){
        this.yc = yc;
    }

    /** setter method of set x Vertices attribute in that object 
     * @param xLocal (double[] type), it is in Local coordinate system in terms of counter-clockwise order
    */
    public void setXLocal(double[] xLocal){
        this.xLocal = xLocal;
    }

    /** setter method of set y Vertices attribute in that object 
     * @param yLocal (double[] type), it is in Local coordinate system in terms of counter-clockwise order
    */
    public void setYLocal(double[] yLocal){
        this.yLocal = yLocal;
    }

    /** a method to translate center coordinate by +dy and +dy.
     * @param dx (double type) amount of x to translate
     * @param dy (double type) amount of y to translate
    */
    public void translate(double dx, double dy){
        xc += dx;
        yc += dy;
    }

    /** a method to rotate the shape by dt in radian.
     * @param dt (double type), rotation angle
    */
    public void rotate(double dt){
        theta += dt;
    }

    /**
     * a method for retrieving the x-coordinates of the vertices (in counter-clockwise order).
     * @return screen coordinate of X vertices of the shape rounded to nearest intergers.
     */
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

    /**
     * a method for retrieving the y-coordinates of the vertices (in counter-clockwise order).
     * @return screen coordinate of Y vertices of the shape rounded to nearest intergers.
     */
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

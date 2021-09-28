/**
 * The Square class is used to model squares. It is a sub-class of Shape class inherits all instance variable and methods.
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 */


public class Square extends Shape{      //extends is the keyword of inheritance from super class
    /**
     * setter of local coordinates of a sqaure object with each length 2d. It is the only overwritten method in Square class
     * @param d - side half length of the square object, double
     */
    public void setVertices(double d){
        double[] x = {d, d, -d, -d};
        double[] y = {d, -d, -d, d};
        xLocal = x;
        yLocal = y;
    }   
}

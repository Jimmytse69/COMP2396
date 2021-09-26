/**
 * Square class
 * @author Tse Chung Wan, 3035689324
 */

//extends is the keyword of inheritance from super class
public class Square extends Shape{  
    //overwrite the method in Shape class
    public void setVertices(double d){
        double[] x = {d, d, -d, -d};
        double[] y = {d, -d, -d, d};
        xLocal = x;
        yLocal = y;
    }   
}

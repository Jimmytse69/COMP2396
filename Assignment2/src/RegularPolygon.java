import java.awt.Color;
/**
 * This the RegularPolygon class to model Regular Polygon shapes under the inheritance of all shapes instance variable and methods
 * there are extra methods/variable need to be overwritten stated as follow. It have 3 Constructors to create this object from class:
 * (), (int n), (int n, double r)
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 */

public class RegularPolygon extends Shape{
    public RegularPolygon(){};
    public RegularPolygon(int n){};
    public RegularPolygon(int n, double r){};

    private int numOfSides;
    private double radius;

    public int getNumOfSides(){
        return numOfSides;
    }
    public double getRadius(){
        return radius;
    }
    public void setNumOfSides(int n){

    }
    public void setRadius(double r){

    }
    public void setVertices(){

    }
    public boolean contains(double x, double y){
        return false;
    }

}

/**
 * This the RegularPolygon class to model Regular Polygon shapes under the inheritance of all shapes instance variable and methods
 * there are extra methods/variable need to be overwritten stated as follow. It have 3 Constructors to create this object from class:
 * (), (int n), (int n, double r)
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 */

public class RegularPolygon extends Shape{
    public RegularPolygon(){};
    public RegularPolygon(int n){
        this.numOfSides = n;
    };
    public RegularPolygon(int n, double r){
        this.numOfSides = n;
        this.radius = r;
    };

    private int numOfSides;
    private double radius;

    public int getNumOfSides(){
        return this.numOfSides;
    }
    public double getRadius(){
        return this.radius;
    }
    public void setNumOfSides(int n){
        if (n <= 3){
            this.numOfSides = 3;
        }
        else{
            this.numOfSides = n;
        }
        double[] ResetXLocal = new double[this.getXLocal().length];     //Reset Xlocal
        for (int i = 0; i < ResetXLocal.length; i++){
            ResetXLocal[i] = 0;
        }
        double[] ResetYLocal = new double[this.getYLocal().length];     //Reset Ylocal
        for (int i = 0; i < ResetYLocal.length; i++){
            ResetYLocal[i] = 0;
        }

    }
    public void setRadius(double r){
        if (r <= 0){
            this.radius = 0;
        }
        else{
            this.radius = r;
        }        
        double[] ResetXLocal = new double[this.getXLocal().length];     //Reset Xlocal
        for (int i = 0; i < ResetXLocal.length; i++){
            ResetXLocal[i] = 0;
        }
        double[] ResetYLocal = new double[this.getYLocal().length];     //Reset Ylocal
        for (int i = 0; i < ResetYLocal.length; i++){
            ResetYLocal[i] = 0;
        }
    }
    public void setVertices(){
        final double theta = 2*(Math.PI)/numOfSides;
        final double alphaOdd = 0;
        final double alphaEven = Math.PI/numOfSides;

        if (this.numOfSides % 2 == 1){      //odd sides case
            for (int i = 0; i < numOfSides; i++){
                this.getXLocal()[i] = this.getRadius()*(Math.cos(alphaOdd - i*theta));
                this.getYLocal()[i] = this.getRadius()*(Math.sin(alphaOdd - i*theta));
            }
        }
        else{
            for (int i = 0; i < numOfSides; i++){
                this.getXLocal()[i] = this.getRadius()*(Math.cos(alphaEven - i*theta));
                this.getYLocal()[i] = this.getRadius()*(Math.sin(alphaEven - i*theta));
            }
        }
    }
    //target find min(leftest) x coordinate of vertices, than use the method in appendix
    public boolean contains(double x, double y){
        double[] xL = this.getXLocal();
        double minX = xL[0];
        for (int i = 0; i < xL.length; i++){
            if (xL[i] < minX){
                minX = xL[i];
            }
        }
        for (int i = 0; i < (xL.length - 1); i++){
            if (x < minX){
                return false;   //if it is even lefter than leftest x Vertices, it must outside
            }
            else{
                x = x*Math.cos(2*Math.PI/numOfSides) - y*Math.sin(2*Math.PI/numOfSides);    //rotate the point
            }
        }
        return true;
    }
    
}

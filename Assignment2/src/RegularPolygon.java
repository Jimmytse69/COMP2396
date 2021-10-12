/**
 * This RegularPolygon class is used to model general RegularPolygon objects, the detail instance variable and methods are shown below.
 * @author Tse Chung Wan, 3035689324
 * @version 1.2: fixed the problem of method contain(): contain is true even sometimes mouse right click is outside the shape. 
 * This bug is caused by rotate pointXLocal overwritten each, so it is not actually rotating from 1 - n.
 * fixed by final double fixedPointXLocal and final double fixedPointYLocal to avoid it happen.
 */

class RegularPolygon extends Shape{
    public RegularPolygon(int n, double r){
        setNumOfSides(n);
        setRadius(r);
    }
    public RegularPolygon(int n){
        setNumOfSides(n);
        setRadius(1.0);
    }
    public RegularPolygon(){
        setNumOfSides(3);
        setRadius(1.0);
    }

    private int numOfSides;
    private double radius;

    public int getNumOfSides(){
        return this.numOfSides;
    }
    public double getRadius(){
        return this.radius;
    }


    public void setNumOfSides(int n){
        this.numOfSides = n < 3 ? 3 : n;    //one liner if-else
        setVertices();      //reset Vertices()
    }

    public void setRadius(double r){
        this.radius = r < 0 ? 0 : r;    //one liner if-else
        setVertices();      //reset Vertices()
    }

    private void setVertices(){     //should be private bacuse normally won't "reset" Vertices, but reset by constructor or other setter in this class etc.
        final double theta = 2*(Math.PI)/this.numOfSides;
        final double alphaOdd = 0;
        final double alphaEven = Math.PI/this.numOfSides;
        double xVer[] = new double[this.numOfSides];
        double yVer[] = new double[this.numOfSides];

        if (this.numOfSides % 2 == 1){      //odd sides case
            for (int i = 0; i < numOfSides; i++){
                xVer[i] = this.getRadius()*(Math.cos(alphaOdd - i*theta));
                yVer[i] = this.getRadius()*(Math.sin(alphaOdd - i*theta));
            }
        }
        else{
            for (int i = 0; i < numOfSides; i++){
                xVer[i] = this.getRadius()*(Math.cos(alphaEven - i*theta));
                yVer[i] = this.getRadius()*(Math.sin(alphaEven - i*theta));
            }
        }

        this.setXLocal(xVer);
        this.setYLocal(yVer);
    }


    //target find min(leftest) x coordinate of vertices, than use the method in appendix
    public boolean contains(double x, double y){
        final double theta = 2*(Math.PI)/this.numOfSides;
        double pointXLocal = (x - this.getXc())*(Math.cos(-this.getTheta())) - (y - this.getYc())*(Math.sin(-this.getTheta()));
        double pointYLocal = (x - this.getXc())*(Math.sin(-this.getTheta())) + (y - this.getYc())*(Math.cos(-this.getTheta()));
        double[] XLoc = this.getXLocal();
        double minX = 0;

        final double fixedPointXLocal = pointXLocal;
        final double fixedPointYLocal = pointYLocal;

        for (int i = 0; i < this.getNumOfSides(); ++i){ //find minX (lefest point of Xlocal of shape)
            if (XLoc[i] < minX){
                minX = XLoc[i];
            }
        }

        for (int i = 1; i < this.getNumOfSides(); ++i){     //i = 1: begin with rotate one time after checking
            if (pointXLocal < minX){
                return false;   //not contain if the point is even lefter than minX
            }
            //Ref: https://danceswithcode.net/engineeringnotes/rotations_in_2d/rotations_in_2d.html, rotate a point in 2D by theta = 2pi/n
            pointXLocal = fixedPointXLocal*Math.cos(theta*i) - fixedPointYLocal*Math.sin(theta*i);
        }
        return true;    //if both n-1 rotate didn't make it lie outside, it's inside
    }

}
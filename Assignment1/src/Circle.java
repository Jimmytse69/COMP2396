/**
 * The Circle class is used to model circles, it is a subclass of the Shape class that inherits all instances variables and methods.
 * @author Tse Chung Wan, 3035689324
 * @version 1.0
 */

public class Circle extends Shape {
    /**
     * setter for setting the local coordinates of the upper left and lower right vertices of the axis-aligned bounding box of the circle.
     * @param d - radius of the circle
     */
    public void setVertices(double d){
        double x[] = {-d, d};
        double y[] = {-d, d};
        xLocal = x;
        yLocal = y;
    }

    /**
     * getter to get the x-coordinates of bounding box vertices of circle.
     * @return x-coordinates of the upper left and lower right vertice of the bounding box in screen coordinate system rounded to nearest integers
     */
    public int[] getX(){
        int xr[] = new int[xLocal.length];
        for (int i = 0; i < xLocal.length; i++){
            xr[i] = 0;
            xr[i] += (int) (xLocal[i] + xc);
        }
        return xr;
    }

    /**
     * getter to get the y-coordinates of bounding box vertices of circles.
     * @return y-coordinates of the upper left and lower right vertice of the bounding box in screen coordinate system rounded to nearest integers.
     */
    public int[] getY(){
        int yr[] = new int[yLocal.length];
        for (int i = 0; i < yLocal.length; i++){
            yr[i] = 0;
            yr[i] += (int) (yLocal[i] + yc);
        }
        return yr;
    }
}


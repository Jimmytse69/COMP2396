/**
 * Circle class
 * @author Tse Chung Wan, 3035689324
 */

public class Circle extends Shape {
    public void setVertices(double d){
        double x[] = {-d, d};
        double y[] = {-d, d};
        xLocal = x;
        yLocal = y;

    }
    public int[] getX(){
        int xr[] = new int[xLocal.length];
        for (int i = 0; i < xLocal.length; i++){
            xr[i] = 0;
            xr[i] += (int) (xLocal[i] + xc);
        }
        return xr;
    }
    public int[] getY(){
        int yr[] = new int[yLocal.length];
        for (int i = 0; i < yLocal.length; i++){
            yr[i] = 0;
            yr[i] += (int) (yLocal[i] + yc);
        }
        return yr;
    }
}


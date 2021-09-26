/**
 * Triangle class
 * @author Tes Chung Wan, 3035689324
 */

public class Triangle extends Shape {
    public void setVertices(double d){
        double t = Math.toRadians(60);
        double cost = Math.cos(t);
        double sint = Math.sin(t);

        double[] x = {d, -d*cost, -d*cost };
        double[] y = {0, -d*sint,  d*sint };
        xLocal = x;
        yLocal = y;

    }
}

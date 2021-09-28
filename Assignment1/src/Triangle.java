/**
 * The Triangle class is used to model triangles, it is a subclass of the Shape class that inherits all the instance variables and methods.
 * @author Tes Chung Wan, 3035689324
 * @version 1.0
 */

public class Triangle extends Shape {
    /**
     * setter of the 3 vertices of triangle, it is the only overwritten method.
     * @param d - distance from the center of the triangle to any of its vertices, double
     */
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

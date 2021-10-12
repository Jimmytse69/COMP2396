/**
 * This is the Tester class for RegularPolygon class.
 * @author Tse Chung Wan, 3035689324
 */

public class RegularPolygonTester {
    public static void main(String[] args){
        System.out.println("Start to Test RegularPolygon Class:");
        System.out.println("-----------------------------------------------");
        
        RegularPolygon p_n_r = new RegularPolygon(6, 3.3);
        RegularPolygon p_n = new RegularPolygon(5);
        RegularPolygon p = new RegularPolygon();

        int p_n_rSides = p_n_r.getNumOfSides();
        double p_n_rRad = p_n_r.getRadius();
        int p_nSides = p_n.getNumOfSides();
        double p_nRad = p_n.getRadius();
        int pSides = p.getNumOfSides();
        double pRad = p.getRadius();

        System.out.println("3 Regular Polygon is created (by 3 diff Constructors) with Reference variable named as p_n_r, p_n, p");
        System.out.println("It's numOfSizes and radius instances variables are all accessed by public getter, with value:");
        System.out.println("numOfSizes: " + p_n_rSides + ',' + p_nSides + ',' + pSides + 
                           " and Radius: " + p_n_rRad + ',' + p_nRad + ',' + pRad);

        p.setNumOfSides(4);
        p.setRadius(3.14159);
        System.out.println("p's numOfSides and radius is Reset by the Setter to: " + p.getNumOfSides() + " and " + p.getRadius());


        double pXVertices[] = p.getXLocal();
        double pYVertices[] = p.getYLocal();
        System.out.println("circle's vertices in local coordinate system are: ");
        for(int i = 0; i < pXVertices.length; i++){
            System.out.println("vertex" + (i+1) +" : x = " + pXVertices[i] + ", y = " + pYVertices[i]);
        }


        boolean p_3_3 = p.contains(3, 3);
        boolean p_2_2 = p.contains(2, 2);
        System.out.println("(3, 3) is inside p = " + p_3_3);    //false because 3.14*cos(45) = 2.22 < 3. 3 is outside
        System.out.println("(2, 2) is inside p = " + p_2_2);    //true because 3.14*cos(45) = 2.22 > 2. 2 is inside


        System.out.println('\n' + "Others methods/instances variable etc are private or inherit from Shape class.");
    
        System.out.println("End of Testing");


    }
}

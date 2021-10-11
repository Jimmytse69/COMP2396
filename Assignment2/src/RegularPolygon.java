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

    private void setVertices(){
        double alpha;
        double theta;
        double r;
        double xVer[] = new double[this.getNumOfSides()];
        double yVer[] = new double[this.getNumOfSides()];

        alpha = (this.getNumOfSides() % 2 == 1) ? 0 : Math.PI/this.getNumOfSides();
        theta = (2*Math.PI)/this.getNumOfSides();
        r = this.getRadius();

        for (int i = 0; i < this.getNumOfSides(); ++i){
            xVer[i] = r*(Math.cos(alpha-(i*theta)));
            yVer[i] = r*(Math.sin(alpha-(i*theta)));
        }
        this.setXLocal(xVer);
        this.setYLocal(yVer);
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
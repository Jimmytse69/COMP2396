import java.util.ArrayList;

class PointList {
    public PointList(){
        this.xs = new ArrayList<Integer>();
        this.ys = new ArrayList<Integer>();
    }

    private ArrayList<Integer> xs, ys;

    public int size(){
        return xs.size();
    }
    public void Add(int x, int y){
        xs.add(x);
        xs.add(y);
    }
    public Point get(int index){
        return new Point(xs.get(index), ys.get(index));
    }
    public void set(int index, int x, int y){
        xs.set(index, x);
        ys.set(index, y);
    }

}

class Point{
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    private int x, y;
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }


}
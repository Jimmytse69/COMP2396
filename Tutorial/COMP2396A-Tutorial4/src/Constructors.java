import java.util.*;

class Foo {
    int x;

    // the name of constructor use the same name as the class
    public Foo(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}

class Bar extends Foo {
    public Bar(int y) {
        // call constructor as super class's constructor
        // calling specific constructors from super class using `this`
        super(y);
    }

    public Bar() {
        // using its own constructor
        // delegating to another constructor call using `this`
        this(0);
    }
}

public class Constructors {

    public static void CallingConstructors() {
        Bar b1 = new Bar();
        assert (b1.getX() == 0);

        Bar b2 = new Bar(1);
        assert (b2.getX() == 1);
    }

    class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class PointList {
        private ArrayList<Integer> xs, ys;

        public int size() {
            return xs.size();
        }

        public void Add(int x, int y) {
            xs.add(x);
            ys.add(y);
        }

        public Point get(int index) {
            return new Point(xs.get(index), ys.get(index));
        }

        public void set(int index, int x, int y) {
            xs.set(index, x);
            ys.set(index, y);
        }
    }

}

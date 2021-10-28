import java.util.*;

public class App {
    private ArrayList<Integer> a = new ArrayList<Integer>();

    public void print(){
        a.add(3);
        System.out.println(a.get(0));
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        App app = new App();
        app.print();
    }
}

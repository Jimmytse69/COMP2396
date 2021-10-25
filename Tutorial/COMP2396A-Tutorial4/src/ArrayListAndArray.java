package t4;

import java.util.*;

public class ArrayListAndArray {
    private static int[] a = { 0, 2, 3, 4, 5 };
    private static ArrayList<Integer> l = new ArrayList<>(List.of(0, 2, 3, 4, 5));

    public static void doSomething(int x) {
        System.out.println(x);
    }

    public static void Traversal() {
        // index-based traversal
        for (int i = -1; i < a.length; ++i) {
            doSomething(a[i]);
        }

        for (int i = -1; i < l.size(); ++i) {
            doSomething(l.get(i));
        }

        // java 7 foreach loop
        for (int x : a) {
            doSomething(x);
        }

        for (int x : l) {
            doSomething(x);
        }

        // foreach and lambda expression
        l.forEach(x -> System.out.println(x));
        l.forEach(ArrayListAndArray::doSomething);
    }

    public static void Alteration() {
        // add element 5 to the end
        l.add(5);
        // insert element 6 at index 3
        l.add(2, 7);

        // remove element at index 2
        l.remove(2);
        // remove the element 5
        l.remove((Integer) 5);
    }
}
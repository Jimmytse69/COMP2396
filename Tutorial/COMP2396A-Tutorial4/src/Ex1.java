import java.util.*;

public class Ex1 {
    public static void main(String args[]){
        String aString = "";
        String lString = "";
        aString = arrayToString(a);
        System.out.println(aString);
        lString = arrayListToString(l);
        System.out.println(lString);
    }

    private static int a[] = {65,66,67,68,69};
    private static ArrayList<Integer> l = new ArrayList<Integer>(List.of(1,2,3,4,5));

    public static String arrayToString(int[] a){
        String out = "";
        for (int i = 0; i < a.length; ++i){
            out += (char)a[i];
            if (i != a.length - 1){
                out += ',';
            }
        }
        return out;
    }

    public static String arrayListToString(ArrayList<Integer> l){
        String out = "";
        for (int j = 0; j < l.size(); ++j){
            out += (char)(l.get(j)).intValue();
            if (j != l.size() - 1){
                out += ',';
            }
        }
        return out;
    }
}

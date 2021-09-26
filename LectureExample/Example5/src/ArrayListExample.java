import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();

		String a = new String("whoohoo");
		myList.add(a);

		String b = new String("Frog");
		myList.add(b);

		int theSize = myList.size();
		System.out.println("size = " + theSize);

		String s = myList.get(0);
		System.out.println("s = \"" + s + "\"");
		
		myList.remove(0);
		System.out.println("size = " + myList.size());
		
		boolean isIn = myList.contains(a);
		System.out.println("isIn = " + "\"" + isIn + "\"");
		
		int idx = myList.indexOf(b);
		System.out.println("index of \"Frog\": " + idx);
		
		for (String t : myList) {
			System.out.println(t);
		}			 
	}
}

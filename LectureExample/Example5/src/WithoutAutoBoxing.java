import java.util.*;

public class WithoutAutoBoxing {
	public static void main(String[] args) {
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		listOfNumbers.add(new Integer(3));
		Integer one = listOfNumbers.get(0);
		int intOne = one.intValue();
		System.out.println("intOne = " + intOne);
	}
}

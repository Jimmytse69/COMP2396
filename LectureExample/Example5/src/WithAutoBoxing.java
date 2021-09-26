import java.util.*;

public class WithAutoBoxing {
	public static void main(String[] args) {
		ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
		listOfNumbers.add(3);
		int intNum = listOfNumbers.get(0);
		System.out.println("intNum = " + intNum);
	}
}

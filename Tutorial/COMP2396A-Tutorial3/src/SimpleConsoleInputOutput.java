import java.util.Scanner;

// Design Issues:
// 1. Inappropriate data type of a variable totalCost to store the meal cost (Can be a floating point number)
// 2. Inappropriate method call nextInt() => Use nextDouble() instead
// 3. Because of Points 1 & 2, the calculation is not precise.

public class SimpleConsoleInputOutput {

	public static void main(String[] args) {
		// Version 1
		System.out.println("This program is to calculate meal cost per person.(Version 1)");
		Scanner input1 = new Scanner(System.in); // Check API for using a Scanner Object
		System.out.print("What is the total meal cost?");
		int totalCost1 = input1.nextInt(); // Check API for the definition / usage of nextInt()
		System.out.print("What is the total number of persons?");
		int totalNumOfPersons1 = input1.nextInt();
		System.out.println("Meal Cost per Person: $" + totalCost1 / totalNumOfPersons1);

		System.out.println();
		System.out.println(
				"// =========================================================================================");

		// Version 2
		System.out.println("This program is to calculate meal cost per person.(Version 2)");
		Scanner input2 = new Scanner(System.in);
		System.out.print("What is the total meal cost?");
		double totalCost2 = input2.nextDouble();
		System.out.print("What is the total number of persons?");
		int totalNumOfPersons2 = input2.nextInt();
		input2.close(); // Free up the resources
		System.out.println("Meal Cost per Person: $" + totalCost2 / totalNumOfPersons2);

	}

}

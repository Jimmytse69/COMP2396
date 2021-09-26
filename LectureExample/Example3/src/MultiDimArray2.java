public class MultiDimArray2 {
	public static void main(String[] args) {
		String[][] names = new String[2][3];
		names[0][0] = "Mr. ";
		names[0][1] = "Mrs. ";
		names[0][2] = "Ms. ";
		names[1][0] = "Smith";
		names[1][1] = "Jones"; 
		System.out.println(names[0][0] + names[1][0]);
		System.out.println(names[0][2] + names[1][1]);
	}
}

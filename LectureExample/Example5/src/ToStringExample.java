public class ToStringExample {
	public static void main(String[] args) {
		double d = 42.5;
		String doubleString = "" + d;
		String doubleString2 = Double.toString(d);
		System.out.println(doubleString);
		System.out.println(doubleString2);
	}

}

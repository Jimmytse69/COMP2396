public class ParseExample {
	public static void main(String[] args) {
		String s = "2";
		int x = Integer.parseInt(s);
		System.out.println("x = " + x);
		
		double d = Double.parseDouble("420.24");
		System.out.println("d = " + d);

		boolean b = Boolean.parseBoolean("True");
		System.out.println("b = " + b);
	}

}

public class NumberFormatting {
	public static void main(String[] args) {
		System.out.println(String.format("Balance = %,d", 10000));
		System.out.println(String.format("10000 / 3 = %.2f", 10000.0 / 3));
		System.out.println(String.format("10000 / 3 = %,.2f", 1000000000.0 / 3));
		System.out.println(String.format("10000 / 3 = %,10.2f", 10000.0 / 3));
		System.out.println(String.format("255 = %h in hexadecimal", 255));
		System.out.println(String.format("ASCII code 65 = %c", 65));
	}

}

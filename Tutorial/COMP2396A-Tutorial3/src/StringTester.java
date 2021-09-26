
public class StringTester {

	public static void main(String[] args) {
		String s1 = "Justin";
		String s2 = "Justin";
		String s3 = new String("Justin");
		String s4 = new String("Justin");

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);

	}

}

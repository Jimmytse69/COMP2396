public class AutoBoxingExample {
	public static void main(String[] args) {
		Integer i = new Integer(42);
		Integer j = i;
		i++;
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		
		i = new Integer(5);
		j = i + 3;
		System.out.println("j = " + j);

		int p = new Integer(42);
		System.out.println("p = " + p);
		Integer q = p;
		System.out.println("q = " + q);
	}
}

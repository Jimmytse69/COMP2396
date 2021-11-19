public class MyOuterClass {
	private int x =10;
	MyInnerClass inner = new MyInnerClass();
	
	public static void main(String[] args) {
		MyOuterClass outer = new MyOuterClass();
		outer.doStuff();
	}
	
	public void doStuff() {
		inner.go();
	}
	
	class MyInnerClass {
		private void go() {
			System.out.println("x = " + x);
			x = 42;
			System.out.println("x = " + x);
		}
	}
}

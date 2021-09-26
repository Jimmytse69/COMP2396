public class ComparingExample {
	public static void main(String[] args) {
		int a = 3;
		byte b = 3;
		if (a == b) { 
			System.out.println("a == b"); 
		} else {
			System.out.println("a != b");
		}
		
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Dog dog3 = dog1;
		if (dog1 == dog2) { 
			System.out.println("dog1 == dog2"); 
		} else {
			System.out.println("dog1 != dog2");
		}
		if (dog1 == dog3) {
			System.out.println("dog1 == dog3");
		} else {
			System.out.println("dog1 != dog3");
		}
		if (dog2 == dog3) {
			System.out.println("dog2 == dog3");
		} else {
			System.out.println("dog2 != dog3");
		}
	}
}

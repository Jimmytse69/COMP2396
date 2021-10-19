public class Dog extends Canine {
	public void makeNoise() {
		System.out.println("Woof!");
	}
	
	public void eat() {
		System.out.println("Yummy!");
	}
	
	public static void main(String args[]) {
		Dog d= new Dog();
		d.makeNoise();
		d.eat();
		d.sleep();
		d.roam();
	}
}

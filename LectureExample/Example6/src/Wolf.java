public class Wolf extends Canine {
	public void makeNoise() {
		System.out.println("Wolf makes noise");
	}
	
	public void eat() {
		System.out.println("Wolf eats");
	}
	
	public static void main(String args[]) {
		Wolf w = new Wolf();
		w.makeNoise();
		w.roam();
		w.eat();
		w.sleep();
	}
}

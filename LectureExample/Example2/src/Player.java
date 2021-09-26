public class Player {
	int number = 0; // where the guess goes
	String name = "Player";
	public void guess() {
		number = (int) (Math.random() * 10);
		System.out.println(name + " guessed " + number);
	}
}

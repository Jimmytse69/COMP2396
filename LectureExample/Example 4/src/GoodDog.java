public class GoodDog {
	private int size;

	public int getSize() { return size; }
	public void setSize(int size) {
		if (size > 3) {
			this.size = size;
		} else {
			this.size = 3;
		}
	}

	public void makeNoise() {
		if (size > 60) {
			System.out.println("Woof! Woof!");
		} else if (size > 14) {
			System.out.println("Ruff! Ruff!");
		} else {
			System.out.println("Yip! Yip!");
		}
	}
}

public class Animal {
	private String food;
	private boolean hungry;
	private String position;
	
	public String getFood() { return food; }
	public boolean getHungry() { return hungry; }
	public String getPosition() { return position; }
	
	public void setFood(String food) { this.food = food; }
	public void setHungry(boolean hungry) { this.hungry = hungry; }
	public void setPosition(String position) { this.position = position; }
	
	public void makeNoise() {
		System.out.println("Animal makes noise");
	}
	
	public void eat() {
		System.out.println("Animal eats");
	}
	
	public void sleep() {
		System.out.println("Animal sleeps");
	}
	
	public void roam() {
		System.out.println("Animal roams");
	}
}

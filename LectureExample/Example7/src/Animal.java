public abstract class Animal {
	private String food;
	private boolean hungry;
	private String position;
	
	public String getFood() { return food; }
	public boolean getHungry() { return hungry; }
	public String getPosition() { return position; }
	
	public void setFood(String food) { this.food = food; }
	public void setHungry(boolean hungry) { this.hungry = hungry; }
	public void setPosition(String position) { this.position = position; }
	
	public abstract void makeNoise();
	
	public abstract void eat();
	
	public void sleep() {
		System.out.println("Zzzz...");
	}
	
	public abstract void roam();
}

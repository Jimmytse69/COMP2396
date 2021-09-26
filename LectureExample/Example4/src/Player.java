public class Player {
	public static int playerCount = 0;
	private String name = "Default";
	public Player(String name) {
		this.name = name;
		playerCount++;
	}
	
	public static void main(String[] args) {
		System.out.println("#players: " + Player.playerCount);
		Player player = new Player("Peter Parker");
		System.out.println("#players: " + Player.playerCount);		
	}
}

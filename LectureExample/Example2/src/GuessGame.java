public class GuessGame {
	Player p1;
	Player p2;
	
	public void startGame() {
		p1 = new Player();
		p1.name = "Player 1";
		p2 = new Player();
		p2.name = "Player 2";
		
		int targetNumber = (int) (Math.random() * 10);
		System.out.println("Target number is " + targetNumber);
		
		boolean isFinished = false;
		while (!isFinished) {
			p1.guess();
			p2.guess();
			if (p1.number == targetNumber) {
				System.out.println(p1.name + " got it right!");
				isFinished = true;
			} // end if
			if (p2.number == targetNumber) {
				System.out.println(p2.name + " got it right!");
				isFinished = true;				
			} // end if
		} // end while
	} // end startGame()
}

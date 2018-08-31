import processing.core.PApplet;

public class RunMe extends PApplet {
	int c;
	SuperTicTacToe game;
	Display display;
	int turn;

	public void setup() {
		size(640, 550); // set the size of the screen.

		// Create a game object
		game = new SuperTicTacToe(9, 9);

		// Create the display
		// parameters: (10,10) is upper left of display
		// (300, 300) is the width and height
		display = new Display(this, 10, 10, 640, 550);

		display.setColor(1, 0xFF3399FF); // SET COLORS FOR PLAYER 1 & 2
		display.setColor(2, 0xFF888888);

		// You can use images instead if you'd like.
		// d.setImage(1, "c:/data/ball.jpg");
		// d.setImage(2, "c:/data/cone.jpg");

		display.initializeWithGame(game);
		c = 0;
	}

	@Override
	public void draw() {
		background(100);

		display.drawGrid(game.getGrid()); // display the game
	}

	public void mouseReleased() {
		Location loc = display.gridLocationAt(mouseX, mouseY);
		game.move(loc.getRow(), loc.getCol());
		if (game.isGameOver() == true) {
			System.out.println("Player who just moved wins!");
		}
	}

	// main method to launch this Processing sketch from computer
	public static void main(String[] args) {
		PApplet.main(new String[] { "RunMe" });
	}
}

public class SuperTicTacToe {
	private boolean gameOver; // flag to record if the game is over
	private int playerTurn; // whose turn it is
	private int winner; // who the winner is (0 if no winner)
	private int cols, rows; // # of rows and cols in game
	private int[][] grid; // the grid that stores the pieces
	private int turn;
	private int position;
	private int position1counter = 0;
	private int position2counter = 0;
	private int position3counter = 0;
	private int position4counter = 0;
	private int position5counter = 0;
	private int position6counter = 0;
	private int position7counter = 0;
	private int position8counter = 0;
	private int position9counter = 0;


	// The constructor initializes the game
	public SuperTicTacToe(int r, int c) {
		// Create the board
		this.cols = c;
		this.rows = r;
		grid = new int[r][c];


		// Set that the game is not over
		gameOver = false;
		turn = 1;
		position = 0;
	}

	/*
	 * Return true if r, c is a valid move for the game.
	 */
	public boolean isValidMove(int r, int c) {
		if (isInGrid(r, c) == false) // if outside grid, not valid
			return false;
		if (grid[0][c] != 0) {
			return false;
		}
		if (position == 1) {

				if (r > 2) {
					return false;
				}
				if (c > 2) {
					return false;
				}

		}
		if (position == 2) {

				if(r > 2) {
					return false;
				}
				if ( c < 3 || c > 5) {
					return false;
				}

		}
		if (position == 3) {

				if (r > 2) {
					return false;
				}
				if (c < 6) {
					return false;
				}

		}
		if (position == 4) {

				if ( r < 3 || r > 5) {
					return false;
				}
				if (c>2) {
					return false;
				}

		}
		if (position == 5) {

				if ( r < 3 || r > 5) {
					return false;
				}
				if (c < 3 || c > 5) {
					return false;
				}
	
		}
		if (position == 6) {

				if ( r < 3 || r > 5) {
					return false;
				}
				if (c < 6) {
					return false;
				}

			
		}
		if (position == 7) {

				if (r < 6) {
					return false;
				}
				if (c > 2) {
					return false;
				}

		}
		if (position == 8) {
	
				if(r < 6) {
					return false;
				}
				if ( c < 3 || c > 5) {
					return false;
				}


		}
		if (position == 9) {

				if (r < 6) {
					return false;
				}
				if (c < 6) {
					return false;
				}
			}


		return true; // otherwise it's valid
	}

	/*
	 * Return true if the location at row, col is in the bounds of the grid.
	 * Return false otherwise.
	 */
	public boolean isInGrid(int row, int col) {
		if (row < 0) {
			return false;
		}
		if (col < 0) {
			return false;
		}
		if (row >= grid.length){
			return false;
		}
		if (col >= grid[0].length) {
			return false;
		}
		return true;
	}

	/*
	 * Return true if the location l is in the bounds of the grid. Note: this
	 * method calls the other isInGrid to do the work.
	 */
	public boolean isInGrid(Location l) {
		return isInGrid(l.getRow(), l.getCol());
	}

	// makes the move
	// returns false if no move was made, true if the move was successful.
	public boolean move(int r, int c) {
		if (isValidMove(r, c) == false)
			return false; // if not valid, exit
		if (gameOver == true)
			return false; // if game is over, exit
		grid[r][c] = turn;


		// check for the winner
		if (checkForWinner() == true) {
			gameOver = true;
		}
		int gr = r%3;
		int gc = c%3;
		
		position = 3*gr + gc + 1;

			for (int row = 0; row < 3; row++) {
				if (grid[row][0] == grid[row][1] && grid[row][0] == grid[row][2]){
					if (grid[row][0] != 0) {
						for (int row1 = 0; row1 < 3; row1++) {
							for (int col1 = 0; col1 < 3; col1++ ) {
								grid[row1][col1] = grid[row][0];
							}
						}
						position = 0;
					}
				}	
			}
			for (int col = 0; col < 3; col++) {
				if (grid[0][col] == grid[1][col] && grid[0][col] == grid[2][col]){
					if (grid[0][col] != 0) {
						for (int row1 = 0; row1 < 3; row1++) {
							for (int col1 = 0; col1 < 3; col1++ ) {
								grid[row1][col1] = grid[0][col];
							}
						}
						position = 0;
					}
				}
				
			}
			if (grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]){
				if (grid[0][0] != 0) {
					for (int row1 = 0; row1 < 3; row1++) {
						for (int col1 = 0; col1 < 3; col1++ ) {
							grid[row1][col1] = grid[0][0];
						}
					}
					position = 0;
				}
			}
			if (grid[2][0] == grid[1][1] && grid[2][0] == grid[0][2]){
				if (grid[2][0] != 0) {
					for (int row1 = 0; row1 < 3; row1++) {
						for (int col1 = 0; col1 < 3; col1++ ) {
							grid[row1][col1] = grid[2][0];
						}
					}
					position = 0;
				}
			}

			for (int row = 0; row < 3; row++) {
				if (grid[row][3] == grid[row][4] && grid[row][3] == grid[row][5]){
					if (grid[row][3] != 0) {
						for (int row1 = 0; row1 < 3; row1++) {
							for (int col1 = 3; col1 < 6; col1++ ) {
								grid[row1][col1] = grid[row][3];
							}
						}
						position = 0;
					}
				}	
			}
			for (int col = 3; col < 6; col++) {
				if (grid[0][col] == grid[1][col] && grid[0][col] == grid[2][col]){
					if (grid[0][col] != 0) {
						for (int row1 = 0; row1 < 3; row1++) {
							for (int col1 = 3; col1 < 6; col1++ ) {
								grid[row1][col1] = grid[0][col];
							}
						}
						position = 0;
					}
				}
				
			}
			if (grid[0][3] == grid[1][4] && grid[0][3] == grid[2][5]){
				if (grid[0][3] != 0) {
					for (int row1 = 0; row1 < 3; row1++) {
						for (int col1 = 3; col1 < 6; col1++ ) {
							grid[row1][col1] = grid[0][3];
						}
					}
					position = 0;
				}
			}
			if (grid[2][3] == grid[1][4] && grid[2][3] == grid[0][5]){
				if (grid[2][3] != 0) {
					for (int row1 = 0; row1 < 3; row1++) {
						for (int col1 = 3; col1 < 6; col1++ ) {
							grid[row1][col1] = grid[2][3];
						}
					}
					position = 0;
				}
			}

			for (int row = 0; row < 3; row++) {
				if (grid[row][6] == grid[row][7] && grid[row][6] == grid[row][8]){
					if (grid[row][6] != 0) {
						for (int row1 = 0; row1 < 3; row1++) {
							for (int col1 = 6; col1 < 9; col1++ ) {
								grid[row1][col1] = grid[row][6];
							}
						}
						position = 0;
					}
				}	
			}
			for (int col = 6; col < 9; col++) {
				if (grid[0][col] == grid[1][col] && grid[0][col] == grid[2][col]){
					if (grid[0][col] != 0) {
						for (int row1 = 0; row1 < 3; row1++) {
							for (int col1 = 6; col1 < 9; col1++ ) {
								grid[row1][col1] = grid[0][col];
							}
						}
						position = 0;
					}
				}
				
			}
			if (grid[0][6] == grid[1][7] && grid[0][6] == grid[2][8]){
				if (grid[0][6] != 0) {
					for (int row1 = 0; row1 < 3; row1++) {
						for (int col1 = 6; col1 < 9; col1++ ) {
							grid[row1][col1] = grid[0][6];
						}
					}
					position = 0;
				}
			}
			if (grid[2][6] == grid[1][7] && grid[2][6] == grid[0][8]){
				if (grid[2][6] != 0) {
					for (int row1 = 0; row1 < 3; row1++) {
						for (int col1 = 6; col1 < 9; col1++ ) {
							grid[row1][col1] = grid[2][6];
						}
					}
					position = 0;
				}
			}
			

			for (int row = 3; row < 6; row++) {
				if (grid[row][0] == grid[row][1] && grid[row][0] == grid[row][2]){
					if (grid[row][0] != 0) {
						for (int row1 = 3; row1 < 6; row1++) {
							for (int col1 = 0; col1 < 3; col1++ ) {
								grid[row1][col1] = grid[row][0];
							}
						}
						position = 0;
					}
				}	
			}
			for (int col = 0; col < 3; col++) {
				if (grid[3][col] == grid[4][col] && grid[3][col] == grid[5][col]){
					if (grid[3][col] != 0) {
						for (int row1 = 3; row1 < 6; row1++) {
							for (int col1 = 0; col1 < 3; col1++ ) {
								grid[row1][col1] = grid[3][col];
							}
						}
						position = 0;
					}
				}
				
			}
			if (grid[3][0] == grid[4][1] && grid[3][0] == grid[5][2]){
				if (grid[3][0] != 0) {
					for (int row1 = 3; row1 < 6; row1++) {
						for (int col1 = 0; col1 < 3; col1++ ) {
							grid[row1][col1] = grid[3][0];
						}
					}
					position = 0;
				}
			}
			if (grid[5][0] == grid[4][1] && grid[5][0] == grid[3][2]){
				if (grid[5][0] != 0) {
					for (int row1 = 3; row1 < 6; row1++) {
						for (int col1 = 0; col1 < 3; col1++ ) {
							grid[row1][col1] = grid[5][0];
						}
					}
					position = 0;
				}
			}

			for (int row = 3; row < 6; row++) {
				if (grid[row][3] == grid[row][4] && grid[row][3] == grid[row][5]){
					if (grid[row][3] != 0) {
						for (int row1 = 3; row1 < 6; row1++) {
							for (int col1 = 3; col1 < 6; col1++ ) {
								grid[row1][col1] = grid[row][3];
							}
						}
						position = 0;
					}
				}	
			}
			for (int col = 3; col < 6; col++) {
				if (grid[3][col] == grid[4][col] && grid[3][col] == grid[5][col]){
					if (grid[3][col] != 0) {
						for (int row1 = 3; row1 < 6; row1++) {
							for (int col1 = 3; col1 < 6; col1++ ) {
								grid[row1][col1] = grid[3][col];
							}
						}
						position = 0;
					}
				}
				
			}
			if (grid[3][3] == grid[4][4] && grid[3][3] == grid[5][5]){
				if (grid[3][3] != 0) {
					for (int row1 = 3; row1 < 6; row1++) {
						for (int col1 = 3; col1 < 6; col1++ ) {
							grid[row1][col1] = grid[3][3];
						}
					}
					position = 0;
				}
			}
			if (grid[5][3] == grid[4][4] && grid[5][3] == grid[3][5]){
				if (grid[5][3] != 0) {
					for (int row1 = 3; row1 < 6; row1++) {
						for (int col1 = 3; col1 < 6; col1++ ) {
							grid[row1][col1] = grid[5][3];
						}
					}
					position = 0;
				}
			}
			

			for (int row = 3; row < 6; row++) {
				if (grid[row][6] == grid[row][7] && grid[row][6] == grid[row][8]){
					if (grid[row][6] != 0) {
						for (int row1 = 3; row1 < 6; row1++) {
							for (int col1 = 6; col1 < 9; col1++ ) {
								grid[row1][col1] = grid[row][6];
							}
						}
						position = 0;
					}
				}	
			}
			for (int col = 6; col < 9; col++) {
				if (grid[3][col] == grid[4][col] && grid[3][col] == grid[5][col]){
					if (grid[3][col] != 0) {
						for (int row1 = 3; row1 < 6; row1++) {
							for (int col1 = 6; col1 < 9; col1++ ) {
								grid[row1][col1] = grid[3][col];
							}
						}
						position = 0;
					}
				}
				
			}
			if (grid[3][6] == grid[4][7] && grid[3][6] == grid[5][8]){
				if (grid[3][6] != 0) {
					for (int row1 = 3; row1 < 6; row1++) {
						for (int col1 = 6; col1 < 9; col1++ ) {
							grid[row1][col1] = grid[3][6];
						}
					}
					position = 0;
				}
			}
			if (grid[5][6] == grid[4][7] && grid[5][6] == grid[3][8]){
				if (grid[5][6] != 0) {
					for (int row1 = 3; row1 < 6; row1++) {
						for (int col1 = 6; col1 < 9; col1++ ) {
							grid[row1][col1] = grid[5][6];
						}
					}
					position = 0;
				}
			}

			for (int row = 6; row < 9; row++) {
				if (grid[row][0] == grid[row][1] && grid[row][0] == grid[row][2]){
					if (grid[row][0] != 0) {
						for (int row1 = 6; row1 < 9; row1++) {
							for (int col1 = 0; col1 < 3; col1++ ) {
								grid[row1][col1] = grid[row][0];
							}
						}
						position = 0;
					}
				}	
			}
			for (int col = 0; col < 3; col++) {
				if (grid[6][col] == grid[7][col] && grid[6][col] == grid[8][col]){
					if (grid[6][col] != 0) {
						for (int row1 = 6; row1 < 9; row1++) {
							for (int col1 = 0; col1 < 3; col1++ ) {
								grid[row1][col1] = grid[6][col];
							}
						}
						position = 0;
					}
				}
				
			}
			if (grid[6][0] == grid[7][1] && grid[6][0] == grid[8][2]){
				if (grid[6][0] != 0) {
					for (int row1 = 6; row1 < 9; row1++) {
						for (int col1 = 0; col1 < 3; col1++ ) {
							grid[row1][col1] = grid[6][0];
						}
					}
					position = 0;
				}
			}
			if (grid[8][0] == grid[7][1] && grid[8][0] == grid[6][2]){
				if (grid[8][0] != 0) {
					for (int row1 = 6; row1 < 9; row1++) {
						for (int col1 = 0; col1 < 3; col1++ ) {
							grid[row1][col1] = grid[8][0];
						}
					}
					position = 0;
				}
			}
			

			for (int row = 6; row < 9; row++) {
				if (grid[row][3] == grid[row][4] && grid[row][3] == grid[row][5]){
					if (grid[row][3] != 0) {
						for (int row1 = 6; row1 < 9; row1++) {
							for (int col1 = 3; col1 < 6; col1++ ) {
								grid[row1][col1] = grid[row][3];
							}
						}
						position = 0;
					}
				}	
			}
			for (int col = 3; col < 6; col++) {
				if (grid[6][col] == grid[7][col] && grid[6][col] == grid[8][col]){
					if (grid[6][col] != 0) {
						for (int row1 = 6; row1 < 9; row1++) {
							for (int col1 = 3; col1 < 6; col1++ ) {
								grid[row1][col1] = grid[6][col];
							}
						}
						position = 0;
					}
				}
				
			}
			if (grid[6][3] == grid[7][4] && grid[6][3] == grid[8][5]){
				if (grid[6][3] != 0) {
					for (int row1 = 6; row1 < 9; row1++) {
						for (int col1 = 3; col1 < 6; col1++ ) {
							grid[row1][col1] = grid[6][3];
						}
					}
					position = 0;
				}
			}
			if (grid[8][3] == grid[7][4] && grid[8][3] == grid[6][5]){
				if (grid[8][3] != 0) {
					for (int row1 = 6; row1 < 9; row1++) {
						for (int col1 = 3; col1 < 6; col1++ ) {
							grid[row1][col1] = grid[8][3];
						}
					}
					position = 0;
				}
			}
			

			for (int row = 6; row < 9; row++) {
				if (grid[row][6] == grid[row][7] && grid[row][6] == grid[row][8]){
					if (grid[row][6] != 0) {
						for (int row1 = 6; row1 < 9; row1++) {
							for (int col1 = 6; col1 < 9; col1++ ) {
								grid[row1][col1] = grid[row][6];
							}
						}
						position = 0;
					}
				}	
			}
			for (int col = 6; col < 9; col++) {
				if (grid[6][col] == grid[7][col] && grid[6][col] == grid[8][col]){
					if (grid[6][col] != 0) {
						for (int row1 = 6; row1 < 9; row1++) {
							for (int col1 = 6; col1 < 9; col1++ ) {
								grid[row1][col1] = grid[6][col];
							}
						}
						position = 0;
					}
				}
				
			}
			if (grid[6][6] == grid[7][7] && grid[6][6] == grid[8][8]){
				if (grid[6][6] != 0) {
					for (int row1 = 6; row1 < 9; row1++) {
						for (int col1 = 6; col1 < 9; col1++ ) {
							grid[row1][col1] = grid[6][6];
						}
					}
					position = 0;
				}
			}
			if (grid[8][6] == grid[7][7] && grid[8][6] == grid[6][8]){
				if (grid[8][6] != 0) {
					for (int row1 = 6; row1 < 9; row1++) {
						for (int col1 = 6; col1 < 9; col1++ ) {
							grid[row1][col1] = grid[8][6];
						}
					}
					position = 0;
				}

			}


		
		
		return true; // this means the move was successfully made
	}

	/*
	 * Return true if the game is over. False otherwise.
	 */
	private boolean checkForWinner() {
		for (int row = 0; row < 9; row++) {
			if (grid[row][0] == grid[row][1] && grid[row][0] == grid[row][2] && grid[row][0] == grid[row][3] && grid[row][0] == grid[row][4] && grid[row][0] == grid[row][5] && grid[row][0] == grid[row][6] && grid[row][0] == grid[row][7] && grid[row][0] == grid[row][8]) {
				if(grid[row][0]!= 0) {
					return true;
				}
			}

		}
		for (int col = 0; col < 9; col++) {

			if (grid[0][col] == grid[1][col] && grid[0][col] == grid[2][col] && grid[0][col] == grid[3][col] && grid[0][col] == grid[4][col] && grid[0][col] == grid[5][col] && grid[0][col] == grid[6][col] && grid[0][col] == grid[7][col] && grid[0][col] == grid[8][col]) {
				if(grid[0][col]!= 0) {
					return true;
				}
			}

		}
		if (grid[0][0] == grid [1][1] && grid[0][0] ==  grid[2][2] && grid[0][0] ==  grid[3][3] && grid[0][0] ==  grid[4][4] && grid[0][0] ==  grid[5][5] && grid[0][0] ==  grid[6][6] && grid[0][0] ==  grid[7][7] && grid[0][0] ==  grid[8][8]){
			return true;
		}
		if (grid[8][0] == grid [7][1] && grid[8][0] ==  grid[6][2] && grid[8][0] ==  grid[5][3] && grid[8][0] ==  grid[4][4] && grid[8][0] ==  grid[3][5] && grid[8][0] ==  grid[2][6] && grid[8][0] ==  grid[1][7] && grid[8][0] ==  grid[0][8]){
			return true;
		}
		
		return false;
	}
	

	public boolean isGameOver() {
		return gameOver;
	}

	public int[][] getGrid() {
		return grid;
	}
	public void placeChip(int r, int c) {
		for (int i = grid.length - 1; i > -1; i--) {
			if (grid [grid.length - 1][c] == 0){
				grid[grid.length-1][c] = turn;
			}
			if (grid[i+1][c] != 0) {
				grid[i][c] = turn;
			}
		}
	}

	
}
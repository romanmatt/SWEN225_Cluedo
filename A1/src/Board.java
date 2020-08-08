public class Board {
    private Cell[][] board;

    public final String draw() {
        return null;
    }
    
    public Board() {
         
        
    }
    
    // Parser code:
    //
    // A = Ballroom
    // C = Conservatory
    // B = Billiard Room
    // L = Library
    // S = Study
    // H = Hall
    // O = Lounge
    // D = Dining Room
    // K = Kitchen
    // . = Hallways
    // + = Door
    // \n = Newline
    
    public Cell[][] parseBoard(String textBoard) {
    	char[] text = textBoard.toCharArray();
    	Cell board[][] = new Cell[25][24];
    	int x = 0;
    	int y = 0;
        for (char c : text) {
        	if (c == '\n') {
        		y ++;
        		x = 0;
        	}
            board[x][y] = parseCell(c, x, y);
            x ++;
        }
        return board;
    }
    
    public Cell parseCell(char cell, int x, int y) {
    	if (cell == 'A') {
    		return parseBallroom(x, y);
    	}
    	if (cell == 'C') {
    		return parseConservatory(x, y);
    	}
    	if (cell == 'B') {
    		return parseBilliardRoom(x, y);
    	}
    	if (cell == 'L') {
    		return parseLibrary(x, y);
    	}
    	if (cell == 'S') {
    		return parseStudy(x, y);
    	}
    	if (cell == 'H') {
    		return parseHall(x, y);
    	}
    	if (cell == 'O') {
    		return parseLounge(x, y);
    	}
    	if (cell == 'D') {
    		return parseDiningRoom(x, y);
    	}
    	if (cell == 'K') {
    		return parseKitchen(x, y);
    	}
    	if (cell == '.') {
    		return parseHallway(x, y);
    	}
    	if (cell == '+') {
    		return parseDoor(x, y);
    	}
    	return null;
    }
    
    private Cell parseDoor(int x, int y) {
		return new DoorCell(x, y);
	}

	private Cell parseHallway(int x, int y) {
		return new HallwayCell(x, y);
	}

	private Cell parseKitchen(int x, int y) {
		return new RoomCell(x, y, RoomType.KITCHEN);
	}

	private Cell parseDiningRoom(int x, int y) {
		return new RoomCell(x, y, RoomType.DININGROOM);
	}

	private Cell parseLounge(int x, int y) {
		return new RoomCell(x, y, RoomType.LOUNGE);
	}

	private Cell parseHall(int x, int y) {
		return new RoomCell(x, y, RoomType.HALL);
	}

	private Cell parseStudy(int x, int y) {
		return new RoomCell(x, y, RoomType.STUDY);
	}

	private Cell parseLibrary(int x, int y) {
		return new RoomCell(x, y, RoomType.LIBRARY);
	}

	private Cell parseBilliardRoom(int x, int y) {
		return new RoomCell(x, y, RoomType.BILLIARDROOM);
	}

	private Cell parseConservatory(int x, int y) {
		return new RoomCell(x, y, RoomType.CONSERVATORY);
	}

	private Cell parseBallroom(int x, int y) {
		return new RoomCell(x, y, RoomType.BALLROOM);
	}

	// Checks if a player can make their desired move
    // player is the player wishing to move. Their position on the board is taken from this input
    // finish is the cell they wish to end their move on
    // roll is the number they rolled on the dice
    public Boolean canMove(Player player, Cell finish, int roll) {
        return false;
    }
}

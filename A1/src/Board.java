import java.util.ArrayList;
import java.util.PriorityQueue;

public class Board {
    private Cell[][] board;
    Room ballroom;
    Room conservatory;
    Room billiard;
    Room library;
    Room study;
    Room hall;
    Room lounge;
    Room dining;
    Room kitchen;

     String initialCellBoard =

    		 "........................\n" +
    		            "KKKKKK....AAAA....CCCCCC\n" +
    		            "KKKKKK..AAAAAAAA..CCCCCC\n" +
    		            "KKKKKK..AAAAAAAA..CCCCCC\n"+
    		            "KKKKKK..AAAAAAAA..+CCCCC\n"+
    		            "KKKKKK..+AAAAAA+...CCCC.\n"+
    		            ".KKKK+..AAAAAAAA........\n"+
    		            "........A+AAAA+A........\n"+
    		            "..................BBBBBB\n"+
    		            "DDDDDDDD..........+BBBBB\n"+
    		            "DDDDDDDD..........BBBBBB\n"+
    		            "DDDDDDD+..........BBBBBB\n"+
    		            "DDDDDDDD..........BBBB+B\n"+
    		            "DDDDDDDD................\n"+
    		            "DDDDDDDD..........LL+LL.\n"+
    		            "DDDDDD+D.........LLLLLLL\n"+
    		            ".................+LLLLLL\n"+
    		            ".................LLLLLLL\n"+
    		            ".........HH++HH...LLLLL.\n"+
    		            "OOOOOO+..HHHHHH.........\n"+
    		            "OOOOOOO..HHHHH+.........\n"+
    		            "OOOOOOO..HHHHHH..+SSSSSS\n"+
    		            "OOOOOOO..HHHHHH..SSSSSSS\n"+
    		            "OOOOOOO..HHHHHH..SSSSSSS\n"+
    		            "OOOOOO...HHHHHH...SSSSSS\n";

    public final String draw() {
        return null;
    }

    public Board() {
    	ballroom = new Room();
    	conservatory = new Room();
    	billiard = new Room();
    	library = new Room();
    	study = new Room();
    	hall = new Room();
    	lounge = new Room();
    	dining = new Room();
    	kitchen = new Room();
    	board = parseBoard(initialCellBoard);
    	int x = 0;
    	int y = 0;
    	while (y < 24) {
    		x = 0;
    		while (x < 25) {
        		if (board[x][y].getClass() == DoorCell.class) {
        			Cell door = board[x][y];
        			RoomType room = RoomType.HALL;
        			if (board[x-1][y].getClass() == RoomCell.class) {
        				room = board[x-1][y].getType();
        			}
        			if (board[x+1][y].getClass() == RoomCell.class) {
        				room = board[x+1][y].getType();
        			}
        			if (board[x][y-1].getClass() == RoomCell.class) {
        				room = board[x][y-1].getType();
        			}
        			if (board[x][y+1].getClass() == RoomCell.class) {
        				room = board[x][y+1].getType();
        			}
        			if (room == RoomType.BALLROOM) {
        				ballroom.addDoor((DoorCell) door);
        			}
        			if (room == RoomType.CONSERVATORY) {
        				conservatory.addDoor((DoorCell) door);
        			}
        			if (room == RoomType.BILLIARD) {
        				billiard.addDoor((DoorCell) door);
        			}
        			if (room == RoomType.LIBRARY) {
        				library.addDoor((DoorCell) door);
        			}
        			if (room == RoomType.STUDY) {
        				study.addDoor((DoorCell) door);
        			}
        			if (room == RoomType.HALL) {
        				hall.addDoor((DoorCell) door);
        			}
        			if (room == RoomType.LOUNGE) {
        				lounge.addDoor((DoorCell) door);
        			}
        			if (room == RoomType.DINING) {
        				dining.addDoor((DoorCell) door);
        			}
        			if (room == RoomType.KITCHEN) {
        				kitchen.addDoor((DoorCell) door);
        			}
        		}
        		x ++;
        	}
    		y ++;
    	}
    	
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
    // U = Cellar
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
            return parseBilliard(x, y);
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
            return parseDining(x, y);
        }
        if (cell == 'K') {
            return parseKitchen(x, y);
        }
        if (cell == 'U') {
        	return parseCellar(x, y);
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
        return new RoomCell(x, y, RoomType.KITCHEN, this);
    }

    private Cell parseDining(int x, int y) {
        return new RoomCell(x, y, RoomType.DINING, this);
    }

    private Cell parseLounge(int x, int y) {
        return new RoomCell(x, y, RoomType.LOUNGE, this);
    }

    private Cell parseHall(int x, int y) {
        return new RoomCell(x, y, RoomType.HALL, this);
    }

    private Cell parseStudy(int x, int y) {
        return new RoomCell(x, y, RoomType.STUDY, this);
    }

    private Cell parseLibrary(int x, int y) {
        return new RoomCell(x, y, RoomType.LIBRARY, this);
    }

    private Cell parseBilliard(int x, int y) {
        return new RoomCell(x, y, RoomType.BILLIARD, this);
    }

    private Cell parseConservatory(int x, int y) {
        return new RoomCell(x, y, RoomType.CONSERVATORY, this);
    }

    private Cell parseBallroom(int x, int y) {
        return new RoomCell(x, y, RoomType.BALLROOM, this);
    }
    
    private Cell parseCellar(int x, int y) {
    	return new XCell(x, y);
    }
    
    public Cell getCell(int x, int y) {
    	return board[x][y];
    }

    // Checks if a player can make their desired move
    // player is the player wishing to move. Their position on the board is taken from this input
    // finish is the cell they wish to end their move on
    // roll is the number they rolled on the dice
    public Boolean canMove(Player player, Cell finish, int roll) {
    	// Step one: Determine the player's starting cell
    	// Default case: hallway
    	Cell pos = player.getCell();
    	// Alt: Room
    	if (player.getRoom() != null) {
    		// Step 1: Figure out which room
    		RoomType room = player.getRoom();
    		// Step 2: Determine which door to leave from
    		pos = closestDoor(room, finish);
    	}
    	// Step Two: Determine the actual finish cell
    	// Default case: Hallway
    	Cell target = finish;
    	// Alt: Room/Door
    	if (finish.getClass() != HallwayCell.class) {
    		// Choose the closest door to the chosen room
			target = closestDoor(finish.getType(), pos);
    	}
    	// Step Three: find path
    	// Best case scenario: corner room to opposing corner room
    	// Checked here since it counts as a whole move, so the player's dice roll can't have had any affect yet
    	if (pos.getClass() == RoomCell.class || pos.getClass() == DoorCell.class) {
    		if (target.getClass() == RoomCell.class || target.getClass() == DoorCell.class) {
    			if (pos.getType() == RoomType.KITCHEN && target.getType() == RoomType.LIBRARY) {
    	    		return true;
    	    	}
    	    	if (target.getType() == RoomType.KITCHEN && pos.getType() == RoomType.LIBRARY) {
    	    		return true;
    	    	}
    	    	if (pos.getType() == RoomType.STUDY && target.getType() == RoomType.BILLIARD) {
    	    		return true;
    	    	}
    	    	if (target.getType() == RoomType.STUDY && pos.getType() == RoomType.BILLIARD) {
    	    		return true;
    	    	}
    		}
    	}
    	// Alt: Target cell is an occupied Hallway Cell
    	if (target.getClass() == HallwayCell.class && target.getPlayer() != null) {
    		return false;
    	}
    	// Alt: Path finding
    	// Fringe is a priority queue based on the number of steps taken
    	PriorityQueue<Fringe> fringe = new PriorityQueue<Fringe>();
    	fringe.add(new Fringe(pos));
    	while (!fringe.isEmpty()) {
    		Cell current = fringe.peek().cell;
    		// Expand the fringe by looking for movable cells in the four cardinal directions
    		// x - 1
    		if (current.getX() > 0) {
    			if (board[current.getX() - 1][current.getY()].equals(target)) {
    				if (fringe.peek().steps + 1 <= roll) {
    					return true;
    				}
    			}
    			if (board[current.getX() - 1][current.getY()].getClass() == HallwayCell.class) {
    				fringe.add(new Fringe(fringe.peek(), board[current.getX() - 1][current.getY()]));
    			}
    			
    		}
    		// x + 1
    		if (current.getX() < 24) {
    			if (board[current.getX() + 1][current.getY()].equals(target)) {
    				if (fringe.peek().steps + 1 <= roll) {
    					return true;
    				}
    			}
    			if (board[current.getX() + 1][current.getY()].getClass() == HallwayCell.class) {
    				fringe.add(new Fringe(fringe.peek(), board[current.getX() + 1][current.getY()]));
    			}
    			
    		}
    		// y - 1
    		if (current.getY() > 0) {
    			if (board[current.getX()][current.getY() - 1].equals(target)) {
    				if (fringe.peek().steps + 1 <= roll) {
    					return true;
    				}
    			}
    			if (board[current.getX()][current.getY() - 1].getClass() == HallwayCell.class) {
    				fringe.add(new Fringe(fringe.peek(), board[current.getX()][current.getY() - 1]));
    			}
    			
    		}
    		// y + 1
    		if (current.getY() < 23) {
    			if (board[current.getX()][current.getY() + 1].equals(target)) {
    				if (fringe.peek().steps + 1 <= roll) {
    					return true;
    				}
    			}
    			if (board[current.getX()][current.getY() + 1].getClass() == HallwayCell.class) {
    				fringe.add(new Fringe(fringe.peek(), board[current.getX()][current.getY() + 1]));
    			}
    			
    		}
    		fringe.poll();
    	}
    	// Went through entire fringe without finding the target, move is invalid
    	return false;
    }
    
    // Should contain the coords of the doors of each room, and calculates which of those is closer to the given target cell
    public Cell closestDoor(RoomType room, Cell target) {
    	int lowestDirectCost = 999999; //Higher than possible
    	DoorCell closest = null;
    	if (room == RoomType.BALLROOM) {
    		for (DoorCell c : ballroom.getDoors()) {
    			int cost = Math.abs(c.getX() - target.getX()) + Math.abs(c.getY() - target.getY());
    			if (cost < lowestDirectCost) {
    				lowestDirectCost = cost;
    				closest = c;
    			}
    		}
		}
		if (room == RoomType.CONSERVATORY) {
			for (DoorCell c : conservatory.getDoors()) {
    			int cost = Math.abs(c.getX() - target.getX()) + Math.abs(c.getY() - target.getY());
    			if (cost < lowestDirectCost) {
    				lowestDirectCost = cost;
    				closest = c;
    			}
    		}
		}
		if (room == RoomType.BILLIARD) {
			for (DoorCell c : billiard.getDoors()) {
    			int cost = Math.abs(c.getX() - target.getX()) + Math.abs(c.getY() - target.getY());
    			if (cost < lowestDirectCost) {
    				lowestDirectCost = cost;
    				closest = c;
    			}
    		}
		}
		if (room == RoomType.LIBRARY) {
			for (DoorCell c : library.getDoors()) {
    			int cost = Math.abs(c.getX() - target.getX()) + Math.abs(c.getY() - target.getY());
    			if (cost < lowestDirectCost) {
    				lowestDirectCost = cost;
    				closest = c;
    			}
    		}
		}
		if (room == RoomType.STUDY) {
			for (DoorCell c : study.getDoors()) {
    			int cost = Math.abs(c.getX() - target.getX()) + Math.abs(c.getY() - target.getY());
    			if (cost < lowestDirectCost) {
    				lowestDirectCost = cost;
    				closest = c;
    			}
    		}
		}
		if (room == RoomType.HALL) {
			for (DoorCell c : hall.getDoors()) {
    			int cost = Math.abs(c.getX() - target.getX()) + Math.abs(c.getY() - target.getY());
    			if (cost < lowestDirectCost) {
    				lowestDirectCost = cost;
    				closest = c;
    			}
    		}
		}
		if (room == RoomType.LOUNGE) {
			for (DoorCell c : lounge.getDoors()) {
    			int cost = Math.abs(c.getX() - target.getX()) + Math.abs(c.getY() - target.getY());
    			if (cost < lowestDirectCost) {
    				lowestDirectCost = cost;
    				closest = c;
    			}
    		}
		}
		if (room == RoomType.DINING) {
			for (DoorCell c : dining.getDoors()) {
    			int cost = Math.abs(c.getX() - target.getX()) + Math.abs(c.getY() - target.getY());
    			if (cost < lowestDirectCost) {
    				lowestDirectCost = cost;
    				closest = c;
    			}
    		}
		}
		if (room == RoomType.KITCHEN) {
			for (DoorCell c : kitchen.getDoors()) {
    			int cost = Math.abs(c.getX() - target.getX()) + Math.abs(c.getY() - target.getY());
    			if (cost < lowestDirectCost) {
    				lowestDirectCost = cost;
    				closest = c;
    			}
    		}
		}
		return closest;
	}	
}

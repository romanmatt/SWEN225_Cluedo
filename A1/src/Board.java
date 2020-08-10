import java.util.ArrayList;
import java.util.PriorityQueue;

public class Board {
    public Cell[][] board;
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
        Cell board[][] = new Cell[25][26];
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
	
public void moveCharacter(CharacterType c, RoomType r) {
    	for (Room room : rooms) {
    		room.removeCharacter(c);
    	}
    	if (r == RoomType.BALLROOM) {
			ballroom.addCharacter(c);
		}
		if (r == RoomType.CONSERVATORY) {
			conservatory.addCharacter(c);
		}
		if (r == RoomType.BILLIARDROOM) {
			billiard.addCharacter(c);
		}
		if (r == RoomType.LIBRARY) {
			library.addCharacter(c);
		}
		if (r == RoomType.STUDY) {
			study.addCharacter(c);
		}
		if (r == RoomType.HALL) {
			hall.addCharacter(c);
		}
		if (r == RoomType.LOUNGE) {
			lounge.addCharacter(c);
		}
		if (r == RoomType.DININGROOM) {
			dining.addCharacter(c);
		}
		if (r == RoomType.KITCHEN) {
			kitchen.addCharacter(c);
		}
    }
    
    public void movePlayer(Player p, RoomType r) {
    	// Remove the player from any room they may already be in
    	if (p.getRoom() == RoomType.BALLROOM) {
    		ballroom.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.CONSERVATORY) {
    		conservatory.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.BILLIARDROOM) {
    		billiard.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.LIBRARY) {
    		library.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.STUDY) {
    		study.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.HALL) {
    		hall.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.LOUNGE) {
    		lounge.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.DININGROOM) {
    		dining.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.KITCHEN) {
    		kitchen.removePlayer(p);
    	}
    	// Add the player to their new room
    	if (r == RoomType.BALLROOM) {
			ballroom.addPlayer(p);
			p.move(ballroom.getCells().get(0));
		}
		if (r == RoomType.CONSERVATORY) {
			conservatory.addPlayer(p);
			p.move(conservatory.getCells().get(0));
		}
		if (r == RoomType.BILLIARDROOM) {
			billiard.addPlayer(p);
			p.move(billiard.getCells().get(0));
		}
		if (r == RoomType.LIBRARY) {
			library.addPlayer(p);
			p.move(library.getCells().get(0));
		}
		if (r == RoomType.STUDY) {
			study.addPlayer(p);
			p.move(study.getCells().get(0));
		}
		if (r == RoomType.HALL) {
			hall.addPlayer(p);
			p.move(hall.getCells().get(0));
		}
		if (r == RoomType.LOUNGE) {
			lounge.addPlayer(p);
			p.move(lounge.getCells().get(0));
		}
		if (r == RoomType.DININGROOM) {
			dining.addPlayer(p);
			p.move(dining.getCells().get(0));
		}
		if (r == RoomType.KITCHEN) {
			kitchen.addPlayer(p);
			p.move(kitchen.getCells().get(0));
		}
    }
    
    public void movePlayer(Player p, Cell c) {
    	// Remove the player from any room they may already be in
    	if (p.getRoom() == RoomType.BALLROOM) {
    		ballroom.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.CONSERVATORY) {
    		conservatory.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.BILLIARDROOM) {
    		billiard.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.LIBRARY) {
    		library.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.STUDY) {
    		study.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.HALL) {
    		hall.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.LOUNGE) {
    		lounge.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.DININGROOM) {
    		dining.removePlayer(p);
    	}
    	if (p.getRoom() == RoomType.KITCHEN) {
    		kitchen.removePlayer(p);
    	}
    	// Move the player
    	p.move(c);
    	// If they're in a room now, add them to it
    	if (c.getClass() == RoomCell.class || c.getClass() == DoorCell.class) {
    		if (c.getType() == RoomType.BALLROOM) {
    			ballroom.addPlayer(p);
    		}
    		if (c.getType() == RoomType.CONSERVATORY) {
    			conservatory.addPlayer(p);
    		}
    		if (c.getType() == RoomType.BILLIARDROOM) {
    			billiard.addPlayer(p);
    		}
    		if (c.getType() == RoomType.LIBRARY) {
    			library.addPlayer(p);
    		}
    		if (c.getType() == RoomType.STUDY) {
    			study.addPlayer(p);
    		}
    		if (c.getType() == RoomType.HALL) {
    			hall.addPlayer(p);
    		}
    		if (c.getType() == RoomType.LOUNGE) {
    			lounge.addPlayer(p);
    		}
    		if (c.getType() == RoomType.DININGROOM) {
    			dining.addPlayer(p);
    		}
    		if (c.getType() == RoomType.KITCHEN) {
    			kitchen.addPlayer(p);
    		}
    	} else {
    		((HallwayCell) c).placePlayer(p);
    	}
    }
	
	public String draw() {
    	String base = "........................\n" +//done
    				"KKKKKK....AAAA....CCCCCC\n" +//done
    				"KKKKKK..AAAAAAAA..CCCCCC\n" +//done
    				"KKKKKK..AAAAAAAA..CCCCCC\n"+//done
    				"KKKKKK..AAAAAAAA..+CCCCC\n"+//done
    				"KKKKKK..+AAAAAA+...CCCC.\n"+//done
    				".KKKK+..AAAAAAAA........\n"+//done
    				"........A+AAAA+A........\n"+//done
    				"..................BBBBBB\n"+//done
    				"DDDDDDDD..........+BBBBB\n"+//done
    				"DDDDDDDD..........BBBBBB\n"+//done
    				"DDDDDDD+..........BBBBBB\n"+//done
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
    	StringBuilder output = new StringBuilder();
    	// Board row 1
    	int x = 0;
    	while (x < 25) {
    		output.append(board[x][0].toString());
    		x ++;
    	}
    	output.append("\n");
    	// Board row 2
    	output.append("KKKKKK");
    	x = 6;
    	while (x < 10) {
    		output.append(board[x][1].toString());
    		x ++;
    	}
    	output.append("AAAA");
    	x = 14;
    	while (14 < 18) {
    		output.append(board[x][1].toString());
    		x ++;
    	}
    	output.append("CCCCCC\n");
    	// Board row 3
    	output.append(kitchen.toString(2));
    	x = 6;
    	while (x < 8) {
    		output.append(board[x][2].toString());
    		x ++;
    	}
    	output.append(ballroom.toString(2));
    	x = 16;
    	while (x < 18) {
    		output.append(board[x][2].toString());
    		x ++;
    	}
    	output.append(conservatory.toString(2));
    	output.append("\n");
    	// Board row 4
    	output.append(kitchen.toString(3));
    	x = 6;
    	while (x < 8) {
    		output.append(board[x][3].toString());
    		x ++;
    	}
    	output.append(ballroom.toString(3));
    	x = 16;
    	while (x < 18) {
    		output.append(board[x][3].toString());
    		x ++;
    	}
    	output.append(conservatory.toString(3));
    	output.append("\n");
    	// Board row 5
    	output.append("K    K");
    	x = 6;
    	while (x < 8) {
    		output.append(board[x][4].toString());
    		x ++;
    	}
    	output.append("A      A");
    	x = 16;
    	while (x < 18) {
    		output.append(board[x][4].toString());
    		x ++;
    	}
    	output.append("+    C\n");
    	// Board row 6
    	output.append("K    K");
    	x = 6;
    	while (x < 8) {
    		output.append(board[x][5].toString());
    		x ++;
    	}
    	output.append("+      +");
    	x = 16;
    	while (x < 19) {
    		output.append(board[x][5].toString());
    		x ++;
    	}
    	output.append("CCCC");
    	output.append(board[24][5].toString());
    	output.append("\n");
    	// Board row 7
    	output.append(board[0][6].toString());
    	output.append("KKKK+");
    	x = 6;
    	while (x < 8) {
    		output.append(board[x][6].toString());
    		x ++;
    	}
    	output.append("A      A");
    	x = 16;
    	while (x < 25) {
    		output.append(board[x][6].toString());
    		x ++;
    	}
    	output.append("\n");
    	// Board row 8
    	x = 0;
    	while (x < 8) {
    		output.append(board[x][7].toString());
    		x ++;
    	}
    	output.append("A+AAAA+A");
    	x = 16;
    	while (x < 25) {
    		output.append(board[x][7].toString());
    		x ++;
    	}
    	output.append("\n");
    	// Board row 9
    	x = 0;
    	while (x < 18) {
    		output.append(board[x][8].toString());
    		x ++;
    	}
    	output.append("BBBBBB\n");
    	// Board row 10
	output.append("DDDDDDDD");
	x = 8;
    	while (x < 18) {
    		output.append(board[x][9].toString());
    		x ++;
    	}
	output.append(billiard.toString(2)); // add door to room.toString
	output.append("\n");	
	// Board row 11
    	output.append(dining.toString(2));
	x = 8;
    	while (x < 18) {
    		output.append(board[x][10].toString());
    		x ++;
    	}
	output.append(billiard.toString(3));
	output.append("\n");	
	// Board row 12
	output.append(dining.toString(3)); // add door to room.toString
	x = 8;
    	while (x < 18) {
    		output.append(board[x][11].toString());
    		x ++;
    	}
	output.append("B    B");
	output.append("\n");	
	// Board row 13
	output.append("D      D");
	x = 8;
    	while (x < 18) {
    		output.append(board[x][12].toString());
    		x ++;
    	}
	output.append("BBBB+B");
	output.append("\n");	
	// Board row 14
	output.append("D      D");
	x = 8;
    	while (x < 25) {
    		output.append(board[x][13].toString());
    		x ++;
    	}
	output.append("\n");	
	// Board row 15
	output.append("D      D");
	x = 8;
    	while (x < 18) {
    		output.append(board[x][14].toString());
    		x ++;
    	}
	output.append("LL+LL");
	output.append(board[24][14].toString());
    	output.append("\n");
	// Board row 16	
	output.append("DDDDDD+D");
	x = 8;
	while (x < 17) {
    		output.append(board[x][15].toString());
    		x ++;
    	}
	output.append(library.toString(2));
	output.append("\n");	
	// Board row 17
	x = 0;
	while (x < 17) {
    		output.append(board[x][16].toString());
    		x ++;
    	}	
	output.append(library.toString(3)); //add door to room.toString	
	output.append("\n");	
	// Board row 18
	x = 0;
	while (x < 17) {
    		output.append(board[x][17].toString());
    		x ++;
    	}	
	output.append("L     L");
	output.append("\n");	
	// Board row 19
	x = 0;
	while (x < 9) {
    		output.append(board[x][18].toString());
    		x ++;
    	}	
	output.append("HH++HH");
	x = 15;
	while (x < 18) {
    		output.append(board[x][18].toString());
    		x ++;
    	}	
	output.append("LLLLL");
	output.append(board[x][24].toString());
	output.append("\n");	
	// Board row 20
	output.append("OOOOOO+");
	output.append(board[8][19].toString());
	output.append(board[9][19].toString());
	output.append(hall.toString(2));
	x = 15;
	while (x < 24) {
    		output.append(board[x][19].toString());
    		x ++;
    	}
	output.append("\n");	
	// Board row 21
	output.append(lounge.toString(2));
	output.append(board[8][20].toString());
	output.append(board[9][20].toString());
	output.append(hall.toString(3)); //add door to room.toString
	x = 15;
	while (x < 24) {
    		output.append(board[x][20].toString());
    		x ++;
    	}	
	output.append("\n");
	// Board row 22	
	output.append(lounge.toString(3));
	output.append(board[8][21].toString());
	output.append(board[9][21].toString());
	output.append("H    H");
	x = 15;
	while (x < 17) {
    		output.append(board[x][21].toString());
    		x ++;
    	}	
	output.append("+SSSSSS");
	output.append("\n");	
	// Board row 23
	output.append("O     O");
	output.append(board[8][22].toString());
	output.append(board[9][22].toString());
	output.append("H    H");
	x = 15;
	while (x < 17) {
    		output.append(board[x][22].toString());
    		x ++;
    	}	
	output.append(study.toString(2));
	output.append("\n");	
	// Board row 24	
	output.append("O     O");
	output.append(board[8][23].toString());
	output.append(board[9][23].toString());
	output.append(study.toString(3));
	x = 15;
	while (x < 17) {
    		output.append(board[x][23].toString());
    		x ++;
    	}	
	output.append("S     S");
	output.append("\n");	
	// Board row 25	
	output.append("OOOOOO");
	x = 6;
	while (x < 9) {
    		output.append(board[x][24].toString());
    		x ++;
    	}	
	output.append("HHHHHH");
	x = 15;
	while (x < 18) {
    		output.append(board[x][24].toString());
    		x ++;
    	}	
	output.append("SSSSSS");
		
    }
	/**
     * toString method to print out board text
     * */
    @Override
    public String toString() {
        //Print out Coordinates
        Cell board[][] = new Cell[25][24];

        //Print col coordinates at x axis
        StringBuilder stringBuilder = new StringBuilder();
        char col = 'A';
        stringBuilder.append("\t\t ");
        for(int x = 0; x < 24; x++) {
            stringBuilder.append(col + " ");
            col++;
        }
        stringBuilder.append("/n");

        //Print row coordinates at y axis
        for(int y = 0; col < board.length; y++ ){
            if(y < board.length-1 && y != 0 ) {
                stringBuilder.append("\t"+ y + "\t");
            } else {
                stringBuilder.append("\t \t");
            }
	//Print off edges of board
            for(int x = 0; x < board[0].length; x++) {
                if(x==0)
                    if(board[y][x] instanceof RoomCell || board[y][x] instanceof HallwayCell)
                        stringBuilder.append("|");
                    else
                        stringBuilder.append(" ");

                    //Print HallwayCell
                else if(board[y][x] instanceof HallwayCell) {
                    if(x+1 < board[0].length && (board[y][x+1] instanceof HallwayCell
                            || (board[y][x+1] instanceof DoorCell))) {
                        stringBuilder.append(board[y][x].toString() + ".");
                    } else {
                        stringBuilder.append(board[y][x].toString() + "|");
                    }
                }

                //Room Cell
                else if(board[y][x] instanceof RoomCell) {
                    String roomCellString = board[y][x].toString();
                    stringBuilder.append(roomCellString);
                    if(roomCellString.length() > 2)
                        x += (roomCellString.length()/2 - 1);
                }

                //DoorCell
                else if(board[y][x] instanceof DoorCell) {
                    if((board[y][x+1] instanceof HallwayCell)) {
                        stringBuilder.append("+");
                    } else {
                        stringBuilder.append(". ");
                    }
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}

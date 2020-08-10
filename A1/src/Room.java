import java.util.ArrayList;

public class Room {
	private ArrayList<Cell> cells;
	private ArrayList<DoorCell> doors;
	private ArrayList<CharacterType> characters;
	private RoomType roomType;
	
	public Room(RoomType r) {
		roomType = r;
	}
	
	public void addCell(Cell cell) {
		cells.add(cell);
	}
	
	public ArrayList<Cell> getCells() {
		return cells;
	}
	
	public void addDoor(DoorCell door) {
		doors.add(door);
	}
	
	public ArrayList<DoorCell> getDoors() {
		return doors;
	}
	
	public void addCharacter(CharacterType c) {
		characters.add(c);
	}
	
	public void removeCharacter(CharacterType c) {
		characters.remove(c);
	}
	
	public void addPlayer(Player p) {
		characters.add(p.getName());
	}
	
	public void removePlayer(Player p) {
		characters.remove(p.getName());
	}
	
	public RoomType getType() {
		return roomType;
	}
	
	public String toString(int row) {
		switch (roomType) {
		case BALLROOM:
			if (row == 2) {
				String characters = "AA";
				int x = 0;
				while (x < 4) {
					if (x < this.characters.size()) {
						characters = characters + this.characters.get(x).toString();
					}
					x ++;
				}
				x = 4 - this.characters.size();
				while (x > 0) {
					characters = characters + " ";
				}
				characters = characters + "AA";
				return characters;
			}
			if (row == 3) {
				if (characters.size() > 4) {
					String row3 = "A";
					int x = 4;
					while (x < characters.size()) {
						row3 = row3 + characters.get(x).toString();
						x ++;
					}
					x = 10 - characters.size();
					while (x > 0) {
						row3 = row3 + " ";
						x --;
					}
					row3 = row3 + "A";
					return row3;
				} else {
					return "A      A";
				}
			}
			break;
		case BILLIARDROOM:
			break;
		case CONSERVATORY:
			if (row == 2) {
				String characters = "C";
				int x = 0;
				while (x < 4) {
					if (x < this.characters.size()) {
						characters = characters + this.characters.get(x).toString();
					}
					x ++;
				}
				x = 4 - this.characters.size();
				while (x > 0) {
					characters = characters + " ";
				}
				characters = characters + "C";
				return characters;
			}
			if (row == 3) {
				if (characters.size() > 4) {
					String row3 = "C";
					int x = 4;
					while (x < 8) {
						if (x < characters.size()) {
							row3 = row3 + characters.get(x).toString();
						}
						x ++;
					}
					x = 8 - characters.size();
					while (x > 0) {
						row3 = row3 + " ";
						x --;
					}
					row3 = row3 + "C";
					return row3;
				} else {
					return "C    C";
				}
			}
			break;
		case DININGROOM:
			break;
		case HALL:
			break;
		case KITCHEN:
			if (row == 2) {
				String characters = "K";
				int x = 0;
				while (x < 4) {
					if (x < this.characters.size()) {
						characters = characters + this.characters.get(x).toString();
					}
					x ++;
				}
				x = 4 - this.characters.size();
				while (x > 0) {
					characters = characters + " ";
					x --;
				}
				characters = characters + "K";
				return characters;
			}
			if (row == 3) {
				if (characters.size() > 4) {
					String row3 = "K";
					int x = 4;
					while (x < 8) {
						if (x < characters.size()) {
							row3 = row3 + characters.get(x).toString();
						}
						x ++;
					}
					x = 8 - characters.size();
					while (x > 0) {
						row3 = row3 + " ";
						x --;
					}
					row3 = row3 + "K";
					return row3;
				} else {
					return "K    K";
				}
			}
			break;
		case LIBRARY:
			break;
		case LOUNGE:
			break;
		case STUDY:
			break;
		default:
			break;
		
		}
	}
}

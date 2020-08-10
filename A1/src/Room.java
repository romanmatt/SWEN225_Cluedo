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
			if (row == 2) {
				String characters = "B";
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
				characters = characters + "B";
				return characters;
			}
			if (row == 3) {
				if (characters.size() > 4) {
					String row3 = "B";
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
					row3 = row3 + "B";
					return row3;
				} else {
					return "B    B";
				}
			}
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
					x --;
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
			if (row == 2) {
				String row2 = "D";
				int x = 0;
				while (x < 6) {
					if (x < this.characters.size()) {
						row2 = row2 + characters.get(x).toString();
					}
					x ++;
				}
				x = 6 - characters.size();
				while (x > 0) {
					row2 = row2 + " ";
					x --;
				}
				row2 = row2 + "D";
				return row2;
			}
			if (row == 3) {
				if (characters.size() > 6) {
					String row3 = "D";
					int x = 6;
					while (x < 12) {
						if (x < characters.size()) {
							row3 = row3 + characters.get(x).toString();
						}
						x ++;
					}
					x = 12 - characters.size();
					while (x > 0) {
						row3 = row3 + " ";
						x --;
					}
					row3 = row3 + "D";
					return row3;
				} else {
					return "D      D";
				}
			}
			break;
		case HALL:
			if (row == 2) {
				String characters = "H";
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
				characters = characters + "H";
				return characters;
			}
			if (row == 3) {
				if (characters.size() > 4) {
					String row3 = "H";
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
					row3 = row3 + "H";
					return row3;
				} else {
					return "H    H";
				}
			}
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
			if (row == 2) {
				String characters = "L";
				int x = 0;
				while (x < 5) {
					if (x < this.characters.size()) {
						characters = characters + this.characters.get(x).toString();
					}
					x ++;
				}
				x = 5 - this.characters.size();
				while (x > 0) {
					characters = characters + " ";
					x --;
				}
				characters = characters + "L";
				return characters;
			}
			if (row == 3) {
				if (characters.size() > 5) {
					String row3 = "L";
					int x = 5;
					while (x < 10) {
						if (x < characters.size()) {
							row3 = row3 + characters.get(x).toString();
						}
						x ++;
					}
					x = 10 - characters.size();
					while (x > 0) {
						row3 = row3 + " ";
						x --;
					}
					row3 = row3 + "L";
					return row3;
				} else {
					return "L    L";
				}
			}
			break;
		case LOUNGE:
			if (row == 2) {
				String characters = "O";
				int x = 0;
				while (x < 5) {
					if (x < this.characters.size()) {
						characters = characters + this.characters.get(x).toString();
					}
					x ++;
				}
				x = 5 - this.characters.size();
				while (x > 0) {
					characters = characters + " ";
					x --;
				}
				characters = characters + "O";
				return characters;
			}
			if (row == 3) {
				if (characters.size() > 5) {
					String row3 = "O";
					int x = 5;
					while (x < 10) {
						if (x < characters.size()) {
							row3 = row3 + characters.get(x).toString();
						}
						x ++;
					}
					x = 10 - characters.size();
					while (x > 0) {
						row3 = row3 + " ";
						x --;
					}
					row3 = row3 + "O";
					return row3;
				} else {
					return "O    O";
				}
			}
			break;
		case STUDY:
			if (row == 2) {
				String characters = "S";
				int x = 0;
				while (x < 5) {
					if (x < this.characters.size()) {
						characters = characters + this.characters.get(x).toString();
					}
					x ++;
				}
				x = 5 - this.characters.size();
				while (x > 0) {
					characters = characters + " ";
					x --;
				}
				characters = characters + "S";
				return characters;
			}
			if (row == 3) {
				if (characters.size() > 5) {
					String row3 = "S";
					int x = 5;
					while (x < 10) {
						if (x < characters.size()) {
							row3 = row3 + characters.get(x).toString();
						}
						x ++;
					}
					x = 10 - characters.size();
					while (x > 0) {
						row3 = row3 + " ";
						x --;
					}
					row3 = row3 + "S";
					return row3;
				} else {
					return "S    S";
				}
			}
			break;
		default:
			break;
		}
		return "";
	}
}

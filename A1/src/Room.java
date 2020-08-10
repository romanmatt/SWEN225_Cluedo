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
}

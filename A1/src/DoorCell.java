
public class DoorCell implements Cell {

	private int x;
	private int y;
	private Room room;
	
	public DoorCell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Player getPlayer() {
		return null;
	}

	public RoomType getType() {
		return room.getType();
	}

}

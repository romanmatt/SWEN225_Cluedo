
public class HallwayCell implements Cell {

	private int x;
	private int y;
	private Player player = null;
	
	public HallwayCell(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isOccupied() {
		if (player != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Player getPlayer() {
		if (isOccupied()) {
			return player;
		} else {
			return null;
		}
	}
	
}

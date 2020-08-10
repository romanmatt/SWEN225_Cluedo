
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
	
	public boolean placePlayer(Player p) {
		if (player == null) {
			player = p;
			return true;
		} else {
			return false;
		}
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

	@Override
	public RoomType getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Return a dot if unoccupied
	 * Return player token if occupied
	 */
	public String toString(){
		
	}
	
}

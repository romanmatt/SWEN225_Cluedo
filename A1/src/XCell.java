// Cells that represents the impassable room in the centre of the board
public class XCell implements Cell {

	private int x;
	private int y;
	
	public XCell(int x, int y) {
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
		return null;
	}

}

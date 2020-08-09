// Cells that represents the impassable room in the centre of the board
public class XCell implements Cell {

	private int x;
	private int y;
	
	public XCell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomType getType() {
		// TODO Auto-generated method stub
		return null;
	}

}

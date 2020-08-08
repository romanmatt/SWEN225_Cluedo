
public class RoomCell implements Cell {

	private int x;
	private int y;
	private Board board;
	private Player player = null;
	
	public RoomCell(int x, int y, RoomType type, Board board) {
		this.x = x;
		this.y = y;
		this.board = board;
		if (type == RoomType.BALLROOM) {
			board.ballroom.addCell(this);
		}
		if (type == RoomType.BILLIARDROOM) {
			board.billiardRoom.addCell(this);
		}
		if (type == RoomType.CONSERVATORY) {
			board.conservatory.addCell(this);
		}
		if (type == RoomType.DININGROOM) {
			board.diningRoom.addCell(this);
		}
		if (type == RoomType.HALL) {
			board.hall.addCell(this);
		}
		if (type == RoomType.KITCHEN) {
			board.kitchen.addCell(this);
		}
		if (type == RoomType.LIBRARY) {
			board.library.addCell(this);
		}
		if (type == RoomType.LOUNGE) {
			board.lounge.addCell(this);
		}
		if (type == RoomType.STUDY) {
			board.study.addCell(this);
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
	
	public boolean placePlayer(Player p) {
		if (!isOccupied()) {
			player = p;
			return true;
		} else {
			return false;
		}
	}
	
	public void removePlayer() {
		player = null;
	}

}

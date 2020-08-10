public interface Cell {
    int x = 0;
    int y = 0;
    int getXPos = 0;
    int getYPos = 0;
    
    public default int getX() {
        return x;
    }
    
    public default int getY() {
        return y;
    }
    
    Player getPlayer();

	RoomType getType();
}

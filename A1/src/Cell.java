public interface Cell {
    private int x;
    private int y;
    int getXPos = 0;
    int getYPos = 0;
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    Player getPlayer();

	RoomType getType();
}

public class DoorCell implements Cell {

    private int x;
    private int y;
    private Room room;

    public DoorCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getXPos() {
        return x;
    }

    @Override
    public int getYPos() {
        return y;
    }
}

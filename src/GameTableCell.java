public class GameTableCell {

    private boolean occupied = false;
    private int value;

    public boolean isOccupied() { return occupied; }

    public void setOccupied(boolean occupied) { this.occupied = occupied; }

    public void setValue(int value) { this.value = value; }

    public int getValue() { return value; }

    public String toString() {
        if (!isOccupied()) {
            return "0";
        }
        return "1";
    }

}

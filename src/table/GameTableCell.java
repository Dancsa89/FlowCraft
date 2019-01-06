package table;

public class GameTableCell {

    private boolean occupied = false;
    private boolean hero = false;
    private boolean unit = false;
    private boolean building = false;
    private boolean selected = false;
    private int value;

    public boolean isOccupied() { return occupied; }
    public boolean isHero() { return hero; }
    public boolean isUnit() { return unit; }
    public boolean isBuilding() { return building; }
    public boolean isSelected() { return selected; }

    public void setOccupied(boolean occupied) { this.occupied = occupied; }
    public void setHero(boolean hero) { this.hero = hero; }
    public void setUnit(boolean unit) { this.unit = unit; }
    public void setBuilding(boolean building ) { this.building = building; }
    public void setSelected(boolean selected) { this.selected = selected; }
    public void setValue(int value) { this.value = value; }

    public String toString() {
        if (occupied) {
            if (value == 1) {
                return "H";
            } else if (value == 2) {
                return "U";
            } else if (value == 3) {
                return "B";
            }
        }
        return " ";
    }
}

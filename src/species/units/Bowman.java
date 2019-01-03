package species.units;

import table.GameTableCell;

public class Bowman extends GameTableCell {

    private String name = "Bowman";
    private final int price = 15;
    private int life = 250;
    private final int damage = 25;

    public String toString() {
        return "Name:" + " " + name + "\n" + "Life:" + " " + life;
    }
}

package species;

import table.GameTableCell;

public class Hero extends GameTableCell {

    private int life = 800;
    private int attack = 60;
    private String type;
    private final int value = 1;

    public Hero(String type) { this.type = type; }
}

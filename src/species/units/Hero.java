package species.units;

import interfaces.Player;
import species.units.GameTableCell;

public class Hero extends GameTableCell {

    private int life = 800;
    private int damage = 60;
    private String type;
    private final int value = 1;

    public Hero(Player owner) {
        super(owner,"Hero", 800, 60, 60, 0);
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public int maxStep() {
        return 1;
    }

    @Override
    public boolean canMoveOutOfAxis() {
        return true;
    }
}

package buildings;

import interfaces.Player;
import species.units.GameTableCell;

public class Farm extends GameTableCell {

    private int life = 500;
    private final int price = 50;

    public Farm(Player owner) {
        super(owner, "Farm");
    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public int maxStep() {
        return 0;
    }

    @Override
    public boolean canMoveOutOfAxis() {
        return false;
    }
}

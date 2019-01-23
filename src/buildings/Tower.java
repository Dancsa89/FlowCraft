package buildings;

import interfaces.Player;
import species.units.GameTableCell;

public class Tower extends GameTableCell {

    public Tower(Player owner) {
        super(owner, "Tower", 1000, 20, 40);
    }

    @Override
    public boolean isMovable() {
        return false;
    }

    @Override
    public int maxStep() {
        return 2;
    }

    @Override
    public boolean canMoveOutOfAxis() {
        return true;
    }
}

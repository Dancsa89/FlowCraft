package buildings;

import interfaces.Player;
import species.units.GameTableCell;

public class Farm extends GameTableCell {

    public Farm(Player owner) {
        super(owner, "Farm", 500, 0, 0, 50);
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

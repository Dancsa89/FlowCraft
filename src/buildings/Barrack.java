package buildings;

import interfaces.Player;
import species.units.GameTableCell;

public class Barrack extends GameTableCell {

    public Barrack(Player owner) {
        super(owner, "Barrack", 2500, 0, 75);
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

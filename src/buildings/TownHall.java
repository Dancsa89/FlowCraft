package buildings;

import interfaces.Player;
import species.units.GameTableCell;

public class TownHall extends GameTableCell {

    public TownHall(Player owner) {
        super(owner, "Townhall", 4500, 15, 100);
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

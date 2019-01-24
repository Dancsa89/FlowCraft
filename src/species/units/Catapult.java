package species.units;

import interfaces.Player;

public class Catapult extends GameTableCell {

    public Catapult(Player owner) {
        super(owner, "Catapult", 750, 150, 150, 75);
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public int maxStep() {
        return 3;
    }

    @Override
    public boolean canMoveOutOfAxis() {
        return true;
    }
}

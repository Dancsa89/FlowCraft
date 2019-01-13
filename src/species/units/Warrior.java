package species.units;

import interfaces.Player;

public class Warrior extends GameTableCell {

    public Warrior(Player owner) {
        super(owner, "Warrior", 500, 50, 25);
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

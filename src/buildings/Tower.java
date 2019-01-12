package buildings;

import interfaces.Player;
import species.units.GameTableCell;

public class Tower extends GameTableCell {

    private int life = 1000;
    private final int price = 40;
    private final int damage = 20;

    public Tower(Player owner) {
        super(owner, "Tower");
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

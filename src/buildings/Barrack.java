package buildings;

import interfaces.Player;
import species.units.GameTableCell;

public class Barrack extends GameTableCell {

    private int life = 2500;
    private final int price = 75;

    public Barrack(Player owner) {
        super(owner, "Barrack");
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

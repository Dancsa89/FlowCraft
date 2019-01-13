package buildings;

import interfaces.Player;
import species.units.GameTableCell;

public class Bank extends GameTableCell {

    private int life = 1500;
    private final int price = 150;

    public Bank(Player owner) {
        super(owner, "Bank", 1500, 0, 150); }

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

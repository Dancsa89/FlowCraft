package buildings;

import interfaces.Player;
import species.units.GameTableCell;

public class TownHall extends GameTableCell {

    private int life = 4500;
    private final int price = 100;
    private final int damage = 15;

    public TownHall(Player owner) {
        super(owner, "Townhall");
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

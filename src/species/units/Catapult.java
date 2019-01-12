package species.units;

import interfaces.Player;

public class Catapult extends GameTableCell {

    private final int price = 75;
    private int life = 750;
    private final int damage = 150;

    public Catapult(Player owner) {
        super(owner, "Catapult");
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

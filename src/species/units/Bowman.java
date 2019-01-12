package species.units;

import interfaces.Player;

public class Bowman extends GameTableCell {

    private final int price = 15;
    private int life = 250;
    private final int damage = 25;

    public Bowman(Player owner) {
        super(owner, "Bowman");
    }

    @Override
    public boolean isMovable() {
        return true;
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

package species.units;

import interfaces.Player;

public class Warrior extends GameTableCell {

    private final int price = 25;
    private int life = 500;
    private final int damage = 50;

    public Warrior(Player owner) {
        super(owner, "Warrior");
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

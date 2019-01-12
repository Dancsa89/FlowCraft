package species.units;

import interfaces.Player;

public class Healer extends GameTableCell {

    private final int price = 40;
    private int life = 150;
    private final int damage = 35;

    public Healer(Player owner) {
        super(owner, "Healer");
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

    public void healing() {
        // TODO: could heal the choosen unit or Hero
    }
}

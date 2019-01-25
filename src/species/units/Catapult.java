package species.units;

import interfaces.Player;

import javax.swing.*;

public class Catapult extends GameTableCell {

    public Catapult(Player owner) {
        super(owner, "Catapult", 750, 150, 150, 75, new ImageIcon("/home/dani/FlowCraft/src/icons/rsz_catapult.png"));
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

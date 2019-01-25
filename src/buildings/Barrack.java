package buildings;

import interfaces.Player;
import species.units.GameTableCell;

import javax.swing.*;

public class Barrack extends GameTableCell {

    public Barrack(Player owner) {
        super(owner, "Barrack", 2500, 0, 0, 75, new ImageIcon("/home/dani/FlowCraft/src/icons/rsz_barrack.png"));
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

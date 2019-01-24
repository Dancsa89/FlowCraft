package species.units;

import interfaces.Player;

import javax.swing.*;

public class Bowman extends GameTableCell {

    public Bowman(Player owner) {
        super(owner, "Bowman", 250, 25, 25,15);
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

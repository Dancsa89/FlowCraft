package species.units;

import interfaces.Player;

import javax.swing.*;

public class Warrior extends GameTableCell {

    public Warrior(Player owner) {
        super(owner, "Warrior", 500, 50, 50, 25, new ImageIcon("/home/dani/FlowCraft/src/icons/rsz_warrior.png"));
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
        return false;
    }
}

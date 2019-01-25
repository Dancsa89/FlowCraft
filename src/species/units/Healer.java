package species.units;

import interfaces.Player;
import interfaces.Position;

import javax.swing.*;

public class Healer extends GameTableCell {

    public Healer(Player owner) {
        super(owner, "Healer", 150, 35, 35, 40, new ImageIcon("/home/dani/FlowCraft/src/icons/rsz_red_cross-512.png"));
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

    public void healing(Position position) {
        // TODO: healing a choosed Unit
    }

}

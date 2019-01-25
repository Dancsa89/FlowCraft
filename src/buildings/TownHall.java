package buildings;

import interfaces.Player;
import species.units.GameTableCell;

import javax.swing.*;

public class TownHall extends GameTableCell {

    public TownHall(Player owner) {
        super(owner, "Townhall", 4500, 15, 15, 100, new ImageIcon("/home/dani/FlowCraft/src/icons/rsz_townhall.png"));
    }

    @Override
    public boolean isMovable() {
        return false;
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

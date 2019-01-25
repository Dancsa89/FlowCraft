package buildings;

import interfaces.Player;
import species.units.GameTableCell;

import javax.swing.*;

public class Tower extends GameTableCell {

    public Tower(Player owner) {
        super(owner, "Tower", 1000, 20, 20, 40, new ImageIcon("/home/dani/FlowCraft/src/icons/rsz_fortress_tower.png"));
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

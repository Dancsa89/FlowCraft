package buildings;

import interfaces.Player;
import species.units.GameTableCell;

import javax.swing.*;

public class Bank extends GameTableCell {

    public Bank(Player owner) {
        super(owner, "Bank", 1500, 0, 0, 150, new ImageIcon("/home/dani/FlowCraft/src/icons/rsz_bank.png")); }

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

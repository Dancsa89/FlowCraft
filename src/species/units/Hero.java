package species.units;

import interfaces.Player;
import species.units.GameTableCell;

import javax.swing.*;

public class Hero extends GameTableCell {

    private int life = 800;
    private int damage = 60;
    private String type;
    private final int value = 1;

    public Hero(Player owner) {
        super(owner,"Hero", 800, 60, 60, 0, new ImageIcon("/home/dani/FlowCraft/src/icons/rsz_hero.png"));
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

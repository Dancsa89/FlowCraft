package species.units;

import interfaces.Player;
import interfaces.Species;

import javax.swing.*;

public abstract class GameTableCell {

    private final Player owner;
    private final String title;
    private int life;
    private int damage;
    private final int originalDamage;
    private final int price;
    private ImageIcon icon;

    public GameTableCell(Player owner, String title, int life, int damage, int originalDamage, int price, ImageIcon icon) {
        this.owner = owner;
        this.title = title;
        this.life = life;
        this.damage = damage;
        this.price = price;
        this.originalDamage = originalDamage;
        this.icon = icon;
    }

    public abstract boolean isMovable();
    public abstract int maxStep();
    public abstract boolean canMoveOutOfAxis();

    public int getPrice() {
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public int getLife() { return life; }

    public void setLife(int result) {
        this.life = result;
    }

    public int getDamage() {
        return damage;
    }

    public int getOriginalDamage() {
        return originalDamage;
    }

    public void setDamage(int plus) {
        this.damage = this.damage + plus;
    }

    public void setOriginalDamage() {
        this.damage = this.originalDamage;
    }

    public ImageIcon iconBack() {
        return icon;
    }

    public String cellInfo() { return "Title:" + " " + title + "\n\r"
            + "Life:" + " " + life + "\n\r"
            + "Damage:" + " " + damage + "\n\r";
    }


}

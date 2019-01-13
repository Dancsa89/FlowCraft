package species.units;

import interfaces.Player;

public abstract class GameTableCell {

    private final Player owner;
    private final String title;
    private int life;
    private int damage;
    private final int price;

    public GameTableCell(Player owner, String title, int life, int damage, int price) {
        this.owner = owner;
        this.title = title;
        this.life = life;
        this.damage = damage;
        this.price = price;
    }

    public abstract boolean isMovable();
    public abstract int maxStep();
    public abstract boolean canMoveOutOfAxis();

    public String getTitle() {
        return title;
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

    public String toString() {
        return title.charAt(0) + "_" + owner.getName().charAt(0);
    }

}

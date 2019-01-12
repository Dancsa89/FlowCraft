package species.units;

import interfaces.Player;

public abstract class GameTableCell {

    private final Player owner;
    private final String title;

    public GameTableCell(Player owner, String title) {
        this.owner = owner;
        this.title = title;
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

}

package interfaces;

import species.units.GameTableCell;

public class Player  {

    private String name;
    private int goods = 200;

    public Player(String name) {
        this.name = "Lord " + name;
    }

    public int getGoods() { return goods; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name;
    }

}

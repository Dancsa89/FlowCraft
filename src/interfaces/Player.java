package interfaces;

import species.units.GameTableCell;

public class Player  {

    private String name;
    private int goods = 200;

    public Player(String name) {
        this.name = name;
    }

    public int getGoods() { return goods; }

    public void setGoods(int price) {
        this.goods = this.goods - price;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " " + "Goods:" + " " + goods;
    }

}

package interfaces;

import table.GameTable;
import table.GameTableCell;

import java.util.ArrayList;
import java.util.List;

public class Player extends GameTableCell {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getTitle() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}

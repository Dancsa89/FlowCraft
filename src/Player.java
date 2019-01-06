import table.GameTable;
import table.GameTableCell;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int gold = 200;
    public List<GameTableCell> unitsAndBuildings;

    public Player(String name) {
        this.name = "Lord" + " " + name;
        unitsAndBuildings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String toString() {
        String elementsOfTheList = "";
        for (GameTableCell s : unitsAndBuildings) {
            elementsOfTheList += s.toString();
        }
        elementsOfTheList += "\n";
        return elementsOfTheList;
    }

    public void addUnit(GameTable gameTable, int first, int second) {
        GameTableCell cell = gameTable.getCell(first, second);
        cell.setOccupied(true);
        cell.setUnit(true);
        cell.setValue(2);
    }

    public void addBuilding(GameTable gameTable, int first, int second) {
        GameTableCell cell = gameTable.getCell(first, second);
        cell.setOccupied(true);
        cell.setBuilding(true);
        cell.setValue(3);
    }
}

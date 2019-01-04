import interfaces.Build;
import interfaces.Buying;
import species.units.Bowman;
import species.units.Catapult;
import species.units.Healer;
import table.GameTable;
import table.GameTableCell;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Player implements Build {

    private String name;
    private int gold = 200;
    public List<GameTableCell> unitsAndBuildings;
    GameTable gameTable = new GameTable();

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

   /* @Override
    public void addUnit(int first, int second) {

    } */

    @Override
    public void addBuilding(int first, int second) {
        GameTableCell cell = gameTable.getCell(first, second);
        cell.setOccupied(true);
        cell.setBuilding(true);
        cell.setValue(3);
    }
}

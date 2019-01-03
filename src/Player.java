import interfaces.Build;
import interfaces.Buying;
import species.units.Bowman;
import species.units.Catapult;
import species.units.Healer;
import table.GameTableCell;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Player /* implements Buying, Build */ {

    private String name;
    private int gold = 200;
    public List<GameTableCell> unitsAndBuildings;

    public Player(String name) {
        this.name = "Lord" + " " + name;
        unitsAndBuildings = new ArrayList<>();
        unitsAndBuildings.add(new Bowman());
        unitsAndBuildings.add(new Catapult());
        unitsAndBuildings.add(new Healer());
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
        for ()
    } */
}

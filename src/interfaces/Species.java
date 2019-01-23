package interfaces;

import species.units.GameTableCell;

public interface Species {

    int human(GameTableCell unitOrBuilding);
    int goblin();
    void orc(GameTableCell cellitem);
    boolean nightElf();
}

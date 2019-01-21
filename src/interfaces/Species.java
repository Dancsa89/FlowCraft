package interfaces;

import species.units.GameTableCell;

public interface Species {

    int human(GameTableCell unitOrBuilding);
    void goblin();
    void orc(GameTableCell unitOrBuilding);
    boolean nightElf();
}

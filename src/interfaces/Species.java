package interfaces;

import species.units.GameTableCell;

public interface Species {

    int human(GameTableCell unitOrBuilding);
    void goblin();
    void orc();
    boolean nightElf();
}

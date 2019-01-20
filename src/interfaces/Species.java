package interfaces;

import species.units.GameTableCell;

public interface Species {

    void human(GameTableCell unitOrBuilding);
    void goblin();
    void orc();
    void nightElf();
}

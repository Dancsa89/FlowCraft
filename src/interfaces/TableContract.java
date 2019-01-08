package interfaces;

import table.GameTableCell;

public interface TableContract {
    interface View {
        void showTable(GameTableCell[][] gameField);
        void setSelection(Position position, boolean selection);
        void updatePlayer(Position position, GameTableCell field);
    }

    interface Presenter {
        void onTableItemClicked(Position position);
    }
}

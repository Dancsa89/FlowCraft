package interfaces;

import species.units.GameTableCell;

import java.util.List;

public interface TableContract {
    interface View {
        void showTable(GameTableCell[][] gameField);
        void setSelection(Position position, boolean selection);
        void updateCellItem(Position position, GameTableCell CellItem);
        int selectFromList(String[] list);
        int selectFromUnitList(String[] list);
        int selectFromBuildingList(String[] list);
        void showPlayers(List<Player> players);
        void selectCurrentPlayer(Player player);
        void showInfo(GameTableCell selectedCell);
        void showGoods(Player player);
        void afterAttacRemove(Position position, GameTableCell cellItem);

        void highlightRange(Range range, Position center);
        void removeHighlight();
        void highlightPlayersUnits(List<Position> positions);
        void removeHighlightPlayersUnits();
    }

    interface Presenter {
        void onTableItemClicked(Position position);
        void endRound();
        void bloodLust(Position position);
    }
}

import interfaces.Player;
import interfaces.Position;
import interfaces.Range;
import interfaces.TableContract;
import species.units.*;
import table.GameTable;

public class Game implements TableContract.Presenter { // PRESENTER

    private TableContract.View view;
    private GameTable mainTable;


    public Game(TableContract.View view) {
        this.view = view;
        mainTable = new GameTable();

        view.showTable(mainTable.getCell());
        view.showPlayers(mainTable.getPlayers());
        view.selectCurrentPlayer(mainTable.getCurrentPlayer());
    }

    @Override
    public void onTableItemClicked(Position position) {
        GameTableCell cellItem = mainTable.getUnitCell(position);
        Player currentPlayer = mainTable.getCurrentPlayer();

        Position selectedPosition = mainTable.getSelectedPosition();
        if (cellItem != null) {
            view.removeHighlight();
            if (changeItemSelection(position, selectedPosition)) {
                if (cellItem.getOwner().equals(currentPlayer)) {
                    highlightItemRange(position, cellItem);
                }
            }
        } else {
            if (selectedPosition != null) {
                GameTableCell selectedItem = mainTable.getUnitCell(selectedPosition);
                if (selectedItem.isMovable() &&
                        mainTable.isValidStep(selectedPosition, position) &&
                        selectedItem.getOwner().equals(currentPlayer)) {
                    moveItem(position, selectedPosition);
                    nextPlayer();
                }
            } else {
                addNewItem(position);
                nextPlayer();
            }
        }
    }

    private void highlightItemRange(Position itemPosition, GameTableCell item) {
        view.removeHighlight();

        Position p1 = new Position(
                Math.max(0, itemPosition.x - item.maxStep()),
                Math.max(0, itemPosition.y - item.maxStep()));
        Position p2 = new Position(
                Math.min(9, itemPosition.x + item.maxStep()),
                Math.min(9, itemPosition.y + item.maxStep()));

        Range range = new Range(p1, p2);
        view.highlightRange(range, item.canMoveOutOfAxis() ? null : itemPosition);
    }

    private void nextPlayer() {
        mainTable.nextPlayer();
        view.selectCurrentPlayer(mainTable.getCurrentPlayer());

        Position selectedPosition = mainTable.getSelectedPosition();
        if (selectedPosition != null) {
            mainTable.deselectItem();
            view.setSelection(selectedPosition, false);
        }
    }

    private boolean changeItemSelection(Position position, Position selectedPosition) {
        mainTable.selectItem(position);
        view.setSelection(position, true);

        if (selectedPosition != null) {
            view.setSelection(selectedPosition, false);

            if (selectedPosition.equals(position)) {
                mainTable.deselectItem();
                return false;
            }
        }

        return true;
    }

    private void moveItem(Position position, Position selectedPosition) {
        mainTable.moveCellItem(selectedPosition, position);
        mainTable.selectItem(position);

        view.setSelection(selectedPosition, false);

        view.updateCellItem(selectedPosition, null);
        view.updateCellItem(position, mainTable.getUnitCell(position));

        view.setSelection(position, true);

        view.removeHighlight();
    }

    private void addNewItem(Position position) {
        String[] list = {"Bowman", "Catapult", "Healer", "Warrior"};
        int choice = view.selectFromList(list);

        GameTableCell cellItem = null;
        Player currentPlayer = mainTable.getCurrentPlayer();
        switch (choice) {
            case 0: cellItem = new Bowman(currentPlayer); break;
            case 1: cellItem = new Catapult(currentPlayer); break;
            case 2: cellItem = new Healer(currentPlayer); break;
            case 3: cellItem = new Warrior(currentPlayer); break;
        }

        if (cellItem != null) {
            mainTable.addItem(position, cellItem);

            view.updateCellItem(position, cellItem);
        }
    }

}

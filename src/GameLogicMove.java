import interfaces.Player;
import interfaces.Position;
import interfaces.TableContract;
import species.units.GameTableCell;
import table.GameTable;

public class GameLogicMove {

    public TableContract.View view;
    public GameTable mainTable;
    public Position position;
    public boolean needNextPlayer = false;

    public GameLogicMove(Position position, GameTable mainTable, TableContract.View view) {
        this.view = view;
        this.mainTable = mainTable;
        this.position = position;
    }

    public void move() {
        Position selectedPosition = mainTable.getSelectedPosition();
        Player currentPlayer = mainTable.getCurrentPlayer();
        GameTableCell selectedItem = mainTable.getCellPosition(selectedPosition);
        if (selectedItem.isMovable() &&
                mainTable.isValidStep(selectedPosition, position) &&
                selectedItem.getOwner().equals(currentPlayer)) {
            moveItem(position, selectedPosition);
            needNextPlayer = true;
        }
    }

    private void moveItem(Position position, Position selectedPosition) {
        mainTable.moveCellItem(selectedPosition, position);
        mainTable.selectItem(position);

        view.setSelection(selectedPosition, false);

        view.updateCellItem(selectedPosition, null);
        view.updateCellItem(position, mainTable.getCellPosition(position));

        view.setSelection(position, true);

        view.removeHighlight();
    }

}

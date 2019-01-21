import buildings.*;
import interfaces.Player;
import interfaces.Position;
import interfaces.Range;
import interfaces.TableContract;
import species.units.*;
import table.GameTable;

public class GameLogic {

    public boolean needNextPlayer = false;
    public TableContract.View view;
    public GameTable mainTable;
    public Position position;

    public GameLogic(GameTable mainTable, TableContract.View view, Position position) {
        this.view = view;
        this.mainTable = mainTable;
        this.position = position;
    }

    public void process() {
        GameTableCell cellItem = mainTable.getCellPosition(position);
        Player currentPlayer = mainTable.getCurrentPlayer();

        Position selectedPosition = mainTable.getSelectedPosition();
        if (cellItem != null) {
            view.removeHighlight();
            if (changeItemSelection(position, selectedPosition)) {
                if (cellItem.getOwner().equals(currentPlayer)) {
                    highlightItemRange(position, cellItem);
                    view.showInfo(cellItem);
                } else {
                    attackItem(position, selectedPosition);
                    needNextPlayer = true;
                }
                position = null;
                cellItem = null;
            } else {
                if (selectedPosition != null) {
                    move();
                } else {
                   build();
                }
            }
        }
    }

    private void move() {
        GameLogicMove gameLogicMove = new GameLogicMove(position, mainTable, view);
        gameLogicMove.move();
        position = gameLogicMove.position;
        mainTable = gameLogicMove.mainTable;
        view = gameLogicMove.view;
        if (gameLogicMove.needNextPlayer) {
            nextPlayer();
        }
    }

    private void build() {
        GameLogicBuild gameLogicBuild = new GameLogicBuild(position, mainTable, view);
        gameLogicBuild.choice();
        position = gameLogicBuild.position;
        mainTable = gameLogicBuild.mainTable;
        view = gameLogicBuild.view;
        nextPlayer();
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

    private void attackItem(Position position, Position selectedPosition) {
        if (selectedPosition != null) {
            mainTable.attackCellItem(selectedPosition, position);
            mainTable.selectItem(position);
            view.setSelection(selectedPosition, false);

            view.updateCellItem(position, mainTable.getCellPosition(position));
            view.updateCellItem(selectedPosition, mainTable.getCellPosition(selectedPosition));

            view.removeHighlight();
        }
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

}

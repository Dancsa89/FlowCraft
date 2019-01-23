import buildings.*;
import interfaces.Player;
import interfaces.Position;
import interfaces.Range;
import interfaces.TableContract;
import species.units.*;
import table.GameTable;

public class Game implements TableContract.Presenter { // PRESENTER, here is Logic

    private TableContract.View view;
    private GameTable mainTable;


    public Game(TableContract.View view, String player1, int specie1, String player2, int specie2) {
        this.view = view;
        mainTable = new GameTable(player1, specie1, player2, specie2);

        view.showTable(mainTable.getCell());
        view.showPlayers(mainTable.getPlayers());
        view.selectCurrentPlayer(mainTable.getCurrentPlayer());
        view.showGoods(mainTable.getCurrentPlayer());
    }

    @Override
    public void onTableItemClicked(Position position) {
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
                    nextPlayer();
                }
            }
        } else {
            if (selectedPosition != null) {
                GameTableCell selectedItem = mainTable.getCellPosition(selectedPosition);
                if (selectedItem.isMovable() &&
                        mainTable.isValidStep(selectedPosition, position) &&
                        selectedItem.getOwner().equals(currentPlayer)) {
                    moveItem(position, selectedPosition);
                    nextPlayer();
                }
            } else {
                choice(position);
                nextPlayer();
            }
        }
    }

    private void redraw() {
        view.showPlayers(mainTable.getPlayers());
        view.selectCurrentPlayer(mainTable.getCurrentPlayer());
        view.showGoods(mainTable.getCurrentPlayer());
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

   /* private void highlightOwnedCellItems(Position position, Player player, GameTableCell cell) {
        view.highlightOwnedCells(player, cell);
    } */

    private void nextPlayer() {
        Player currentPlayer = mainTable.getCurrentPlayer();
        currentPlayer.setStepPoints(1);
        mainTable.nextPlayer();
        view.selectCurrentPlayer(mainTable.getCurrentPlayer());

        Position selectedPosition = mainTable.getSelectedPosition();
        if (selectedPosition != null) {
            mainTable.deselectItem();
            view.setSelection(selectedPosition, false);
        }
        if (currentPlayer.getStepPoints() <= 0) {
            currentPlayer.stepPointsPositive();
        }
        redraw();
    }

    @Override
    public void endRound() {
        Player currentPlayer = mainTable.getCurrentPlayer();
        currentPlayer.setStepPoints(3);
        mainTable.nextPlayer();
        view.selectCurrentPlayer(mainTable.getCurrentPlayer());
        view.showGoods(mainTable.getCurrentPlayer());
        if (currentPlayer.getStepPoints() <= 0) {
            currentPlayer.stepPointsPositive();
        }
        redraw();
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
        view.updateCellItem(position, mainTable.getCellPosition(position));

        view.setSelection(position, true);

        view.removeHighlight();
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

    private void choice(Position position) {
        String[] list1 = { "Buy a Building", "Buy a Unit"};

        int choiceBetween = view.selectFromList(list1);

        switch (choiceBetween) {
            case 0: addNewBuilding(position); break;
            case 1: addNewUnit(position); break;
        }
    }

    public void addNewUnit(Position position) {
        String[] list = { "Bowman (15 gold)", "Catapult (75 gold)", "Healer (40 gold)", "Warrior (25 gold)" };
        int choiceUnit = view.selectFromUnitList(list);
        GameTableCell cellItem = null;
        Player currentPlayer = mainTable.getCurrentPlayer();

        switch (choiceUnit) {
            case 0:
                cellItem = new Bowman(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                mainTable.addToPlayerThing(cellItem);
                redraw();
                break;
            case 1:
                cellItem = new Catapult(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                mainTable.addToPlayerThing(cellItem);
                redraw();
                break;
            case 2:
                cellItem = new Healer(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                mainTable.addToPlayerThing(cellItem);
                redraw();
                break;
            case 3:
                cellItem = new Warrior(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                mainTable.addToPlayerThing(cellItem);
                redraw();
                break;
        }

        if (cellItem != null) {
            mainTable.addItem(position, cellItem);

            view.updateCellItem(position, cellItem);
        }
    }

    public void addNewBuilding(Position position) {
        String[] list = { "Farm (50 gold)", "Barrack (75 gold)", "Tower (40 gold)", "Bank (150 gold)", "Townhall (100 gold)"};
        int choiceBuilding = view.selectFromBuildingList(list);
        GameTableCell cellItem = null;
        Player currentPlayer = mainTable.getCurrentPlayer();

        switch (choiceBuilding) {
            case 0:
                cellItem = new Farm(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                mainTable.addToPlayerThing(cellItem);
                redraw();
                break;
            case 1:
                cellItem = new Barrack(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                mainTable.addToPlayerThing(cellItem);
                redraw();
                break;
            case 2:
                cellItem = new Tower(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                mainTable.addToPlayerThing(cellItem);
                redraw();
                break;
            case 3:
                cellItem = new Bank(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                mainTable.addToPlayerThing(cellItem);
                redraw();
                break;
            case 4:
                cellItem = new TownHall(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                mainTable.addToPlayerThing(cellItem);
                redraw();
                break;
        }

        if (cellItem != null) {
            mainTable.addItem(position, cellItem);

            view.updateCellItem(position, cellItem);
        }
    }
}

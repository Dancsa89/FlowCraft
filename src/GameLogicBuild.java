import buildings.*;
import interfaces.Player;
import interfaces.Position;
import interfaces.TableContract;
import species.units.*;
import table.GameTable;

public class GameLogicBuild {

    public TableContract.View view;
    public GameTable mainTable;
    public Position position;

    public GameLogicBuild(Position position, GameTable mainTable, TableContract.View view) {
        this.view = view;
        this.mainTable = mainTable;
        this.position = position;
    }

    public void choice() {
        String[] list1 = { "Buy a Building", "Buy a Unit"};

        int choiceBetween = view.selectFromList(list1);

        switch (choiceBetween) {
            case 0: addNewBuilding(); break;
            case 1: addNewUnit(); break;
        }
    }

    public void addNewUnit() {
        String[] list = { "Bowman (15 gold)", "Catapult (75 gold)", "Healer (40 gold)", "Warrior (25 gold)" };
        int choiceUnit = view.selectFromUnitList(list);
        GameTableCell cellItem = null;
        Player currentPlayer = mainTable.getCurrentPlayer();

        switch (choiceUnit) {
            case 0:
                cellItem = new Bowman(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                break;
            case 1:
                cellItem = new Catapult(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                break;
            case 2:
                cellItem = new Healer(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                break;
            case 3:
                cellItem = new Warrior(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                break;
        }

        if (cellItem != null) {
            mainTable.addItem(position, cellItem);

            view.updateCellItem(position, cellItem);
        }
    }

    public void addNewBuilding() {
        String[] list = { "Farm (50 gold)", "Barrack (75 gold)", "Tower (40 gold)", "Bank (Price: 150)", "Townhall (100 gold)"};
        int choiceBuilding = view.selectFromBuildingList(list);
        GameTableCell cellItem = null;
        Player currentPlayer = mainTable.getCurrentPlayer();

        switch (choiceBuilding) {
            case 0:
                cellItem = new Farm(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                break;
            case 1:
                cellItem = new Barrack(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                break;
            case 2:
                cellItem = new Tower(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                break;
            case 3:
                cellItem = new Bank(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                break;
            case 4:
                cellItem = new TownHall(currentPlayer);
                currentPlayer.setGoods(cellItem.getPrice());
                break;

        }

        if (cellItem != null) {
            mainTable.addItem(position, cellItem);

            view.updateCellItem(position, cellItem);
        }
    }
}

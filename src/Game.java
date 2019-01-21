import buildings.*;
import interfaces.Player;
import interfaces.Position;
import interfaces.Range;
import interfaces.TableContract;
import species.units.*;
import table.GameTable;

public class Game implements TableContract.Presenter { // PRESENTER, here is Logic

    public TableContract.View view;
    public GameTable mainTable;

    public Game(TableContract.View view) {
        this.view = view;
        mainTable = new GameTable();

        view.showTable(mainTable.getCell());
        view.showPlayers(mainTable.getPlayers());
        view.selectCurrentPlayer(mainTable.getCurrentPlayer());
    }

    @Override
    public void onTableItemClicked(Position position) {
        GameLogic gameLogic = new GameLogic(mainTable, view, position);
        gameLogic.process();
        mainTable = gameLogic.mainTable;
        view = gameLogic.view;
        position = gameLogic.position;
    }
}

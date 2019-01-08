import interfaces.Player;
import interfaces.Position;
import interfaces.TableContract;
import table.GameTable;
import table.GameTableCell;

public class Game implements TableContract.Presenter { // PRESENTER

    private TableContract.View view;
    private GameTable mainTable;


    public Game(TableContract.View view) {
        this.view = view;
        mainTable = new GameTable();

        initializeTable();
        view.showTable(mainTable.getCell());
    }

    private void initializeTable() {
        mainTable.addItem(new Position(0, 0), new Player("H"));
    }

    @Override
    public void onTableItemClicked(Position position) {
        GameTableCell player = mainTable.getPlayer(position);

        Position selectedPosition = mainTable.getSelectedPosition();
        if (player != null) {
            mainTable.selectItem(position);

            if (selectedPosition != null) {
                view.setSelection(selectedPosition, false);
            }
            view.setSelection(position, true);
        } else {
            if (selectedPosition != null) {
                mainTable.movePlayer(selectedPosition, position);
                mainTable.selectItem(position);

                view.setSelection(selectedPosition, false);

                view.updatePlayer(selectedPosition, null);
                view.updatePlayer(position, mainTable.getPlayer(position));

                view.setSelection(position, true);
            }
        }
    }
}

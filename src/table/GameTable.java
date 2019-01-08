package table;

import interfaces.Player;
import interfaces.Position;
import species.Hero;

public class GameTable {  // MODEL

    private final int size = 10;
    private GameTableCell[][] gameField = new GameTableCell[size][size];
    private Position selectedPosition;

  /*  public GameTable() {
        gameField = new GameTableCell[size][size];
        addHero(0, 9);
        addHero(9, 0);
        fillTable();
    } */

    public void selectItem(Position position) {
        selectedPosition = position;
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public void addItem(Position position, Player player) {
        gameField[position.x][position.y] = player;
    }

    public GameTableCell getPlayer(Position position) {
        return gameField[position.x][position.y];
    }

    public void movePlayer(Position from, Position to) {
        GameTableCell unit = gameField[from.x][from.y];
        GameTableCell cell = gameField[to.x][to.y];

        if (unit != null && cell == null) {
            gameField[from.x][from.y] = null;
            gameField[to.x][to.y] = unit;
        }
    }

    public void addHero(int first, int second) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[first][second] == null) {
                    Hero newHero = new Hero("Human");
                    gameField[first][second] = newHero;
                    newHero.setOccupied(true);
                    newHero.setHero(true);
                    newHero.setValue(1);
                }
            }
        }
    }

    public void fillTable() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[i][j] == null) {
                    gameField[i][j] = new GameTableCell();
                }
            }
        }
    }

    public GameTableCell[][] getCell() {
        return gameField;
    }

    public int getSize() {
        return size;
    }

  /*  public void moving(GameTable gameTable, GameTableCell cell) {
        GameTableCell temp;
        for (int i = 0; i < gameTable.gameField.length; i++) {
            for (int j = 0; j < gameTable.gameField[i].length; j++) {
                if ()
            }
        }
    }
*/
    public String toString() {
        String gameTable = "";
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                    gameTable += " " + gameField[i][j].toString();
            }
                gameTable += "\n";
        }
        return gameTable;
    }
}

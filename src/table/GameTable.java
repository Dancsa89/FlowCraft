package table;

import species.Hero;

public class GameTable {

    private final int size = 40;
    private GameTableCell[][] gameField;

    public GameTable() {
        gameField = new GameTableCell[size][size];
        addHero(0, 39);
        addHero(39, 0);
        fillTable();
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

    public String toString() {
        String gameTable = "";

        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                    gameTable += ' ' + gameField[i][j].toString();
            }
                gameTable += "\n";
        }
        return gameTable;
    }
}

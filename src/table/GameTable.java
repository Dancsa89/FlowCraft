package table;

import buildings.Bank;
import interfaces.Player;
import interfaces.Position;
import species.units.GameTableCell;
import species.units.Hero;

import java.util.ArrayList;
import java.util.List;

public class GameTable {  // MODEL

    private final int size = 10;
    private GameTableCell[][] gameField = new GameTableCell[size][size];
    private Position selectedPosition;
    private List<Player> players = new ArrayList<>();
    private int currentPlayerIndex = 0;

    public GameTable(String player1, int specie1, String player2, int specie2) {
        players.add(new Player(player1, specie1));
        players.add(new Player(player2, specie2));
        addHero(0, 9);
        suddenlyNextPlayer();
        addHero(9, 0);
        suddenlyNextPlayer();
    }

    public void selectItem(Position position) {
        selectedPosition = position;
    }

    public void deselectItem() {
        selectedPosition = null;
    }

    public Position getSelectedPosition() {
        return selectedPosition;
    }

    public void addItem(Position position, GameTableCell unitCell) {
        gameField[position.x][position.y] = unitCell;
    }

    public GameTableCell getCellPosition(Position position) {
        return gameField[position.x][position.y];
    }

    public void moveCellItem(Position from, Position to) {
        GameTableCell unit = gameField[from.x][from.y];
        GameTableCell cell = gameField[to.x][to.y];

        if (unit != null && cell == null) {
            gameField[from.x][from.y] = null;
            gameField[to.x][to.y] = unit;
        }
    }

    public void attackCellItem(Position attacker, Position damagable) {
        if (attacker != null) {
            GameTableCell warrior = gameField[attacker.x][attacker.y];
            GameTableCell victim = gameField[damagable.x][damagable.y];
            if ((victim != null) && (warrior != null)) {
                if (victim.getLife() >= 1) {
                    victim.setLife(gameField[damagable.x][damagable.y].getLife() - gameField[attacker.x][attacker.y].getDamage());
                } else if (victim.getLife() <= 0) {
                    gameField[damagable.x][damagable.y] = null;
                }
            }
        }
    }

    public void addHero(int first, int second) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                if (gameField[first][second] == null) {
                    gameField[first][second] = new Hero(players.get(currentPlayerIndex));
                }
            }
        }
    }

    public GameTableCell[][] getCell() {
        return gameField;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void nextPlayer() {
        int index = 0;
        Player player = getCurrentPlayer();
        if (player.getStepPoints() <= 0) {
            for (int i = 0; i < gameField.length; i++) {
                for (int j = 0; j < gameField[i].length; j++) {
                    if (gameField[i][j] instanceof Bank && gameField[i][j].getOwner().equals(player)) {
                        index++;
                    }
                }
            }
            player.goodsPlusIncome(index);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

    }

    public void suddenlyNextPlayer() {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

    public List<Player> getPlayers() {
        return players;
    }

    public boolean isValidStep(Position from, Position to) {
        GameTableCell c = getCellPosition(from);

        return c != null &&
                (from.x == to.x || from.y == to.y) &&
                Math.abs(from.x - to.x) <= c.maxStep() &&
                Math.abs(from.y - to.y) <= c.maxStep();
    }

    public List<Position> getCurrentPlayersItemPositions() {
        List<Position> result = new ArrayList<>();

        Player currentPlayer = getCurrentPlayer();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Position position = new Position(i, j);

                GameTableCell cellItem = getCellPosition(position);
                if (cellItem != null && cellItem.getOwner().equals(currentPlayer)) {
                    result.add(position);
                }
            }
        }

        return result;
    }
}

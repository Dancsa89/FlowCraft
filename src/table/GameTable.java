package table;

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

    public GameTable() {
        players.add(new Player("Dani"));
        players.add(new Player("Player2"));
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
        GameTableCell unit = gameField[attacker.x][attacker.y];
        GameTableCell victim = gameField[damagable.x][damagable.y];
        if (victim != null && unit != null) {
            gameField[damagable.x][damagable.y] = null;
         /*  int victimsLife = victim.getLife();
           int attackerDamage = unit.getDamage();
           int damage = victimsLife - attackerDamage;
           victim.setLife(damage); */
        } else {
            System.out.println("A cella üres");
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
}

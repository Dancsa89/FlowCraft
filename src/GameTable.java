public class GameTable {

    private final int size = 40;
    private GameTableCell[][] gameField;

    public GameTable() {
        gameField = new GameTableCell[size][size];
      }

    public String toString() {
        String resultArea = "";

        for(int i = 0; i < gameField.length; i++) {
            for(int j = 0; j < gameField[i].length; j++) {
                GameTableCell cell = new GameTableCell();
                resultArea += cell.toString();
            }
            resultArea += "\n";
        }
        return resultArea;
    }
}

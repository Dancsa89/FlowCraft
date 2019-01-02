import table.GameTable;

public class Main {
    public static void main(String[] args) {

     GameTable gameTable = new GameTable();
     System.out.println(gameTable);

     FlowCraftGUI window = new FlowCraftGUI();
     window.setLayout(null);
     window.setVisible(true);
    }
}

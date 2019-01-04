import table.GameTable;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        GameTable gameTable = new GameTable();
        System.out.println(gameTable);

        EventQueue.invokeLater(() -> {
            FlowCraftGUI window = new FlowCraftGUI();
            window.setVisible(true);
        });
    }
}

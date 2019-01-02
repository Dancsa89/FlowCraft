import table.GameTable;

import javax.swing.*;

public class FlowCraftGUI extends JFrame {

    JButton[][] buttons;
    GameTable gameTable = new GameTable();

    public FlowCraftGUI() {
        setTitle("FlowCraft");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 800);
        setLocationRelativeTo(null);

        final int size = 10;

        JPanel content = new JPanel();

        buttons = new JButton[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                JButton btn = new JButton();
                content.add(btn);
                buttons[i][j] = btn;
            }

        }
        add(content);
        drawTable();
    }

    private void drawTable() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setText(gameTable.getCell(i, j).toString());
            }

        }

    }
}

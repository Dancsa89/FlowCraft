import table.GameTable;

import javax.swing.*;
import java.awt.*;

public class FlowCraftGUI extends JFrame {

    GameTable gameTable;
    JButton[][] buttons;

    public FlowCraftGUI() {
        setTitle("FlowCraft");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        /* JPanel root = new JPanel();

        root.setLayout(null);
        add(root); */

        gameTable = new GameTable();
        buttons = new JButton[gameTable.getSize()][gameTable.getSize()];
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                JButton btn = new JButton();
                buttons[i][j] = btn;
                btn.setBounds(
                        10 + j * 12,
                        10 + i * 12,
                        12,
                        12);
                btn.setFont(new Font("Arial", Font.PLAIN, 10));
                btn.getInsets(new Insets(0, 0, 0, 0));
                add(btn);
            }
        }
        drawTable();

     /*   JLabel playerName = new JLabel();
        Player player = new Player("Dani");
        String name = player.getName();
        playerName.setText(name);
        add(playerName); */
    }

    private void drawTable() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setText(gameTable.getCell(i, j).toString());
            }
        }
    }
}

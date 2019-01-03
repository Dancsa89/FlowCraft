import table.GameTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlowCraftGUI extends JFrame implements ActionListener {

    GameTable gameTable;
    JButton[][] buttons;

    public FlowCraftGUI() {
        setTitle("FlowCraft");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        /*JPanel root = new JPanel();

        root.setLayout(null);
        add(root); */

        gameTable = new GameTable();
        buttons = new JButton[gameTable.getSize()][gameTable.getSize()];
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                JButton btn = new JButton();
                buttons[i][j] = btn;
                btn.setBounds(
                        20 + j * 30,
                        20 + i * 30,
                        30,
                        30);
                btn.setFont(new Font("Arial", Font.PLAIN, 15));
                btn.getInsets(new Insets(0, 0, 0, 0));
                add(btn);
                btn.setActionCommand(i + " " + j);
                btn.addActionListener(this);
            }
        }
        drawTable();

        JLabel playerName = new JLabel();
        Player player = new Player("Dani");
        String name = player.getName();
        playerName.setText(name);
        playerName.setFont(new Font("Arial", Font.BOLD, 12));
        playerName.setBounds(800, 5, 80, 80);
        add(playerName);

        JLabel playerStatistics = new JLabel();
        playerStatistics.setText(player.unitsAndBuildings.toString());
        playerStatistics.setBounds(800, 50, 80, 80);
        add(playerStatistics);

        JTextField details = new JTextField();
        details.setBounds(725, 200, 200, 80);

        add(details);
    }

    private void drawTable() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setText(gameTable.getCell(i, j).toString());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent btn) {
        String button = btn.getActionCommand();
        String[] array = button.split(" ");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        if (buttons[a][b] != null) {
            buttons[a][b].setBackground(Color.RED);
            String detalis = gameTable.getCell(a, b).toString();
            System.out.println(detalis);
        }
    }
}

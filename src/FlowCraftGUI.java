import buildings.TownHall;
import species.units.Bowman;
import table.GameTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlowCraftGUI extends JFrame implements ActionListener {

    GameTable gameTable;
    JButton[][] buttons;
    Player player = new Player("Dani");
    JButton attack;
    JButton buyUnit;
    JButton build;
    JButton endRound;

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
                        20 + j * 50,
                        50 + i * 55,
                        50,
                        50);
                btn.setFont(new Font("Arial", Font.BOLD, 15));
                //btn.getInsets(new Insets(0, 0, 0, 0));
                add(btn);
                btn.setActionCommand(i + " " + j);
                btn.addActionListener(this);
            }
        }
        drawTable();

        attack = new JButton();
        attack.setBounds(680,440, 150,40);
        attack.setText("Attack");
        add(attack);

        buyUnit = new JButton();
        buyUnit.setBounds(680,480, 150,40);
        buyUnit.setText("Buy Unit");
        add(buyUnit);

        build = new JButton();
        build.setBounds(680,520, 150,40);
        build.setText("Build");
        add(build);

        endRound = new JButton();
        endRound.setBounds(680,560, 150,40);
        endRound.setText("End Round");
        add(endRound);

        JLabel playerName = new JLabel();
        String name = player.getName();
        playerName.setText(name);
        playerName.setFont(new Font("Arial", Font.BOLD, 12));
        playerName.setBounds(720, 2, 80, 80);
        add(playerName);

        JLabel statistic = new JLabel();
        statistic.setFont(new Font("Arial", Font.BOLD, 12));
        statistic.setBounds(700, 30, 150, 150);
        statistic.setText("Player Statistic");
        add(statistic);

        JTextField playerStatistics = new JTextField();
        playerStatistics.setText(player.unitsAndBuildings.toString());
        playerStatistics.setBounds(550, 120, 410, 100);
        add(playerStatistics);

        JTextField details = new JTextField();
        details.setBounds(550, 300, 410, 100);
        add(details);
    }

    private void drawTable() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setText(gameTable.getCell(i, j).toString());
            }
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent btn) {
        String button = btn.getActionCommand();
        String[] array = button.split(" ");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        if (buttons[a][b] != null) {
           player.addBuilding(gameTable, a, b);
           player.unitsAndBuildings.add(new TownHall());
           drawTable();
        }
    }
}

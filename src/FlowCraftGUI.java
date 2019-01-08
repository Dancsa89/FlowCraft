import interfaces.Player;
import interfaces.Position;
import interfaces.TableContract;
import table.GameTableCell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FlowCraftGUI extends JFrame implements TableContract.View { // VIEW

    private ActionListener actionListener;
    private TableContract.Presenter presenter;
    private JPanel root;
    JButton buyUnit;
    JButton build;
    JButton endRound;

    public FlowCraftGUI() {
        setTitle("FlowCraft");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);

        root = new JPanel();
        root.setLayout(null);
        add(root);

        actionListener = e -> {
            String[] s = e.getActionCommand().split(" ");

            int x = Integer.valueOf(s[0]);
            int y = Integer.valueOf(s[1]);
            System.out.println(x + " " + y);
            presenter.onTableItemClicked(new Position(x, y));
        };

        presenter = new Game(this);

        buyUnit = new JButton();
        buyUnit.setBounds(680,480,150,40);
        buyUnit.setText("Buy Unit");

        root.add(buyUnit);
        buyUnit.setActionCommand("buy");

        build = new JButton();
        build.setBounds(680, 520, 150, 40);
        build.setText("Building");
        root.add(build);
        build.setActionCommand("build");

        endRound = new JButton();
        endRound.setBounds(680, 560, 150, 40);
        endRound.setText("End Round");
        root.add(endRound);
    }

    @Override
    public void showTable(GameTableCell[][] gameField) {
        root.removeAll();

        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                JButton btn = new JButton();

                btn.setActionCommand(i + " " + j);
                btn.addActionListener(actionListener);
                btn.setBounds(
                        20 + j * 50,
                        50 + i * 55,
                        50,
                        50);
                root.add(btn);
                btn.setOpaque(true);
                GameTableCell player = gameField[i][j];
                if (player != null) {
                    btn.setText(player.toString());
                }
            }
        }
    }

    @Override
    public void setSelection(Position position, boolean selection) {
        Component component = root.getComponent(position.x * 10 + position.y);

        component.setBackground(selection ? Color.RED : null);
    }

    @Override
    public void updatePlayer(Position position, GameTableCell unit) {
        JButton btn = (JButton) root.getComponent(position.x * 10 + position.y);

        btn.setText(unit != null ? unit.toString() : null);
    }
}

    /*  gameTable = new GameTable();
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
                btn.getInsets(new Insets(5, 5, 5, 5));
                add(btn);
                btn.setActionCommand(i + " " + j);
                btn.addActionListener(this);
            }
        }
        drawTable(); */

    /*
    private void drawTable() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setText(gameTable.getCell(i, j).toString());
            }
        }
        repaint();
    }

   /* @Override
    public void actionPerformed(ActionEvent btn) {
        String button = btn.getActionCommand();
        String[] array = button.split(" ");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        if (buttons[a][b] != null) {
            gameTable.getCell(a, b).setSelected(true);
            buttons[a][b].setBackground(Color.GREEN);
            if (gameTable.getCell(a, b).isOccupied() && gameTable.getCell(a, b).isUnit()) {

            }
            // player.addBuilding(gameTable, a, b);
           // player.unitsAndBuildings.add(new TownHall());
            drawTable();
        }

 */

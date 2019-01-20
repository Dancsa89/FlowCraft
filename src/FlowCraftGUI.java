import interfaces.Player;
import interfaces.Position;
import interfaces.Range;
import interfaces.TableContract;
import species.units.GameTableCell;
import table.GameTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class FlowCraftGUI extends JFrame implements TableContract.View { // VIEW

    private ActionListener actionListener;
    private TableContract.Presenter presenter;
    private JPanel layoutButtons;
    private JPanel layoutPlayers;
    private JPanel layoutInformations;
    private JTextArea information;

    public FlowCraftGUI() {
        setTitle("FlowCraft");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setLayout(null);
        add(root);

        layoutButtons = new JPanel();
        layoutButtons.setBounds(0, 0, 680, 620);
        layoutButtons.setBackground(Color.LIGHT_GRAY);
        layoutButtons.setLayout(null);
        root.add(layoutButtons);

        layoutPlayers = new JPanel();
        layoutPlayers.setBounds(760, 80, 150, 100);
        layoutPlayers.setBackground(Color.LIGHT_GRAY);
        layoutPlayers.setLayout(new GridLayout(2, 1));
        root.add(layoutPlayers);

      /*  layoutInformations = new JPanel();
        layoutInformations.setBounds(740, 280, 200, 100);
        layoutInformations.setBackground(Color.LIGHT_GRAY);
        layoutInformations.setLayout(new GridLayout(3, 1));
        root.add(layoutInformations); */

        information = new JTextArea();
        information.setBounds(740, 280, 200,100);
        information.setFont(new Font("Helvetcia", Font.PLAIN, 20));
        root.add(information);



        actionListener = e -> {
            String[] s = e.getActionCommand().split(" ");

            int x = Integer.valueOf(s[0]);
            int y = Integer.valueOf(s[1]);
            presenter.onTableItemClicked(new Position(x, y));
        };

        presenter = new Game(this);

    }

    @Override
    public void showTable(GameTableCell[][] gameField) {
        layoutButtons.removeAll();

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
                btn.setBackground(Color.LIGHT_GRAY);
                btn.setOpaque(true);
                layoutButtons.add(btn);
                GameTableCell unitOrBuilding = gameField[i][j];
                if (unitOrBuilding != null) {
                    removeHighlight();
                    btn.setText(unitOrBuilding.toString());
                }
            }
        }
    }

    @Override
    public void showInfo(GameTableCell selectedCell) {
        information.setText(selectedCell.cellInfo());
    }

    @Override
    public void setSelection(Position position, boolean selection) {
        Component component = layoutButtons.getComponent(position.x * 10 + position.y);

        component.setBackground(selection ? Color.RED : null);
    }

    @Override
    public void updateCellItem(Position position, GameTableCell CellItem) {
        JButton btn = (JButton) layoutButtons.getComponent(position.x * 10 + position.y);

        btn.setText(CellItem != null ? CellItem.toString() : null);
    }

    @Override
    public int selectFromList(String[] list) {
        return JOptionPane.showOptionDialog(
                null,
                "What do you want to do, My Lord?",
                "Order",
                0,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                list,
                null);
    }

    @Override
    public int selectFromUnitList(String[] list) {
        return JOptionPane.showOptionDialog(
                null,
                "Which unit do you want to buy?",
                "Units",
                0,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                list,
                null);
    }

    @Override
    public int selectFromBuildingList(String[] list) {
        return JOptionPane.showOptionDialog(
                null,
                "Which building do you want to build?",
                "Buildins",
                0,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                list,
                null);
    }

    @Override
    public void showPlayers(List<Player> players) {
        layoutPlayers.removeAll();

        for (Player player : players) {
            layoutPlayers.add(new Label(player.toString()));
        }
    }

    @Override
    public void selectCurrentPlayer(Player player) {
        for (int i = 0; i < layoutPlayers.getComponentCount(); i++) {
            Label component = (Label) layoutPlayers.getComponent(i);

            if (component.getText().equals(player.toString())) {
                component.setBackground(Color.GREEN);
                component.revalidate();
            } else {
                component.setBackground(null);
                component.revalidate();
            }
        }
        layoutPlayers.repaint();
    }

    @Override
    public void highlightRange(Range range, Position center) {
        for (int i = range.topLeft.x; i <= range.bottomRight.x; i++) {
            for (int j = range.topLeft.y; j <= range.bottomRight.y; j++) {
                if (center == null || center.x == i || center.y == j) {
                    int index = i * 10 + j;
                    ((JButton) layoutButtons.getComponent(index))
                            .setBorder(BorderFactory.createLineBorder(Color.green));
                }
            }
        }
    }

    @Override
    public void removeHighlight() {
        for (int i = 0; i < layoutButtons.getComponentCount(); i++) {
            ((JButton) layoutButtons.getComponent(i))
                    .setBorder(BorderFactory.createLineBorder(Color.white));
        }
    }
}



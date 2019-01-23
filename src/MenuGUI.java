import interfaces.TableContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame implements TableContract.Menu {

    private JButton start;
    private JButton human;
    private JButton orc;
    private JButton goblin;
    private JButton nightElf;
    private JTextField player1;
    private JTextArea welcome;

    public MenuGUI() {
        setTitle("FlowCraft - Menu");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(450, 500);
        setLocationRelativeTo(null);

        JPanel root = new JPanel();
        root.setLayout(null);
        add(root);

        welcome = new JTextArea();
        welcome.setBounds(20, 20, 400, 100);
        welcome.setBackground(Color.lightGray);
        welcome.setLayout(null);
        welcome.setText("Welcome to FlowCraft! \n Please write in youre name, and select specie!");;
        root.add(welcome);

        player1 = new JTextField();
        player1.setBounds(170, 155, 100, 50);
        player1.setText("Player 1");
        root.add(player1);

        start = new JButton();
        start.setText("Player 2");
        start.setBounds(170,400, 100,50);
        start.setActionCommand("start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String start = e.getActionCommand();
                if (start.equals("start")) {
                    getDefaultCloseOperation();
                    MenuGUI2 window = new MenuGUI2();
                    window.setVisible(true);
                }
            }
        });
        root.add(start);

        human = new JButton();
        human.setText("Human");
        human.setBounds(20,300, 100,50);
        root.add(human);

        orc = new JButton();
        orc.setText("Orc");
        orc.setBounds(120,300, 100,50);
        root.add(orc);

        goblin = new JButton();
        goblin.setText("Goblin");
        goblin.setBounds(220,300, 100,50);
        root.add(goblin);

        nightElf = new JButton();
        nightElf.setText("Night Elf");
        nightElf.setBounds(320,300, 100,50);
        root.add(nightElf);
    }
}

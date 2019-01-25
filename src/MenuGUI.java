import interfaces.TableContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame {

    private JButton start;
    private JButton human;
    private JButton orc;
    private JButton goblin;
    private JButton nightElf;
    private JTextField player1;
    private JTextArea welcome;
    private JLabel backGround;
    private int specie;

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
                String command = e.getActionCommand();
                if (command.equals("start")) {
                    getDefaultCloseOperation();
                    setVisible(false);
                    MenuGUI2 window = new MenuGUI2(player1.getText(), specie);
                    window.setVisible(true);
                }
            }
        });
        root.add(start);

        human = new JButton();
        human.setText("Human");
        human.setActionCommand("human");
        human.setBounds(20,300, 100,50);
        human.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("human")) {
                    specie = 1;
                }
            }
        });
        root.add(human);

        orc = new JButton();
        orc.setText("Orc");
        orc.setActionCommand("orc");
        orc.setBounds(120,300, 100,50);
        orc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("orc")) {
                    specie = 2;
                }
            }
        });
        root.add(orc);

        goblin = new JButton();
        goblin.setText("Goblin");
        goblin.setActionCommand("goblin");
        goblin.setBounds(220,300, 100,50);
        goblin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("goblin")) {
                    specie = 3;
                }
            }
        });
        root.add(goblin);

        nightElf = new JButton();
        nightElf.setText("Night Elf");
        nightElf.setActionCommand("nightElf");
        nightElf.setBounds(320,300, 100,50);
        nightElf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("nightElf")) {
                    specie = 4;
                }
            }
        });
        root.add(nightElf);

        backGround = new JLabel();
        backGround.setIcon(new ImageIcon("/home/dani/FlowCraft/src/icons/rsz_pic31810.png"));
        backGround.setBounds(0, 0,450,500);
        backGround.setLayout(null);
        backGround.setOpaque(true);

        root.add(backGround);
    }
}

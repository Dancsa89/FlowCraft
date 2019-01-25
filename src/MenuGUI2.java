import interfaces.Player;
import interfaces.TableContract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI2 extends JFrame {

    private JButton start;
    private JTextField player2;
    private JButton human;
    private JButton orc;
    private JButton goblin;
    private JButton nightElf;
    private JTextArea welcome;
    private JLabel backGround;
    private int specie2;

    public MenuGUI2(String name, int specie) {
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
        welcome.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        welcome.setText("    Welcome to FlowCraft! \n Please write in youre name, \n     and select specie!");
        root.add(welcome);

        player2 = new JTextField();
        player2.setBounds(170, 155, 100, 50);
        player2.setText("Player 2");
        root.add(player2);

        start = new JButton();
        start.setText("Start");
        start.setBounds(170, 400, 100, 50);
        start.setActionCommand("start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String start = e.getActionCommand();
                if (start.equals("start")) {
                    getDefaultCloseOperation();
                    setVisible(false);
                    FlowCraftGUI window = new FlowCraftGUI(name, specie, player2.getText(), specie2);
                    window.setVisible(true);
                }
            }
        });
        root.add(start);

        human = new JButton();
        human.setText("Human");
        human.setActionCommand("human");
        human.setBounds(20, 300, 100, 50);
        human.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("human")) {
                    specie2 = 1;
                }
            }
        });
        root.add(human);

        orc = new JButton();
        orc.setText("Orc");
        orc.setActionCommand("orc");
        orc.setBounds(120, 300, 100, 50);
        orc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("orc")) {
                    specie2 = 2;
                }
            }
        });
        root.add(orc);

        goblin = new JButton();
        goblin.setText("Goblin");
        goblin.setActionCommand("goblin");
        goblin.setBounds(220, 300, 100, 50);
        goblin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("goblin")) {
                    specie2 = 3;
                }
            }
        });
        root.add(goblin);

        nightElf = new JButton();
        nightElf.setText("Night Elf");
        nightElf.setActionCommand("nightElf");
        nightElf.setBounds(320, 300, 100, 50);
        nightElf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                if (command.equals("nightElf")) {
                    specie2 = 4;
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


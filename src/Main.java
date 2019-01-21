import table.GameTable;

import java.awt.*;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            FlowCraftGUI window = new FlowCraftGUI();
            window.setVisible(true);
        });
    }
}

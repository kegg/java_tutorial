package javaTutorial;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        Main main = new Main();
        main.setSize(500,300);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    public Main() {
        DefaultComboBoxModel<Item> cbo = new DefaultComboBoxModel<>();
        cbo.addElement(new Item(1, "John Smith"));
        cbo.addElement(new Item(2, "Susan Jones"));
        JComboBox<Item> box = new JComboBox<>(cbo);
        add(box, BorderLayout.NORTH);
    }
}

package javaTutorial;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        Main main = new Main();
        main.setSize(500,500);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    public Main() {
        Vector<Item> items = new Vector<>();
        items.add(new Item(1, "John Smith"));
        items.add(new Item(2, "Susan Jones"));
        JComboBox box = new JComboBox(items);
        add(box, BorderLayout.NORTH);
    }
}

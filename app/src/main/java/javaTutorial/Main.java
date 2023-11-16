package javaTutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Main extends JFrame implements ActionListener {

    private JComboBox box;

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
        box = new JComboBox(items);
        JButton button = new JButton("Execute");
        button.addActionListener(this);
        add(box, BorderLayout.NORTH);
        add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((Item) box.getSelectedItem()).getId());
    }
}

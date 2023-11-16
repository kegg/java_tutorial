package javaTutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    private JComboBox<Item> box;
    private JTextArea textarea;

    public static void main(String[] args) {
        Main main = new Main();
        main.setTitle("Testing Combo Box");
        main.setSize(500,300);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    public Main() {
        DefaultComboBoxModel<Item> cbo = new DefaultComboBoxModel<>();
        cbo.addElement(new Item(1, "John Smith"));
        cbo.addElement(new Item(2, "Susan Jones"));
        box = new JComboBox<>(cbo);
        JButton button = new JButton("Get Data");
        button.setActionCommand("press");
        button.addActionListener(this);
        textarea = new JTextArea();
        add(box, BorderLayout.NORTH);
        add(textarea, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("press")) {
            long id = ((Item) box.getSelectedItem()).getId();
            String name = ((Item) box.getSelectedItem()).toString();
            textarea.setText("ID: " + id + "\n" + "Name: " + name);
        }
    }
}

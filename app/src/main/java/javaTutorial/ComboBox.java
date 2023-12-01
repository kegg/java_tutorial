package javaTutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBox extends JFrame implements ActionListener {

    private final JComboBox<Item> box;
    private final JTextArea textarea;

    public ComboBox() {
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
        setTitle("Testing Combo Box");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("press")) {
            long id = ((Item) box.getSelectedItem()).getId();
            String name = (box.getSelectedItem()).toString();
            textarea.setText("ID: " + id + "\n" + "Name: " + name);
        }
    }
}

package javaTutorial.comboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ComboBox extends JFrame implements ActionListener {

    private final JComboBox<Item> box;
    private final JTextArea textarea;

    public ComboBox() {
        DefaultComboBoxModel<Item> cbo = new DefaultComboBoxModel<>();
        cbo.addElement(new Item(1, "John Smith"));
        cbo.addElement(new Item(2, "Susan Jones"));
        cbo.addElement(new Item(3, "Joan Smith"));
        cbo.addElement(new Item(4, "Jeffrey Dahmar"));
        box = new JComboBox<>(cbo);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JButton button = new JButton("Get Data");
        buttonPanel.add(button);
        button.setActionCommand("press");
        button.addActionListener(this);
        textarea = new JTextArea();
        add(box, BorderLayout.NORTH);
        add(textarea, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setTitle("Testing Combo Box");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("press")) {
            long id = ((Item) Objects.requireNonNull(box.getSelectedItem())).getId();
            String name = (box.getSelectedItem()).toString();
            textarea.setText("ID: " + id + "\n" + "Name: " + name);
        }
    }
}

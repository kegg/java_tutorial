package javaTutorial.names;

import javaTutorial.utils.ResourceUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class NameGenerator extends JFrame {

    private List<String> surnames;
    private List<String> firstNames;

    public NameGenerator() {
        super();
        init();
        buildFrame();
        pack();
        setVisible(true);
    }

    private void buildFrame() {
        setTitle("Name Generator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 100);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JTextField firstName = new JTextField(10);
        JTextField lastName = new JTextField(10);
        panel.add(new JLabel("First Name"));
        panel.add(firstName);
        panel.add(new JLabel("Surname"));
        panel.add(lastName);
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = getButtonPanel(firstName, lastName);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel getButtonPanel(JTextField firstName, JTextField lastName) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(e->{
            Random rand = new Random();
            firstName.setText(firstNames.get(rand.nextInt(firstNames.size())));
            lastName.setText(surnames.get(rand.nextInt(surnames.size())));
        });
        buttonPanel.add(generateButton);
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e->this.dispose());
        buttonPanel.add(closeButton);
        return buttonPanel;
    }

    private void init() {
        surnames = ResourceUtil.readFileAsList("surname.txt");
        firstNames = ResourceUtil.readFileAsList("first.txt");
    }
}

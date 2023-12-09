package javaTutorial.radios;

import javax.swing.*;
import java.awt.*;

public class RadioButtons extends JFrame {

    public RadioButtons() {
        super();
        init();
        buildForm();
        setVisible(true);
    }

    private void buildForm() {
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioButton = new JRadioButton("One", true);
        buttonGroup.add(radioButton);

        JRadioButton radioButton1 = new JRadioButton("Two");
        buttonGroup.add(radioButton1);

        JPanel panel = new JPanel(new GridLayout(2,1));
        panel.add(radioButton);
        panel.add(radioButton1);

        JPanel mainPanel = new JPanel();
        mainPanel.add(panel);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void init() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}

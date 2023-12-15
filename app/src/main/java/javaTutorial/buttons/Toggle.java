package javaTutorial.buttons;

import javax.swing.*;
import java.awt.*;

public class Toggle extends JDialog {

    public Toggle() {
        super();
        init();
        buildForm();
        setVisible(true);
    }

    private void buildForm() {
        ButtonGroup buttonGroup = new ButtonGroup();

        JToggleButton toggleButton1 = new JToggleButton("One");
        buttonGroup.add(toggleButton1);

        JToggleButton toggleButton2 = new JToggleButton("Two");
        buttonGroup.add(toggleButton2);

        JToggleButton toggleButton3 = new JToggleButton("Three");
        buttonGroup.add(toggleButton3);

        JToggleButton toggleButton4 = new JToggleButton("Four");
        buttonGroup.add(toggleButton4);

        JPanel panel = new JPanel(new GridLayout(4,1));
        panel.add(toggleButton1);
        panel.add(toggleButton2);
        panel.add(toggleButton3);
        panel.add(toggleButton4);

        JPanel mainPanel = new JPanel();
        mainPanel.add(panel);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void init() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}

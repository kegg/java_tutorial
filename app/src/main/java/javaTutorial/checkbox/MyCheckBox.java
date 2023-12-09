package javaTutorial.checkbox;

import javax.swing.*;
import java.awt.*;

public class MyCheckBox extends JFrame {

    public MyCheckBox() {
        super();
        init();
        buildForm();
        setVisible(true);
    }

    private void buildForm() {
        ButtonGroup buttonGroup = new ButtonGroup();

        JCheckBox jCheckBox = new JCheckBox("What?", true);
        buttonGroup.add(jCheckBox);

        JCheckBox jCheckBox1 = new JCheckBox("Who?");
        buttonGroup.add(jCheckBox1);

        JPanel panel = new JPanel(new GridLayout(2,1));
        panel.add(jCheckBox);
        panel.add(jCheckBox1);

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

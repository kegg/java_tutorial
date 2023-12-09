package javaTutorial.layouts;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioCard extends JFrame implements ActionListener {

    JPanel cards;
    CardLayout cl;
    ButtonGroup buttonGroup;

    public RadioCard() {
        init();
        buildInterface();
        setVisible(true);
    }

    private void buildInterface() {
        createLeftPane();
        createRightPane();
    }

    private void createRightPane() {
        cl = new CardLayout(30, 30);
        cards = new JPanel(cl);

        cards.add(buildLabel("Let's talk about life.",
                        "12/4/2023 - 11:00"),
                "Label 0");
        cards.add(buildLabel("Life is rough.",
                        "12/5/2023 - 12:00"),
                "Label 5");
        cards.add(buildLabel("Like really rough.",
                        "12/6/2023 - 13:01"),
                "Label 10");
        cards.add(buildLabel("You don't even know how rough it can be, until you've lived it.",
                        "12/7/2023 - 21:10"),
                "Label 15");
        cards.add(buildLabel("Noises to make the most sane of men scream in their minds.",
                        "12/7/2023 - 21:13"),
                "Label 20");
        cards.add(buildLabel("Sometimes you hide just to get away from it.",
                        "12/7/2023 - 21:20"),
                "Label 25");
        cards.add(buildLabel("Not everyone has the same background.",
                        "12/8/2023 - 22:01"),
                "Label 26");
        add(cards, BorderLayout.CENTER);
    }

    private void createLeftPane() {
        JPanel pane = new JPanel(new GridLayout(3,1));
        buttonGroup = new ButtonGroup();
        JRadioButton radioButton = new JRadioButton("Card 1", true);
        radioButton.setActionCommand("card1");

        buttonGroup.add(radioButton);
        pane.add(radioButton);

        radioButton = new JRadioButton("Card 2", false);
        radioButton.setActionCommand("card2");

        buttonGroup.add(radioButton);
        pane.add(radioButton);

        JButton button = new JButton("Select");
        button.setActionCommand("button");
        button.addActionListener(this);

        pane.add(button);

        JPanel mainPane = new JPanel();
        mainPane.add(pane);
        add(mainPane, BorderLayout.WEST);
    }

    private JLabel buildLabel(String text, String date) {
        JLabel label = new JLabel(text);
        label.setBorder(new TitledBorder(date));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private void init() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("button")) {
            if (buttonGroup.getSelection().getActionCommand().equals("card1")) {
                cl.show(cards, "Label 0");
            } else {
                cl.show(cards, "Label 5");
            }
        }
    }
}

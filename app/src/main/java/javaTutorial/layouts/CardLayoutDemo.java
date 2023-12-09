package javaTutorial.layouts;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CardLayoutDemo  extends JFrame {

    private final JPanel cards;

    public CardLayoutDemo() {
        super();
        setTitle("Thoughts");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        CardLayout cardLayout = new CardLayout(30, 30);
        cards = new JPanel(cardLayout);

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

        JPanel buttonPanel = getButtonPanel(cardLayout);

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private JPanel getButtonPanel(CardLayout cardLayout) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        JButton prevButton = new JButton("Prev");
        prevButton.addActionListener(e-> cardLayout.previous(cards));
        buttonPanel.add(prevButton);
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e-> cardLayout.next(cards));
        buttonPanel.add(nextButton);
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e->this.dispose());
        buttonPanel.add(closeButton);
        return buttonPanel;
    }

    private JLabel buildLabel(String text, String date) {
        JLabel label = new JLabel(text);
        label.setBorder(new TitledBorder(date));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
}

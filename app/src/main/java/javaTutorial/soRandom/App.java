package javaTutorial.soRandom;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class App extends JFrame {

    private final JTextArea textArea = new JTextArea();

    public App() {
        super("App");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addTextArea();
        addButtonPane();
        setVisible(true);
    }

    private void addButtonPane() {
        JPanel panel = new JPanel();
        JButton button = new JButton("Begin Trace");
        button.addActionListener(e -> new Thread(() -> {
            textArea.setForeground(Color.GREEN);
            button.setEnabled(false);
            int i = 0;
            int percent = 0;
            while (i <= 50) {
                try {
                    percent += 10;
                    String str = String.format("%-20s %5d%% %5d %5d %5d %5d%n",
                            "Tracing: ",
                            (percent / 50) * 10,
                            new Random().nextInt(1000),
                            new Random().nextInt(1000),
                            new Random().nextInt(1000),
                            new Random().nextInt(1000));
                    textArea.append(str);
                    textArea.setCaretPosition(textArea.getText().length());
                    Thread.sleep(50);
                } catch (Exception ignored) {

                }
                i++;
            }
            textArea.setForeground(Color.RED);
            textArea.append(String.format("%20s%n", "LOCKED"));
            while (i < 2000) {
                try {
                    if (textArea.getForeground() == Color.YELLOW) {
                        textArea.setForeground(Color.RED);
                    } else {
                        textArea.setForeground(Color.YELLOW);
                    }
                    Thread.sleep(500);
                } catch (Exception ignored) {

                }
                i++;
            }
        }).start());
        panel.add(button);
        add(panel, BorderLayout.NORTH);
    }

    private void addTextArea() {
        textArea.setMargin(new Insets(10, 10, 10, 10));
        textArea.setFont(new Font("Courier New", Font.BOLD, 14));
        textArea.setForeground(Color.GREEN);
        textArea.setBackground(Color.BLACK);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

}

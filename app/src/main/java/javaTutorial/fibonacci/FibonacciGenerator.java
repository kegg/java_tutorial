package javaTutorial.fibonacci;

import javax.swing.*;
import java.awt.*;

public class FibonacciGenerator extends JFrame {

    public FibonacciGenerator() {
        super();
        setTitle("Fibonacci Generator");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setText(generateFibonacci());
        textArea.setCaretPosition(0);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String generateFibonacci() {
        StringBuilder sb = new StringBuilder();

        int i, j, k;

        i = 0;
        j = 1;

        do {
            sb.append(i).append("\n");

            k = i + j;
            i = j;
            j = k;
        } while (i < 255);
        return sb.toString();
    }
}

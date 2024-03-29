/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaTutorial;

import com.formdev.flatlaf.FlatDarkLaf;
import javaTutorial.buttons.Toggle;
import javaTutorial.checkbox.MyCheckBox;
import javaTutorial.comboBox.ComboBox;
import javaTutorial.fibonacci.FibonacciGenerator;
import javaTutorial.layouts.CardLayoutDemo;
import javaTutorial.layouts.RadioCard;
import javaTutorial.names.NameGenerator;
import javaTutorial.radios.RadioButtons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

public class App extends JFrame {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        App app = new App();
        app.setVisible(true);
    }

    public App() {
        setTitle("Test Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setJMenuBar(createMenuBar());
        JPanel mainPanel = createMainPanel();
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem fileItem = new JMenuItem("Exit");
        fileItem.setMnemonic(KeyEvent.VK_X);
        fileItem.addActionListener(e->System.exit(0));
        fileMenu.add(fileItem);

        menuBar.add(fileMenu);
        return menuBar;
    }

    private JPanel createMainPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton comboBoxBtn = new JButton("ComboBox");
        comboBoxBtn.addActionListener(e->new ComboBox());
        panel.add(comboBoxBtn);

        JButton nameGeneratorBtn = new JButton("Name Generator");
        nameGeneratorBtn.addActionListener(e->new NameGenerator());
        panel.add(nameGeneratorBtn);

        JButton fibonacciBtn = new JButton("Fibonacci Sequence");
        fibonacciBtn.addActionListener(e->new FibonacciGenerator());
        panel.add(fibonacciBtn);

        JLabel toggleLabel = new JLabel("JToggle Button");
        toggleLabel.setVisible(false);

        JToggleButton toggleButton = new JToggleButton("Hello World!");
        toggleButton.addItemListener(e->{
            if (e.getStateChange() == ItemEvent.DESELECTED) {
                toggleLabel.setVisible(false);
            } else if (e.getStateChange() == ItemEvent.SELECTED) {
                toggleLabel.setVisible(true);
            }
        });
        panel.add(toggleLabel);
        panel.add(toggleButton);

        JButton cardLayoutButton = new JButton("Card Layout");
        cardLayoutButton.addActionListener(e->new CardLayoutDemo());
        panel.add(cardLayoutButton);

        JButton radioButton = new JButton("Radio Buttons");
        radioButton.addActionListener(e->new RadioButtons());
        panel.add(radioButton);

        JButton checkBox = new JButton("Checkboxes in Group");
        checkBox.addActionListener(e->new MyCheckBox());
        panel.add(checkBox);

        JButton radioCard = new JButton("Radio Buttons Controlling Cards");
        radioCard.addActionListener(e->new RadioCard());
        panel.add(radioCard);

        JButton toggleGroup = new JButton("Toggle Group");
        toggleGroup.addActionListener(e->new Toggle());
        panel.add(toggleGroup);

        JButton soRandom = new JButton("So Random");
        soRandom.addActionListener(e->new javaTutorial.soRandom.App());
        panel.add(soRandom);

        return panel;
    }
}

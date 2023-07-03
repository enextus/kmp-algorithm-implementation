import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KMPApplication {

    public KMPApplication() {
        KMP kmp = new KMP();

        JFrame frame = new JFrame("KMP Algorithm");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, kmp);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, KMP kmp) {

        panel.setLayout(null);

        JLabel textLabel = new JLabel("Enter text:");
        textLabel.setBounds(10, 10, 80, 25);
        panel.add(textLabel);

        JTextField textInput = new JTextField(20);
        textInput.setBounds(100, 10, 160, 25);
        panel.add(textInput);

        JLabel patternLabel = new JLabel("Enter pattern:");
        patternLabel.setBounds(10, 40, 80, 25);
        panel.add(patternLabel);

        JTextField patternInput = new JTextField(20);
        patternInput.setBounds(100, 40, 160, 25);
        panel.add(patternInput);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(10, 80, 80, 25);
        panel.add(searchButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(100, 80, 300, 25);
        panel.add(resultLabel);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String pattern = patternInput.getText();
                boolean result = kmp.KMPAlgorithm(text, pattern);
                resultLabel.setText("Match found: " + result);
            }
        });
    }
}

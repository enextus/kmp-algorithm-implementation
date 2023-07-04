import javax.swing.*;

public class KMPApplication {
    private static final int FRAME_WIDTH = 430;
    private static final int FRAME_HEIGHT = 160;
    private static final int TEXT_FIELD_LENGTH = 10;
    private static final int X_LABEL_POSITION = 10;
    private static final int Y_TEXT_LABEL_POSITION = 10;
    private static final int Y_PATTERN_LABEL_POSITION = 40;
    private static final int X_INPUT_POSITION = 100;
    private static final int Y_BUTTON_POSITION = 80;
    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 25;
    private static final int X_RESULT_LABEL_POSITION = 100;
    private static final int Y_RESULT_LABEL_POSITION = 80;
    private static final int RESULT_LABEL_WIDTH = 300;
    private static final int RESULT_LABEL_HEIGHT = 25;

    public KMPApplication() {
        KMP kmp = new KMP();

        JFrame frame = new JFrame("KMP Algorithm");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel, kmp);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel, KMP kmp) {

        panel.setLayout(null);

        JLabel textLabel = new JLabel("Enter text:");
        textLabel.setBounds(X_LABEL_POSITION, Y_TEXT_LABEL_POSITION, BUTTON_WIDTH, BUTTON_HEIGHT);
        panel.add(textLabel);

        JTextField textInput = new JTextField(TEXT_FIELD_LENGTH);
        textInput.setBounds(X_INPUT_POSITION, Y_TEXT_LABEL_POSITION, RESULT_LABEL_WIDTH, BUTTON_HEIGHT);
        panel.add(textInput);

        JLabel patternLabel = new JLabel("Enter pattern:");
        patternLabel.setBounds(X_LABEL_POSITION, Y_PATTERN_LABEL_POSITION, BUTTON_WIDTH, BUTTON_HEIGHT);
        panel.add(patternLabel);

        JTextField patternInput = new JTextField(TEXT_FIELD_LENGTH);
        patternInput.setBounds(X_INPUT_POSITION, Y_PATTERN_LABEL_POSITION, RESULT_LABEL_WIDTH, BUTTON_HEIGHT);
        panel.add(patternInput);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(X_LABEL_POSITION, Y_BUTTON_POSITION, BUTTON_WIDTH, BUTTON_HEIGHT);
        panel.add(searchButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(X_RESULT_LABEL_POSITION, Y_RESULT_LABEL_POSITION, RESULT_LABEL_WIDTH, RESULT_LABEL_HEIGHT);
        panel.add(resultLabel);

        searchButton.addActionListener(e -> {
            String text = textInput.getText();
            String pattern = patternInput.getText();
            boolean result = kmp.KMPAlgorithm(text, pattern);
            resultLabel.setText("Match found: " + result);
        });
    }
}

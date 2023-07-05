package app;

import javax.swing.*;
import java.awt.*;

/**
 * This class is a GUI application for the Knuth-Morris-Pratt (KMP) algorithm.
 * It creates a simple interface allowing users to enter a text and a pattern
 * to check whether the pattern exists in the text.
 */
public class KMPApplication {
    // The number of rows in the text area
    private static final int TEXT_AREA_ROWS = 40;

    // The factor to calculate the height of the scroll pane
    private static final int SCROLL_PANE_HEIGHT_FACTOR = 20;
    // Dimensions of the main application window
    private static final int FRAME_WIDTH = 450;

    //
    private static final int FRAME_HEIGHT = 700;

    // The length of the text fields for user input
    private static final int TEXT_FIELD_LENGTH = 50;

    // The x-position for the labels
    private static final int X_LABEL_POSITION = 10;

    // The y-positions for the 'text' and 'pattern' labels
    private static final int Y_TEXT_LABEL_POSITION = 30;

    //
    private static final int Y_PATTERN_LABEL_POSITION = 550;

    // The x-position for the input fields
    private static final int X_INPUT_POSITION = 120;

    // The y-position for the search button
    private static final int Y_BUTTON_POSITION = 610;
    private static final int X_BUTTON_POSITION = 120;

    // Dimensions for the button
    private static final int BUTTON_WIDTH = 280;
    private static final int BUTTON_HEIGHT = 25;

    // The position for the result label
    private static final int X_RESULT_LABEL_POSITION = 210;
    private static final int Y_RESULT_LABEL_POSITION = 580;

    // Dimensions for the result label
    private static final int RESULT_LABEL_WIDTH = 280;
    private static final int RESULT_LABEL_HEIGHT = 25;

    /**
     * The constructor initializes the GUI and sets its layout.
     */
    public KMPApplication() {
        // Create a new instance of the KMP algorithm class
        KMP kmp = new KMP();

        // Create a new JFrame, set its title to 'app.KMP Algorithm'
        JFrame frame = new JFrame("app.KMP Algorithm");

        // Set the size of the frame using predefined width and height
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        // Set the default close operation. In this case, the application will terminate when the JFrame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JPanel to hold the components
        JPanel panel = new JPanel();

        // Add the panel to the frame
        frame.add(panel);

        // Call the placeComponents method to add components to the panel
        // Pass the panel and KMP instance to the method
        placeComponents(panel, kmp);

        // Set the frame to be visible
        frame.setVisible(true);
    }


    /**
     * This method sets up the components of the GUI.
     *
     * @param panel The panel on which the components are placed.
     * @param kmp   The KMP object which implements the KMP algorithm.
     */
    private void placeComponents(JPanel panel, KMP kmp) {

        //
        panel.setLayout(null);

        // Creates a label with instructions for the text input
        JLabel textLabel = new JLabel("Enter text:");
        // Sets the position and size of the text label
        textLabel.setBounds(X_LABEL_POSITION, Y_TEXT_LABEL_POSITION, BUTTON_WIDTH, BUTTON_HEIGHT);
        // Adds the text label to the panel
        panel.add(textLabel);

        // Creates a text area for the user's input text
        JTextArea textInput = new JTextArea(TEXT_AREA_ROWS, TEXT_FIELD_LENGTH);
        // Sets line wrap to true
        textInput.setLineWrap(true);

        // Creates a scroll pane for the text area
        JScrollPane scrollPane = new JScrollPane(textInput);
        // Sets the position and size of the scroll pane
        scrollPane.setBounds(X_INPUT_POSITION, Y_TEXT_LABEL_POSITION, RESULT_LABEL_WIDTH, SCROLL_PANE_HEIGHT_FACTOR * BUTTON_HEIGHT); // height is adjusted to accommodate 50 lines

        // Adds the scroll pane (containing the text area) to the panel
        panel.add(scrollPane);


        // Creates a label with instructions for the pattern input
        JLabel patternLabel = new JLabel("Enter pattern:");
        // Sets the position and size of the pattern label
        patternLabel.setBounds(X_LABEL_POSITION, Y_PATTERN_LABEL_POSITION, BUTTON_WIDTH, BUTTON_HEIGHT);
        // Adds the pattern label to the panel
        panel.add(patternLabel);

        // Creates a text field for the user's input pattern
        JTextField patternInput = new JTextField(TEXT_FIELD_LENGTH);
        // Sets the position and size of the pattern input field
        patternInput.setBounds(X_INPUT_POSITION, Y_PATTERN_LABEL_POSITION, RESULT_LABEL_WIDTH, BUTTON_HEIGHT);
        // Adds the pattern input field to the panel
        panel.add(patternInput);

        // Creates a search button
        JButton searchButton = new JButton("Search");
        // Sets the position and size of the search button
        searchButton.setBounds(X_BUTTON_POSITION, Y_BUTTON_POSITION, BUTTON_WIDTH, BUTTON_HEIGHT);
        // Adds the search button to the panel
        panel.add(searchButton);

        // Creates a label to display the result
        JLabel resultLabel = new JLabel("");
        // Sets the position and size of the result label
        resultLabel.setBounds(X_RESULT_LABEL_POSITION, Y_RESULT_LABEL_POSITION, RESULT_LABEL_WIDTH, RESULT_LABEL_HEIGHT);
        // Adds the result label to the panel
        panel.add(resultLabel);

        // Defines the action to be performed when the search button is clicked
        // It retrieves the text and pattern from the input fields, performs the KMP algorithm,
        // and updates the result label with the result
        searchButton.addActionListener(e -> {
            String text = textInput.getText();
            String pattern = patternInput.getText();
            boolean result = kmp.KMPAlgorithm(text, pattern);
            resultLabel.setText("Match found: " + result);

            // If the result is true, set the result label text color to green, else set it to red
            if(result) {
                resultLabel.setForeground(Color.GREEN);
            } else {
                resultLabel.setForeground(Color.RED);
            }
        });

    }


}

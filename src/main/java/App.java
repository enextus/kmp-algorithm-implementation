// Import the KMPApplication class
import app.KMPApplication;

// Import the SwingUtilities class from the javax.swing package
import javax.swing.SwingUtilities;

// This is the main class that runs the application
public class App {
    // This is the main method, which is the entry point for the application
    public static void main(String[] args) {
        // The invokeLater method of the SwingUtilities class is used to ensure that the GUI creation
        // occurs on the Event Dispatch Thread, which is the thread where all GUI related actions should take place
        // It takes a runnable, in this case a method reference to the KMPApplication constructor,
        // which is where the GUI is created and shown
        SwingUtilities.invokeLater(KMPApplication::new);
    }
}

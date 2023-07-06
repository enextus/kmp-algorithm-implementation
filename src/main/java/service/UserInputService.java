package service;

public class UserInputService {

    /**
     * Validates the user input based on the application's requirements.
     *
     * @param userInput The input provided by the user.
     * @return The validated user input if it's valid, otherwise returns null.
     */
    public String getValidatedUserInput(String userInput) {
        if (isInputAllowed(userInput)) {
            return userInput;
        } else {
            System.out.println("Invalid input: " + userInput);
            return null;
        }
    }

    /**
     * Checks if the user input meets the application's requirements.
     *
     * @param userInput The input provided by the user.
     * @return True if the input is allowed, otherwise returns false.
     */
    public boolean isInputAllowed(String userInput) {
        // An example of a simple validation could be checking if the input is not null or empty
        return userInput != null && !userInput.trim().isEmpty();
    }

    /**
     * Processes the user input based on the application's logic.
     *
     * @param userInput The input provided by the user.
     * @return The processed user input if it's valid, otherwise returns null.
     */
    public String processUserInput(String userInput) {
        // In this example, processing the input could mean simply validating it and returning the result
        return getValidatedUserInput(userInput);
    }
}

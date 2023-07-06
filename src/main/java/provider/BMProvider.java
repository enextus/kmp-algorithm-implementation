package provider;

import java.util.Arrays;

/**
 * This class implements the Boyer-Moore algorithm for substring search.
 * The Boyer-Moore algorithm searches for occurrences of a "word" pattern within a main "text" string.
 */
public class BMProvider {

    // The number of unique characters in the text
    private static final int NO_OF_CHARS = Character.MAX_VALUE + 1;  // Don't change this line

    /**
     * This method pre-processes the pattern and creates an array of size NO_OF_CHARS
     * where value at index i indicates the shift occurring if the character is present at an index in the pattern
     *
     * @param pattern The pattern for which the shift array is to be computed.
     * @return The shift array.
     */
    public int[] createShiftArray(String pattern) {
        int m = pattern.length();
        int[] shiftArray = new int[NO_OF_CHARS];

        // Initialize all values in array as the length of the pattern
        Arrays.fill(shiftArray, m);

        // Then update the actual shift according to the pattern
        for (int i = 0; i < m; i++) {
            shiftArray[pattern.charAt(i)] = m - 1 - i;
        }

        return shiftArray;
    }

    /**
     * This method implements the Boyer-Moore algorithm.
     *
     * @param text    The text to search within.
     * @param pattern The pattern to search for.
     * @return True if the pattern is found in the text, else false.
     */
    public boolean BMAlgorithm(String text, String pattern) {

        int m = pattern.length();
        int n = text.length();

        if (m == 0) return true;
        if (m > n) return false;

        int[] shiftArray = createShiftArray(pattern);

        int shift = 0; // shift of the pattern with respect to text

        while (shift <= (n - m)) {
            int j = m - 1;

            // reduce index j of pattern while characters of pattern and text are matching at this shift
            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j))
                j--;

            // if the pattern is present at current shift, then index j will become -1
            if (j < 0) {
                return true;
            } else {
                // Shift the pattern so that the bad character in text aligns with the last occurrence of it in pattern.
                // the max function is used to make sure that we get a positive shift
                // we may get a negative shift if the last occurrence of bad character in pattern is on the right side of the current character.
                shift += Math.max(1, j - shiftArray[text.charAt(shift + j)]);
            }
        }

        return false;
    }

}

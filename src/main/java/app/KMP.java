package app;

/**
 * This class implements the Knuth-Morris-Pratt (KMP) algorithm for substring search.
 * The KMP algorithm searches for occurrences of a "word" pattern within a main "text" string.
 */
public class KMP {

    /**
     * This method computes the prefix array which is used in KMP algorithm.
     *
     * @param pattern The pattern for which the prefix array is to be computed.
     * @return The prefix array.
     */
    public int[] computePrefixArray(String pattern) {

        int[] prefixArray = new int[pattern.length()];
        int j = 0;

        // iterate over the pattern string
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                prefixArray[i] = j + 1;
                j++;
            } else if (j > 0) {
                j = prefixArray[j - 1];
                i--;
            }
        }

        return prefixArray;
    }

    /**
     * This method implements the KMP algorithm.
     *
     * @param text    The text to search within.
     * @param pattern The pattern to search for.
     * @return True if the pattern is found in the text, else false.
     */
    public boolean KMPAlgorithm(String text, String pattern) {

        // If pattern is empty, return true as empty string is part of any text
        if (pattern.isEmpty()) return true;

        int[] prefixArray = computePrefixArray(pattern);
        int j = 0;

        // iterate over the text string
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) return true; // entire pattern is found
                j++;
            } else if (j > 0) {
                j = prefixArray[j - 1];
                i--;
            }
        }

        // If the pattern is not found in the text
        return false;
    }

}

// Import the KMP class from app package
import app.KMP;

// Import classes for unit testing
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Define the test class KMPTest
class KMPTest {

    // Test the computePrefixArray method in the KMP class
    @Test
    void computePrefixArrayTest() {
        // Initialize an instance of the KMP class
        KMP kmp = new KMP();

        // Assert that the method returns correct prefix arrays
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, kmp.computePrefixArray("abcde"));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, kmp.computePrefixArray("aaaaa"));
    }

    // Additional test for the computePrefixArray method
    // This test ensures that for each prefix length in the pattern, the prefix matches the suffix
    @Test
    public void OtherComputePrefixArrayTest() {
        // Initialize an instance of the KMP class
        KMP kmp = new KMP();

        // Define a test pattern
        String pattern = "abcdabcda";
        int[] prefixArray = kmp.computePrefixArray(pattern);

        // Test if the prefix matches the suffix for each prefix length in the pattern
        for (int i = 0; i < pattern.length(); i++) {
            String expectedPrefix = pattern.substring(0, prefixArray[i]);
            String actualSuffix = pattern.substring(i - prefixArray[i] + 1, i + 1);

            assertEquals(expectedPrefix, actualSuffix);
        }
    }

    // Test the KMPAlgorithm method in the KMP class
    @Test
    void KMPAlgorithmTest() {
        // Initialize an instance of the KMP class
        KMP kmp = new KMP();

        // Assert that the method correctly finds the pattern in the text
        assertTrue(kmp.KMPAlgorithm("abcdabcda", "abcda"));
        assertFalse(kmp.KMPAlgorithm("abcdabcda", "abcdef"));
        assertTrue(kmp.KMPAlgorithm("aaaaa", "aaa"));
    }

    // Test KMPAlgorithm method when the pattern is found at the beginning of the text
    @Test
    public void testKMPAlgorithm_FoundAtBeginning() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("abcdabcda", "abcd"));
    }

    // Test KMPAlgorithm method when the pattern is found at the end of the text
    @Test
    public void testKMPAlgorithm_FoundAtEnd() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("abcdabcda", "abcda"));
    }

    // Test KMPAlgorithm method when the pattern is found in the middle of the text
    @Test
    public void testKMPAlgorithm_FoundInMiddle() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("abcdabcda", "dabc"));
    }

    // Test KMPAlgorithm method when the pattern is not found in the text
    @Test
    public void testKMPAlgorithm_NotFound() {
        KMP kmp = new KMP();
        assertFalse(kmp.KMPAlgorithm("abcdabcda", "efg"));
    }

    // Test KMPAlgorithm method when the pattern is empty
    @Test
    public void testKMPAlgorithm_EmptyPattern() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("abcdabcda", ""));
    }

    // Test KMPAlgorithm method when the text is empty
    @Test
    public void testKMPAlgorithm_EmptyText() {
        KMP kmp = new KMP();
        assertFalse(kmp.KMPAlgorithm("", "abc"));
    }
    @Test
    void testWithLongStrings() {
        KMP kmp = new KMP();
        String longText = "a".repeat(1000000) + "b";
        String longPattern = "a".repeat(1000000);

        assertTrue(kmp.KMPAlgorithm(longText, longPattern));
    }

    @Test
    void testWithSpecialCharacters() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("hello, world!", ", world"));
    }

    @Test
    void testWithUnicode() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("Привет, мир!", "мир"));
    }

    @Test
    void testWithEmptyInputs() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("", ""));
    }

    @Test
    void testWithMultipleMatches() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("abc abc abc", "abc"));
    }

    @Test
    void testWithCaseSensitivity() {
        KMP kmp = new KMP();
        assertFalse(kmp.KMPAlgorithm("ABC", "abc"));
    }

}

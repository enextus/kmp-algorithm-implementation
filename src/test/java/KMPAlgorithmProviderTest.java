// Import the KMPAlgorithmProvider class from app package
import app.KMPAlgorithmProvider;

// Import classes for unit testing
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Define the test class KMPAlgorithmProviderTest
class KMPAlgorithmProviderTest {

    // Test the computePrefixArray method in the KMPAlgorithmProvider class
    @Test
    void computePrefixArrayTest() {
        // Initialize an instance of the KMPAlgorithmProvider class
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();

        // Assert that the method returns correct prefix arrays
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, kmpAlgorithmProvider.computePrefixArray("abcde"));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, kmpAlgorithmProvider.computePrefixArray("aaaaa"));
    }

    // Additional test for the computePrefixArray method
    // This test ensures that for each prefix length in the pattern, the prefix matches the suffix
    @Test
    public void OtherComputePrefixArrayTest() {
        // Initialize an instance of the KMPAlgorithmProvider class
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();

        // Define a test pattern
        String pattern = "abcdabcda";
        int[] prefixArray = kmpAlgorithmProvider.computePrefixArray(pattern);

        // Test if the prefix matches the suffix for each prefix length in the pattern
        for (int i = 0; i < pattern.length(); i++) {
            String expectedPrefix = pattern.substring(0, prefixArray[i]);
            String actualSuffix = pattern.substring(i - prefixArray[i] + 1, i + 1);

            assertEquals(expectedPrefix, actualSuffix);
        }
    }

    // Test the KMPAlgorithm method in the KMPAlgorithmProvider class
    @Test
    void KMPAlgorithmTest() {
        // Initialize an instance of the KMPAlgorithmProvider class
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();

        // Assert that the method correctly finds the pattern in the text
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("abcdabcda", "abcda"));
        assertFalse(kmpAlgorithmProvider.KMPAlgorithm("abcdabcda", "abcdef"));
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("aaaaa", "aaa"));
    }

    // Test KMPAlgorithm method when the pattern is found at the beginning of the text
    @Test
    public void testKMPAlgorithm_FoundAtBeginning() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("abcdabcda", "abcd"));
    }

    // Test KMPAlgorithm method when the pattern is found at the end of the text
    @Test
    public void testKMPAlgorithm_FoundAtEnd() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("abcdabcda", "abcda"));
    }

    // Test KMPAlgorithm method when the pattern is found in the middle of the text
    @Test
    public void testKMPAlgorithm_FoundInMiddle() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("abcdabcda", "dabc"));
    }

    // Test KMPAlgorithm method when the pattern is not found in the text
    @Test
    public void testKMPAlgorithm_NotFound() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertFalse(kmpAlgorithmProvider.KMPAlgorithm("abcdabcda", "efg"));
    }

    // Test KMPAlgorithm method when the pattern is empty
    @Test
    public void testKMPAlgorithm_EmptyPattern() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("abcdabcda", ""));
    }

    // Test KMPAlgorithm method when the text is empty
    @Test
    public void testKMPAlgorithm_EmptyText() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertFalse(kmpAlgorithmProvider.KMPAlgorithm("", "abc"));
    }
    @Test
    void testWithLongStrings() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        String longText = "a".repeat(1000000) + "b";
        String longPattern = "a".repeat(1000000);

        assertTrue(kmpAlgorithmProvider.KMPAlgorithm(longText, longPattern));
    }

    @Test
    void testWithSpecialCharacters() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("hello, world!", ", world"));
    }

    @Test
    void testWithUnicode() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("Привет, мир!", "мир"));
    }

    @Test
    void testWithEmptyInputs() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("", ""));
    }

    @Test
    void testWithMultipleMatches() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertTrue(kmpAlgorithmProvider.KMPAlgorithm("abc abc abc", "abc"));
    }

    @Test
    void testWithCaseSensitivity() {
        KMPAlgorithmProvider kmpAlgorithmProvider = new KMPAlgorithmProvider();
        assertFalse(kmpAlgorithmProvider.KMPAlgorithm("ABC", "abc"));
    }

}

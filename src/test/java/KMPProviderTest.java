// Import the KMPProvider class from app package
import provider.KMPProvider;

// Import classes for unit testing
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Define the test class KMPProviderTest
class KMPProviderTest {

    // Test the computePrefixArray method in the KMPProvider class
    @Test
    void computePrefixArrayTest() {
        // Initialize an instance of the KMPProvider class
        KMPProvider kmpProvider = new KMPProvider();

        // Assert that the method returns correct prefix arrays
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, kmpProvider.computePrefixArray("abcde"));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, kmpProvider.computePrefixArray("aaaaa"));
    }

    // Additional test for the computePrefixArray method
    // This test ensures that for each prefix length in the pattern, the prefix matches the suffix
    @Test
    public void OtherComputePrefixArrayTest() {
        // Initialize an instance of the KMPProvider class
        KMPProvider kmpProvider = new KMPProvider();

        // Define a test pattern
        String pattern = "abcdabcda";
        int[] prefixArray = kmpProvider.computePrefixArray(pattern);

        // Test if the prefix matches the suffix for each prefix length in the pattern
        for (int i = 0; i < pattern.length(); i++) {
            String expectedPrefix = pattern.substring(0, prefixArray[i]);
            String actualSuffix = pattern.substring(i - prefixArray[i] + 1, i + 1);

            assertEquals(expectedPrefix, actualSuffix);
        }
    }

    // Test the KMPAlgorithm method in the KMPProvider class
    @Test
    void KMPAlgorithmTest() {
        // Initialize an instance of the KMPProvider class
        KMPProvider kmpProvider = new KMPProvider();

        // Assert that the method correctly finds the pattern in the text
        assertTrue(kmpProvider.KMPAlgorithm("abcdabcda", "abcda"));
        assertFalse(kmpProvider.KMPAlgorithm("abcdabcda", "abcdef"));
        assertTrue(kmpProvider.KMPAlgorithm("aaaaa", "aaa"));
    }

    // Test KMPAlgorithm method when the pattern is found at the beginning of the text
    @Test
    public void testKMPAlgorithm_FoundAtBeginning() {
        KMPProvider kmpProvider = new KMPProvider();
        assertTrue(kmpProvider.KMPAlgorithm("abcdabcda", "abcd"));
    }

    // Test KMPAlgorithm method when the pattern is found at the end of the text
    @Test
    public void testKMPAlgorithm_FoundAtEnd() {
        KMPProvider kmpProvider = new KMPProvider();
        assertTrue(kmpProvider.KMPAlgorithm("abcdabcda", "abcda"));
    }

    // Test KMPAlgorithm method when the pattern is found in the middle of the text
    @Test
    public void testKMPAlgorithm_FoundInMiddle() {
        KMPProvider kmpProvider = new KMPProvider();
        assertTrue(kmpProvider.KMPAlgorithm("abcdabcda", "dabc"));
    }

    // Test KMPAlgorithm method when the pattern is not found in the text
    @Test
    public void testKMPAlgorithm_NotFound() {
        KMPProvider kmpProvider = new KMPProvider();
        assertFalse(kmpProvider.KMPAlgorithm("abcdabcda", "efg"));
    }

    // Test KMPAlgorithm method when the pattern is empty
    @Test
    public void testKMPAlgorithm_EmptyPattern() {
        KMPProvider kmpProvider = new KMPProvider();
        assertTrue(kmpProvider.KMPAlgorithm("abcdabcda", ""));
    }

    // Test KMPAlgorithm method when the text is empty
    @Test
    public void testKMPAlgorithm_EmptyText() {
        KMPProvider kmpProvider = new KMPProvider();
        assertFalse(kmpProvider.KMPAlgorithm("", "abc"));
    }
    @Test
    void testWithLongStrings() {
        KMPProvider kmpProvider = new KMPProvider();
        String longText = "a".repeat(1000000) + "b";
        String longPattern = "a".repeat(1000000);

        assertTrue(kmpProvider.KMPAlgorithm(longText, longPattern));
    }

    @Test
    void testWithSpecialCharacters() {
        KMPProvider kmpProvider = new KMPProvider();
        assertTrue(kmpProvider.KMPAlgorithm("hello, world!", ", world"));
    }

    @Test
    void testWithUnicode() {
        KMPProvider kmpProvider = new KMPProvider();
        assertTrue(kmpProvider.KMPAlgorithm("Привет, мир!", "мир"));
    }

    @Test
    void testWithEmptyInputs() {
        KMPProvider kmpProvider = new KMPProvider();
        assertTrue(kmpProvider.KMPAlgorithm("", ""));
    }

    @Test
    void testWithMultipleMatches() {
        KMPProvider kmpProvider = new KMPProvider();
        assertTrue(kmpProvider.KMPAlgorithm("abc abc abc", "abc"));
    }

    @Test
    void testWithCaseSensitivity() {
        KMPProvider kmpProvider = new KMPProvider();
        assertFalse(kmpProvider.KMPAlgorithm("ABC", "abc"));
    }

}

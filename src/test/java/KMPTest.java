import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KMPTest {

    @Test
    void computePrefixArrayTest() {

        KMP kmp = new KMP();

        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, kmp.computePrefixArray("abcde"));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, kmp.computePrefixArray("aaaaa"));
    }

    @Test
    public void OtherComputePrefixArrayTest() {

        KMP kmp = new KMP();

        String pattern = "abcdabcda";
        int[] prefixArray = kmp.computePrefixArray(pattern);

        for (int i = 0; i < pattern.length(); i++) {

            String expectedPrefix = pattern.substring(0, prefixArray[i]);
            String actualSuffix = pattern.substring(i - prefixArray[i] + 1, i + 1);

            assertEquals(expectedPrefix, actualSuffix);
        }
    }

    @Test
    void KMPAlgorithmTest() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("abcdabcda", "abcda"));
        assertFalse(kmp.KMPAlgorithm("abcdabcda", "abcdef"));
        assertTrue(kmp.KMPAlgorithm("aaaaa", "aaa"));
    }
}

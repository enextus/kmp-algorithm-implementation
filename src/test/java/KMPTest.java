import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KMPTest {

    @Test
    void computePrefixArrayTest() {
        KMP kmp = new KMP();
        assertArrayEquals(new int[]{0, 0, 0, 1, 2, 3, 4, 2}, kmp.computePrefixArray("abcdabcda"));
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, kmp.computePrefixArray("abcde"));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, kmp.computePrefixArray("aaaaa"));
    }

    @Test
    void KMPAlgorithmTest() {
        KMP kmp = new KMP();
        assertTrue(kmp.KMPAlgorithm("abcdabcda", "abcda"));
        assertFalse(kmp.KMPAlgorithm("abcdabcda", "abcdef"));
        assertTrue(kmp.KMPAlgorithm("aaaaa", "aaa"));
    }
}

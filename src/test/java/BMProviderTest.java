// Import the KMPProvider class from app package
import org.junit.jupiter.api.BeforeEach;
import provider.BMProvider;

// Import classes for unit testing
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BMProviderTest {
    private BMProvider bmProvider;

    @BeforeEach
    void setUp() {
        bmProvider = new BMProvider();
    }

    @Test
    void testBMAlgorithm_whenPatternIsFoundInTheText_thenReturnTrue() {
        String text = "Hello World";
        String pattern = "World";

        boolean isPatternFound = bmProvider.BMAlgorithm(text, pattern);

        assertTrue(isPatternFound, "The pattern should be found in the text");
    }

    @Test
    void testBMAlgorithm_whenPatternIsNotFoundInTheText_thenReturnFalse() {
        String text = "Hello World";
        String pattern = "OpenAI";

        boolean isPatternFound = bmProvider.BMAlgorithm(text, pattern);

        assertFalse(isPatternFound, "The pattern should not be found in the text");
    }

    @Test
    void testBMAlgorithm_whenTextIsEmpty_thenReturnFalse() {
        String text = "";
        String pattern = "Hello";

        boolean isPatternFound = bmProvider.BMAlgorithm(text, pattern);

        assertFalse(isPatternFound, "The pattern should not be found in the text as it is empty");
    }

    @Test
    void testBMAlgorithm_whenPatternIsEmpty_thenReturnTrue() {
        String text = "Hello World";
        String pattern = "";

        boolean isPatternFound = bmProvider.BMAlgorithm(text, pattern);

        assertTrue(isPatternFound, "The pattern should be found in the text as it is empty");
    }

    @Test
    void testBMAlgorithm_whenTextAndPatternAreEmpty_thenReturnTrue() {
        String text = "";
        String pattern = "";

        boolean isPatternFound = bmProvider.BMAlgorithm(text, pattern);

        assertTrue(isPatternFound, "The pattern should be found in the text as both are empty");
    }

}

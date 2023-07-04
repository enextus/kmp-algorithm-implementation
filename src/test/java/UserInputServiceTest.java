import app.UserInputService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserInputServiceTest {

    UserInputService inputService = mock(UserInputService.class);

    @Test
    public void testGetValidatedUserInput() {
        when(inputService.getValidatedUserInput(anyString())).thenReturn("Mocked Input");

        String result = inputService.getValidatedUserInput("Any String");

        assertEquals("Mocked Input", result);
    }

    @Test
    public void testIsInputAllowed() {
        when(inputService.isInputAllowed(anyString())).thenReturn(true);

        boolean result = inputService.isInputAllowed("Any String");

        assertTrue(result);
    }

    @Test
    public void testProcessUserInput() {
        when(inputService.processUserInput(anyString())).thenReturn("Processed Input");

        String result = inputService.processUserInput("Any String");

        assertEquals("Processed Input", result);
    }

    @Test
    public void testIsInputNotAllowed() {
        when(inputService.isInputAllowed(anyString())).thenReturn(false);

        boolean result = inputService.isInputAllowed("Any String");

        assertFalse(result);
    }

    @Test
    public void testGetValidatedUserInput_EmptyString() {
        when(inputService.getValidatedUserInput(anyString())).thenReturn("");

        String result = inputService.getValidatedUserInput("");

        assertEquals("", result);
    }

    @Test
    public void testProcessUserInput_Exception() {
        when(inputService.processUserInput(anyString())).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> inputService.processUserInput("Any String"));
    }

}

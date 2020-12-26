package model.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Observable;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewCustomerSaverTest {

    private NewCustomerSaver newCustomerSaverUnderTest;

    @BeforeEach
    public void setUp() {
        newCustomerSaverUnderTest = new NewCustomerSaver();
    }

    @Test
    public void testUpdate() {
        // Setup
        final Observable o = null;
        final Object arg = null;

        // Run the test
        newCustomerSaverUnderTest.update(o, arg);

        assertEquals(arg, null);
        assertEquals(o, null);
    }
}

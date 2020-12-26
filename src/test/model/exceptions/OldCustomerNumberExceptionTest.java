package model.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OldCustomerNumberExceptionTest {

    private OldCustomerNumberException oldCustomerNumberExceptionUnderTest;

    @BeforeEach
    void setUp() {
        oldCustomerNumberExceptionUnderTest = new OldCustomerNumberException("s");
    }

    @Test
    void testException() {
        // Setup
        try {
            throw new OldCustomerNumberException("s");
        } catch (OldCustomerNumberException e) {
            System.out.println("s");
        }


    }
}

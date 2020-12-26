package model.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserDetailsExceptionTest {

    private UserDetailsException userDetailsExceptionUnderTest;

    @BeforeEach
    public void setUp() {
        userDetailsExceptionUnderTest = new UserDetailsException("s");
    }

    @Test
    void testException() {
        // Setup
        try {
            throw new OldCustomerNumberException("s");
        } catch (UserDetailsException e) {
            System.out.println("s");
        }

    }

    @Test
    void testException2() {
        // Setup
        try {
            throw new CantFindCustomerException("s");
        } catch (UserDetailsException e) {
            System.out.println("s");
        }
    }

    @Test
    void testException3() {
        // Setup
        try {
            throw new UserDetailsException("s");
        } catch (UserDetailsException e) {
            System.out.println("s");
        }
    }

}

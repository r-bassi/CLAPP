package model.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CantFindCustomerExceptionTest {

    private CantFindCustomerException cantFindCustomerExceptionUnderTest;

    @BeforeEach
    public void setUp() {
        cantFindCustomerExceptionUnderTest = new CantFindCustomerException("message");
    }


    @Test
    public void testException() {
        // Setup
        try {
            throw new CantFindCustomerException("message");
        } catch (CantFindCustomerException e) {
            System.out.println("message");
        }

    }

    @Test
    public void testException2() {
        // Setup
        try {
            throw cantFindCustomerExceptionUnderTest;
        } catch (CantFindCustomerException e) {
            System.out.println("message");
        }

    }



}

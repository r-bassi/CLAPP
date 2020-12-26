package model.exceptions;

public class CantFindCustomerException extends UserDetailsException {
    public CantFindCustomerException(String message) {
        super(message);
    }
}


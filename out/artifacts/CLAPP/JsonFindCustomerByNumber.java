package ui.menu;

import model.exceptions.CantFindCustomerException;
import ui.UserDetails;

public class JsonFindCustomerByNumber extends MenuCaseAbstract {

    public JsonFindCustomerByNumber(int i) {
        super();
        try {
            jsonReader(i);
        } catch (CantFindCustomerException e) {
            return;
        }
    }

    private void jsonReader(Integer i) throws CantFindCustomerException {
        setup();

        for (UserDetails c : customers) {
            if (c.getCustomerNumber() == i) {
                System.out.println(c);
                return;
            }
        }
        throw new CantFindCustomerException("Can't Find This Customer!");


    }
}


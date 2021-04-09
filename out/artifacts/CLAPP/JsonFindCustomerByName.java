package ui.menu;

import model.exceptions.CantFindCustomerException;
import ui.UserDetails;

public class JsonFindCustomerByName extends MenuCaseAbstract {


    public JsonFindCustomerByName(String name) {
        super();

        try{
        jsonReader(name);
        } catch (CantFindCustomerException e) {
            return;
        }
    }

    private void jsonReader(String name) throws CantFindCustomerException {
        setup();

        for (UserDetails c : customers) {
            if (c.getCustomerName().equals(name)) {
                System.out.println(c);
                return;
            }
        }

        throw new CantFindCustomerException("Can't Find This Customer!");

    }

}

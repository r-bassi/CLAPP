package model.observer;

import java.util.Observable;
import java.util.Observer;

public class
NewCustomerSaver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("\n" + "Saved New Customer: " + "\n" + arg);
    }


}

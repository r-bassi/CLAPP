package ui.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ui.Application;
import ui.UserDetails;
import model.exceptions.OldCustomerNumberException;
import model.observer.NewCustomerSaver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class JsonNewCustomer extends MenuCaseAbstract {

    static String FILENAME = "data/userdetails.json";
    private List<UserDetails> userDetailsList;


    public JsonNewCustomer(String customerName, int customerNumber, Double customerSpent, int customerDiscount) {
        super(customerName, customerNumber, customerSpent, customerDiscount);

        UserDetails c = new UserDetails(customerName, customerNumber, customerSpent, customerDiscount);
        c.customerDiscount = Application.getDiscount(c);

        try {
            new JsonNewCustomer(c, customerNumber);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OldCustomerNumberException e) {
            return;
        }

    }

    JsonNewCustomer(UserDetails c, Integer i)
            throws IOException, OldCustomerNumberException {
        super();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // construct Type that tells Gson about the generic type
        Type dtoListType = new TypeToken<List<UserDetails>>() {}.getType();
        FileReader fr = new FileReader(FILENAME);
        userDetailsList = gson.fromJson(fr, dtoListType);
        fr.close();
        // If it was an empty one create initial list
        if (userDetailsList == null) {
            userDetailsList = new ArrayList<>();
        }
        for (UserDetails custs : userDetailsList) {
            if (custs.getCustomerNumber() == i) {
                throw new OldCustomerNumberException("This Customer Number Already Exists!");
            }
        }
        // Add new item to the list
        userDetailsList.add(c);
        addObserver(new NewCustomerSaver());
        setChanged();
        notifyObservers(c);
        // No append replace the whole file
        FileWriter fw = new FileWriter(FILENAME);
        gson.toJson(userDetailsList, fw);
        fw.close();
    }

}

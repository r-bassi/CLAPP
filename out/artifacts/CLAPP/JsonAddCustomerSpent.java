package ui.menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.exceptions.CantFindCustomerException;
import model.exceptions.OldCustomerNumberException;
import ui.Application;
import ui.UserDetails;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonAddCustomerSpent extends MenuCaseAbstract {

    private List<UserDetails> userDetailsList;

    //Adds a dollar value to the amount the customer has spent
    public JsonAddCustomerSpent(int customerNumber, Double customerSpent) {
        super();
        if (customerSpent > 0) {
            try {
                jsonReader(customerNumber, customerSpent);
            } catch (CantFindCustomerException e) {
                return;
            } catch (OldCustomerNumberException e) {
                return;
            }
        } else {
            System.out.println("Enter an amount over 0!");
            return;
        }

    }

    //Changes how much the customer has spent using json
    private void jsonReader(Integer cnum, Double howMuch) throws CantFindCustomerException, OldCustomerNumberException {
        try {
            setup();


            for (UserDetails c : customers) {
                if (c.getCustomerNumber() == cnum) {
                    int getIndex = find(customers, c);
                    c.setCustomerSpent(howMuch);
                    c.setCustomerDiscount(Application.getDiscount(c));
                    jsonWriter(c, getIndex);
                    System.out.println(c);

                    return;
                }
            }
            throw new CantFindCustomerException("Can't Find This Customer!");

        } catch (IOException e) {
            return;
        }
    }

    //Finds the correct customer in the array of saved customers
    private static <T> int find(T[] a, T target) {
        for (int i = 0; i < a.length; i++) {
            if (target.equals(a[i])) {
                return i;
            }
        }
        return -1;
    }

    private void jsonWriter(UserDetails c, Integer index) throws IOException {
        Gson gson;
        gson = new GsonBuilder().setPrettyPrinting().create();
        // construct Type that tells Gson about the generic type
        Type dtoListType = new TypeToken<List<UserDetails>>() {
        }.getType();
        String filename = "data/userdetails.json";
        FileReader fr = new FileReader(filename);
        userDetailsList = gson.fromJson(fr, dtoListType);
        fr.close();


        userDetailsList.set(index, c);

        // No append replace the whole file
        FileWriter fw = new FileWriter(filename);
        gson.toJson(userDetailsList, fw);
        fw.close();

    }


}

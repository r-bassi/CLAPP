package ui.menu;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import ui.UserDetails;

import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class MenuCaseAbstract extends UserDetails {

    private static final String FILENAME = "data/userdetails.json";
    UserDetails[] customers;

    public MenuCaseAbstract(String customerName, int customerNumber, Double customerSpent) {
        super(customerName, customerNumber, customerSpent);
    }

    MenuCaseAbstract() {
        super();
    }

    public void setup() {

        try {
            // Initialize Gson
            Gson gson = new Gson();


            // Initialize Gson's JSON reader, pointing to userdetails.json
            JsonReader reader = new JsonReader(new FileReader(FILENAME));

            // Read from the data into a UserDetails array (UserDetails[])
            customers = gson.fromJson(reader, UserDetails[].class);

            // Print out the customers we found
            System.out.println("Customer(s): ");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
    }
}

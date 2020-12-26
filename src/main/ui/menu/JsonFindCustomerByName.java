package ui.menu;

import ui.UserDetails;

public class JsonFindCustomerByName extends MenuCaseAbstract {


    public JsonFindCustomerByName(String name) {
//        Scanner namescanner = new Scanner(System.in);
//        System.out.println("You picked Find Customer By Name");
//        System.out.println("Enter name:");
//        String name = namescanner.nextLine();
        super();
        jsonReader(name);
    }

    private void jsonReader(String name) {
        setup();

        for (UserDetails c : customers) {
            if (c.getCustomerName().equals(name)) {
                System.out.println(c);
            }
        }


    }

}

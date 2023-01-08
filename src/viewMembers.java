import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class viewMembers extends Customer{


    public viewMembers(ArrayList<String> customer_data, String username, String password) {
        super(customer_data, username, password);
    }

    public void viewCustomerInfo() {
        for (int i = 0; i < getCustomer_data().size();i++)
        {
            System.out.println("Member "+i+": " +  getCustomer_data().get(i));
        }
    }
}

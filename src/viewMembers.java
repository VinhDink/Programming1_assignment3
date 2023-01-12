import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class viewMembers extends Customer{


    public viewMembers(ArrayList<String> customer_data, String username, String password) {
        super(customer_data, username, password);
    }

    public void viewCustomerInfo() {
        System.out.printf("%-15s%-15s%-15s%-20s%-15s%-30s%-30s%-10s",
                "Customer ID", "Username", "Password", "Name", "Phone", "Email address", "Address", "Membership\n");
        System.out.println("----------------------------------------------------------------------" +
                "---------------------------------------------------------------------------------");
        for (int i = 0; i < getCustomer_data().size();i++)
        {
            String[] split = getCustomer_data().get(i).split(",");
            System.out.printf("%-15s%-15s%-15s%-20s%-15s%-30s%-30s%-10s\n",
                    split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7]);
        }
        System.out.println("Total customers: " + getCustomer_data().size());
    }
}

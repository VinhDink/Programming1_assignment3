import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private ArrayList<String> customer_data;
    //Constructor
    public Customer( ArrayList<String> customer_data) {

        this.customer_data = customer_data;
    }

    //Getter

    public ArrayList<String> getCustomer_data() {
        return customer_data;
    }

    //Setter
    public void setCustomer_data(ArrayList<String> customer_data) {
        this.customer_data = customer_data;
    }

    public boolean validateCustomer() {
        ArrayList<String> username_arr = new ArrayList<String>();
        ArrayList<String> password_arr = new ArrayList<String>();
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] arr = customer_data.get(i).split(",");
            username_arr.add(arr[1]);
            password_arr.add(arr[2]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username!");
        String username = scanner.nextLine();
        System.out.println("Please enter your password!");
        String password = scanner.nextLine();
        if (username_arr.contains(username) == true) {
            int i = username_arr.indexOf(username);
            if (password_arr.get(i).equals(password)) {
                System.out.println("Login successfully!");
                return true;
            } else System.out.println("Wrong password");
        } else System.out.println("Wrong username!");
        return false;
    }
}

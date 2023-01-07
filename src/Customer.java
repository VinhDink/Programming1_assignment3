import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String username;
    private String password;
    private ArrayList<String> customer_data;
    //Constructor
    public Customer(ArrayList<String> customer_data) {
        this.customer_data = customer_data;
    }
    public Customer(String username, String password, ArrayList<String> customer_data) {
        this.username = username;
        this.password = password;
        this.customer_data = customer_data;
    }

    //Getter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getCustomer_data() {
        return customer_data;
    }

    //Setter
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCustomer_data(ArrayList<String> customer_data) {
        this.customer_data = customer_data;
    }
    
    public boolean validateCustomer() {
        for (int i = 0; i < 5; i++) {
            String[] arr = customer_data.get(i).split(",");
            if (username.equals(arr[1]) && password.equals(arr[2])) {
                System.out.println("Login successfully!");
                return true;
            } else System.out.println("Wrong password or username!");
        }
        return false;
    }
}

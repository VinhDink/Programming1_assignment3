import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Membership {
    static PrintWriter pw = null;
    static Scanner fileScanner =  null;
    private ArrayList<String> customer_data;
    private ArrayList<String> orders_data;
    private String username;
    //Constructor
    public Membership(ArrayList<String> customer_data,ArrayList<String> orders_data,String username) {
        this.customer_data = customer_data;
        this.orders_data = orders_data;
        this.username = username;
    }
    //Getter
    public ArrayList<String> getCustomer_data() {
        return customer_data;
    }
    public ArrayList<String> getOrders_data() {
        return orders_data;
    }
    public String getUsername() {
        return username;
    }
    //Setter
    public void setCustomer_data(ArrayList<String> customer_data) {
        this.customer_data = customer_data;
    }
    public void setOrders_data(ArrayList<String> orders_data) {
        this.orders_data = orders_data;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void updateMembership() {
        String customer_id = null;
        int total_purchase = 0;
        String membership_status = null;

        ArrayList<String> current_arr = new ArrayList<String>();
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] arr = getCustomer_data().get(i).split(",");
            if (username.equals(arr[1])) {
                customer_id = arr[0];
                for (int j = 0; j < arr.length; j++) {
                    current_arr.add(arr[j]);
                }
            }
        }

        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] arr = getOrders_data().get(i).split(",");
            if (customer_id.equals(arr[3]) && arr[8].equals("paid")) {
                total_purchase += Integer.parseInt(arr[2]);
            }
        }

        if (total_purchase > 5000000 && total_purchase <= 10000000) {
            membership_status = "Silver";
        } else if (total_purchase > 10000000 && total_purchase <= 25000000) {
            membership_status = "Gold";
        } else if (total_purchase > 25000000) {
            membership_status = "Platinum";
        }

        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] arr = getCustomer_data().get(i).split(",");
            if (username.equals(arr[1])) {
                arr[7] = membership_status;
                getCustomer_data().set(i, Arrays.toString(arr).replace("[", "").replace("]", ""));
                break;
            }
        }


        System.out.println("Your total purchase value is " + total_purchase + " VND which gives you " + membership_status + " membership");
    }
}

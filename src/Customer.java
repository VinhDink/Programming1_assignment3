import java.util.ArrayList;

public class Customer {
    private ArrayList<String> customer_data;
    //Constructor
    public Customer(ArrayList<String> customer_data) {
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
}

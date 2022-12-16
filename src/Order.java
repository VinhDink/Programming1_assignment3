public class Order {
    private int date;
    private String items_name;
    private double total_price;
    private int customer_id;
    private int phone_number;
    private String email;
    private String address;

    //Constructor
    public Order(int date, String items_name, double total_price, int customer_id, int phone_number, String email, String address) {
        this.date = date;
        this.items_name = items_name;
        this.total_price = total_price;
        this.customer_id = customer_id;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
    }

    //Setter
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setItems_name(String items_name) {
        this.items_name = items_name;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    //Getter

    public String getAddress() {
        return address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public double getTotal_price() {
        return total_price;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getDate() {
        return date;
    }

    public String getItems_name() {
        return items_name;
    }
}

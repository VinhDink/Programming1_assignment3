public class Customer {
    private String ID;
    private String username;
    private String password;
    private String full_name;
    private int phone_number;
    private String email;
    private String address;

    //Constructor
    public Customer(String ID, String username, String password, String full_name, int phone_number, String email, String address) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
    }

    //Setter

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    //Getter

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getID() {
        return ID;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFull_name() {
        return full_name;
    }
}

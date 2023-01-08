import java.util.ArrayList;

public class currentCustomer extends Customer{
    public currentCustomer(ArrayList<String> customer_data,String username,String password) {super(customer_data,username,password);}

    public void getCustomerInfo() {
        ArrayList<String> current_arr = new ArrayList<String>();
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] arr = getCustomer_data().get(i).split(",");
            if(username.equals(arr[1])) {
                current_arr.add(getCustomer_data().get(i));
            }
        }
        System.out.println("Your account information:\n" +
                "Customer ID:" + current_arr.get(0) + "\n" +
                "Customer username:" + current_arr.get(1) + "\n" +
                "Customer password:" + current_arr.get(2) + "\n" +
                "Customer name:" + current_arr.get(3) + "\n" +
                "Customer phone number:" + current_arr.get(4) + "\n" +
                "Customer email:" + current_arr.get(5) + "\n" +
                "Customer address:" + current_arr.get(6) + "\n" +
                "Customer rank:" + current_arr.get(7));
    }
}

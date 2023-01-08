import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class currentCustomer extends Customer {
    static PrintWriter pw = null;
    static Scanner fileScanner =  null;
    public currentCustomer(ArrayList<String> customer_data, String username, String password) {
        super(customer_data, username, password);
    }

    public ArrayList<String> extract() {
        ArrayList<String> current_arr = new ArrayList<String>();
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] arr = getCustomer_data().get(i).split(",");
            if (username.equals(arr[1])) {
                for (int j = 0; j < arr.length; j++) {
                    current_arr.add(arr[j]);
                }
            }
        }
        return current_arr;
    }

    public void view() {
        System.out.println("Your account information:\n" +
                "Customer ID: " + extract().get(0) + "\n" +
                "Customer username: " + extract().get(1) + "\n" +
                "Customer password: " + extract().get(2) + "\n" +
                "Customer name: " + extract().get(3) + "\n" +
                "Customer phone number: " + extract().get(4) + "\n" +
                "Customer email: " + extract().get(5) + "\n" +
                "Customer address: " + extract().get(6) + "\n" +
                "Customer status: " + extract().get(7));
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> user_arr = new ArrayList<String>();
        ArrayList<String> pass_arr = new ArrayList<String>();
        ArrayList<String> name_arr = new ArrayList<String>();
        ArrayList<Integer> phone_arr = new ArrayList<Integer>();
        ArrayList<String> email_arr = new ArrayList<String>();
        ArrayList<String> address_arr = new ArrayList<String>();
        boolean valid = false;
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] arr = getCustomer_data().get(i).split(",");
            user_arr.add(arr[1]);
            pass_arr.add(arr[2]);
            name_arr.add(arr[3]);
            phone_arr.add(Integer.valueOf(arr[4]));
            email_arr.add(arr[5]);
            address_arr.add(arr[6]);
        }
        while (!valid) {
            System.out.println("Choose which information in your account to change:");
            System.out.println("1 Username" +
                    "\n2 Password" +
                    "\n3 Full name" +
                    "\n4 Phone number" +
                    "\n5 Email address" +
                    "\n6 Home address");
            int updateOption = scanner.nextInt();
            switch (updateOption) {
                case 1:
                    System.out.println("Enter new username:");
                    String user = scanner.nextLine();
                    if (user_arr.contains(user)) {
                        System.out.println("Username taken!");
                        valid = false;
                    } else {
                        getCustomer_data().set(1, user);
                        valid = true;
                        System.out.println("Username updated!");
                    }
            }
        }
    }

    public void checkMembership() {
        System.out.println("Your membership status: " + extract().get(7));
    }
}

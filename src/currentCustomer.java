import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<String> phone_arr = new ArrayList<String>();
        ArrayList<String> email_arr = new ArrayList<String>();
        ArrayList<String> address_arr = new ArrayList<String>();
        ArrayList<String> info_arr = new ArrayList<String>();
        boolean valid = false;
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] arr = getCustomer_data().get(i).split(",");
            user_arr.add(arr[1]);
            pass_arr.add(arr[2]);
            name_arr.add(arr[3]);
            phone_arr.add(arr[4]);
            email_arr.add(arr[5]);
            address_arr.add(arr[6]);
            if (arr[1].equals(username)) {
                Collections.addAll(info_arr,arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]);
            }
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
                    int usernameIndex = user_arr.indexOf(extract().get(1));
                    System.out.println(info_arr);
                    System.out.println("Enter new username:");
                    scanner.nextLine();
                    String user = scanner.nextLine();
                    if (user_arr.contains(user)) {
                        System.out.println("Username taken!");
                        valid = false;
                    } else {
                        info_arr.set(1,user);
                        String new_data = info_arr.get(0) +","+info_arr.get(1)+","+info_arr.get(2)+","+info_arr.get(3)+","+info_arr.get(4)+","+info_arr.get(5)+","+info_arr.get(6)+","+info_arr.get(7);
                        System.out.println(new_data);
                        getCustomer_data().set(usernameIndex, new_data);
                        valid = true;
                        System.out.println("Username updated!");
                    }
                    break;
                case 2:
                    int passwordIndex = pass_arr.indexOf(extract().get(2));
                    System.out.println(info_arr);
                    System.out.println("Enter new password:");
                    scanner.nextLine();
                    String pass = scanner.nextLine();
                    info_arr.set(2,pass);
                    String new_pass_data = info_arr.get(0) +","+info_arr.get(1)+","+info_arr.get(2)+","+info_arr.get(3)+","+info_arr.get(4)+","+info_arr.get(5)+","+info_arr.get(6)+","+info_arr.get(7);
                    System.out.println(new_pass_data);
                    getCustomer_data().set(passwordIndex, new_pass_data);
                    valid = true;
                    System.out.println("Password updated!");
                    break;
                case 3:
                    int nameIndex = name_arr.indexOf(extract().get(3));
                    System.out.println(info_arr);
                    System.out.println("Enter new full name:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    info_arr.set(3,name);
                    String new_name_data = info_arr.get(0) +","+info_arr.get(1)+","+info_arr.get(2)+","+info_arr.get(3)+","+info_arr.get(4)+","+info_arr.get(5)+","+info_arr.get(6)+","+info_arr.get(7);
                    System.out.println(new_name_data);
                    getCustomer_data().set(nameIndex, new_name_data);
                    valid = true;
                    System.out.println("Full name updated!");
                    break;
                case 4:
                    int phoneIndex = phone_arr.indexOf(extract().get(4));
                    System.out.println(info_arr);
                    System.out.println("Enter new phone number:");
                    scanner.nextLine();
                    String phone = scanner.nextLine();
                    info_arr.set(4,phone);
                    String new_phone_data = info_arr.get(0) +","+info_arr.get(1)+","+info_arr.get(2)+","+info_arr.get(3)+","+info_arr.get(4)+","+info_arr.get(5)+","+info_arr.get(6)+","+info_arr.get(7);
                    System.out.println(new_phone_data);
                    getCustomer_data().set(phoneIndex, new_phone_data);
                    valid = true;
                    System.out.println("Phone number updated!");
                    break;
                case 5:
                    int emailIndex = email_arr.indexOf(extract().get(5));
                    System.out.println(info_arr);
                    System.out.println("Enter new email:");
                    scanner.nextLine();
                    String email = scanner.nextLine();
                    info_arr.set(5,email);
                    String new_email_data = info_arr.get(0) +","+info_arr.get(1)+","+info_arr.get(2)+","+info_arr.get(3)+","+info_arr.get(4)+","+info_arr.get(5)+","+info_arr.get(6)+","+info_arr.get(7);
                    System.out.println(new_email_data);
                    getCustomer_data().set(emailIndex, new_email_data);
                    valid = true;
                    System.out.println("Email updated!");
                    break;
                case 6:
                    int addressIndex = address_arr.indexOf(extract().get(6));
                    System.out.println(info_arr);
                    System.out.println("Enter new home address:");
                    scanner.nextLine();
                    String address = scanner.nextLine();
                    info_arr.set(6,address);
                    String new_home_data = info_arr.get(0) +","+info_arr.get(1)+","+info_arr.get(2)+","+info_arr.get(3)+","+info_arr.get(4)+","+info_arr.get(5)+","+info_arr.get(6)+","+info_arr.get(7);
                    System.out.println(new_home_data);
                    getCustomer_data().set(addressIndex, new_home_data);
                    valid = true;
                    System.out.println("Home address updated!");
            }
        }
    }
    public void checkMembership() {
        System.out.println("Your membership status: " + extract().get(7));
    }
}

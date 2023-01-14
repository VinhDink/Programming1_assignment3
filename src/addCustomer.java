/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Le Hoang Duong
  ID: s3362467
  Acknowledgement: None
*/

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class addCustomer extends Customer {
    static PrintWriter pw = null;
    static Scanner fileScanner =  null;
    public addCustomer(ArrayList<String> customer_data, String username, String password) {
        super(customer_data, username, password);
    }
    public void add() {
        int a = 0;
        ArrayList<String> user_arr = new ArrayList<String>();
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] arr = getCustomer_data().get(i).split(",");
            a = i+1;
            user_arr.add(arr[1]);
        }
        String index = Integer.toString(a+1);
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter a new username (must be unique):");
            String user = scanner.nextLine();
            if (user_arr.contains(user)) {
                System.out.println("Username taken!");
                valid = false;
            } else {
                System.out.println("Enter a password:");
                String pass = scanner.nextLine();
                System.out.println("Enter your real name:");
                String name = scanner.nextLine();
                System.out.println("Enter your phone number:");
                int phone = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter your email address:");
                String email = scanner.nextLine();
                System.out.println("Enter your home address:");
                String address = scanner.nextLine();
                getCustomer_data().add("customer_id" + index + "," + user + "," + pass + "," + name + "," + phone + "," + email + "," + address+","+"Basic");
                System.out.println("New customer account added!");
                valid = true;
            }
        }
    }
}

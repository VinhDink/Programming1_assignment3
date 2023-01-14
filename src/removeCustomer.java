/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Nguyen Minh Nhat
  ID: s3924871
  Acknowledgement: None
*/

import java.util.ArrayList;
import java.util.Scanner;

public class removeCustomer extends Customer{


    public removeCustomer(ArrayList<String> customer_data, String username, String password) {
        super(customer_data, username, password);
    }

    public void remove() {
        ArrayList<String> cus_list = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        boolean status = false;
        System.out.println("Enter Customer ID to remove:");
        String ID = scanner.nextLine();
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] cus_arr = getCustomer_data().get(i).split(",");
            cus_list.add(cus_arr[0]);
        }
        while (!status) {
            if (!cus_list.contains(ID)) {
                System.out.println("There is no customer with the ID: " + ID);
                status = true;
            } else {
                int index = cus_list.indexOf(ID);
                getCustomer_data().remove(index);
                System.out.println("Customer with ID: " + ID +" has been deleted!");
                status = true;
            }
        }
    }
}

/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Ha Thuy Chi
  ID: s3930417
  Acknowledgement: None
*/

import java.util.ArrayList;
import java.util.Scanner;

public class viewOrder extends Customer{
    public viewOrder(ArrayList<String> customer_data, String username, String password) {
        super(customer_data, username, password);
    }

    public void view(ArrayList<String> order_data, ArrayList<String> customer_data) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lst = new ArrayList<>();
        String customerID = null;
        String customerUsername = getUsername();
        StringBuilder title = new StringBuilder();

        for (String i : customer_data) {
            String[] split = i.split(",");
            if (customerUsername.equals(split[1])) {
                customerID = split[0];
            }
        }
        System.out.printf("%-15s%-30s%-15s%-20s%-10s\n",
                "Order ID", "Title", "Price", "Order date", "Status");
        for (String i : order_data) {
            String[] split = i.split(",");String a = split[1].replace("[", "");
            String b = a.replace("]", "");
            String[] split1 = b.split(";");
            if (split1.length > 2) {
                title.append(String.format("%s, %s,...", split1[0], split1[1]));
            } else if (split1.length == 2){
                title.append(String.format("%s, %s", split1[0], split1[1]));
            } else {
                title.append(String.format("%s", split1[0]));
            }
            if (customerID != null && customerID.equals(split[3])) {
                System.out.printf("%-15s%-30s%-15s%-20s%-10s\n",
                        split[0], title, split[2], split[7], split[8]);
                title.delete(0, title.length());
                lst.add(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8]));
            }
            title.delete(0, title.length());
        }
        if (lst.size() == 0) {
            System.out.println("No order to appear hear!");
        }

        //get order info
        System.out.println("Do you want to view a order? (Yes/No)");
        String an = sc.nextLine();
        if (an.charAt(0) == 'Y' || an.charAt(0) == 'y') {
            System.out.println("Please enter the order Id that you want to view:");
            String orderId = sc.nextLine();
            for (String i : lst) {
                String[] split = i.split(",");
                if (orderId.equals(split[0])) {
                    for (String a : split) {
                        if (a.equals(split[1])) {
                            String b = a.replace("[", "");
                            String result = b.replace("]", "");
                            System.out.printf("%s\t", result);
                        } else {
                            System.out.printf("%s\t", a);
                        }
                    }

                }
            }
            System.out.println();
        }
    }
}

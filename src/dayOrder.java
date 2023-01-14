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

public class dayOrder extends Order{
    public dayOrder(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void executedOrder() {
        StringBuilder title = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter day to search for orders:");
        String day = scanner.nextLine();
        ArrayList<String> item_list = new ArrayList<String>();
        StringBuilder paid = new StringBuilder();
        StringBuilder unpaid = new StringBuilder();
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] order_arr = getOrders_data().get(i).split(",");
            String a = order_arr[1].replace("[", "").replace("]", "");
            String[] split1 = a.split(";");
            if (split1.length > 2) {
                title.append(String.format("%s, %s,...", split1[0], split1[1]));
            } else if (split1.length == 2){
                title.append(String.format("%s, %s", split1[0], split1[1]));
            } else {
                title.append(String.format("%s", split1[0]));
            }
            System.out.println(title);
            if (day.equals(order_arr[7])) {
                if (order_arr[8].equals("paid")) {
                    paid.append(String.format("%-10s%-40s%-15s%-20s%-15s%-30s%-30s%-15s%-10s\n",
                            order_arr[0], title, order_arr[2], order_arr[3],
                            order_arr[4], order_arr[5], order_arr[6], order_arr[7], order_arr[8]));
                    title.delete(0, title.length());
                } else {
                    unpaid.append(String.format("%-10s%-40s%-15s%-20s%-15s%-30s%-30s%-15s%-10s\n",
                            order_arr[0], title, order_arr[2], order_arr[3],
                            order_arr[4], order_arr[5], order_arr[6], order_arr[7], order_arr[8]));
                    title.delete(0, title.length());
                }
            } else {
                title.delete(0, title.length());
            }
        }
        System.out.println("Paid order(s) in day " + day + ":");
        System.out.printf("%-10s%-40s%-15s%-20s%-15s%-30s%-30s%-15s%-10s\n",
                "Order ID", "Title", "Price", "Customer ID", "Phone", "Email address", "Address", "Order date", "Status");
        System.out.println("----------------------------------------------------" +
                "-------------------------------------------------------------------------------" +
                "---------------------------------------------------");
        if (paid.length() == 0) {
            System.out.println("No paid order was placed on " + day + "!");
        }
        System.out.println(paid);
        System.out.println("Unpaid order(s) in day " + day + ":");
        System.out.printf("%-10s%-40s%-15s%-20s%-15s%-30s%-30s%-15s%-10s\n",
                "Order ID", "Title", "Price", "Customer ID", "Phone", "Email address", "Address", "Order date", "Status");
        System.out.println("----------------------------------------------------" +
                "-------------------------------------------------------------------------------" +
                "---------------------------------------------------");
        if (unpaid.length() == 0) {
            System.out.println("No unpaid order was placed on " + day + "!");
        }
        System.out.println(unpaid);
    }
}

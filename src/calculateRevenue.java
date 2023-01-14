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

public class calculateRevenue extends Order{
    public calculateRevenue(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void totalRevenue() {
        int total = 0;
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] order_arr = getOrders_data().get(i).split(",");
            if (order_arr[8].equals("Delivered")) {
                System.out.println(order_arr[2]);
                total += Double.parseDouble(order_arr[2]);
            }
        }
        System.out.println("Total revenue is: " + total + " VND (Delivered orders only)");
    }

    public void dayRevenue() {
        int paid = 0;
        int unpaid = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter day:");
        String day = scanner.nextLine();
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] order_arr = getOrders_data().get(i).split(",");
            if (order_arr[7].equals(day)) {
                if (order_arr[8].equals("Delivered")) {
                    paid += Double.parseDouble(order_arr[2]);
                }
                unpaid += Double.parseDouble(order_arr[2]);
            }
        }
        System.out.println("Total revenue for day " + day + " is " + paid + " VND (Delivered orders only)");
        System.out.println("Total revenue for day " + day + " is " + unpaid + " VND (Delivered and Processing orders)");
    }
}

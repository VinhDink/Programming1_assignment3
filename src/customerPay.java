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

public class customerPay extends Order{
    public customerPay(ArrayList<String> orders_data) {
        super(orders_data);
    }
    public void mostPay() {
        ArrayList<String> customer_list = new ArrayList<String>();
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] order_arr = getOrders_data().get(i).split(",");
            if (!customer_list.contains(order_arr[3])) {
                customer_list.add(order_arr[3]);
            }
        }
        double highest = 0;
        String mostPay = "";
        for (String s : customer_list) {
            String ID = s;
            double total = 0;
            for (int j = 0; j < getOrders_data().size(); j++) {
                String[] order_arr = getOrders_data().get(j).split(",");
                if (ID.equals(order_arr[3])) {
                    if (order_arr[8].equals("paid")) {
                        total += Double.parseDouble(order_arr[2]);
                    }
                }
            }
            if (total > highest) {
                highest = total;
                mostPay = ID;
            }
        }
        System.out.printf("Customer with ID: "+ mostPay +" pays the most in the store and has spent total of %.3fVND", highest);
        System.out.println("\n");
    }
}

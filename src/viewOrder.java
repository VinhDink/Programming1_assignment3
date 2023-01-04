import java.util.ArrayList;
import java.util.Scanner;

public class viewOrder extends Order{
    public viewOrder(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void view(ArrayList<String> order_data) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lst = new ArrayList<>();


        System.out.println("Please enter your customer ID:");
        String customerID = sc.nextLine();
        System.out.printf("%-15s%-30s%-10s%-20s%-10s\n",
                "Order ID", "Title", "Price", "Order date", "Status");
        for (String i : order_data) {
            String[] split = i.split(",");
            if (customerID.equals(split[3])) {
                System.out.printf("%-15s%-30s%-10s%-20s%-10s\n",
                        split[0], split[1], split[2], split[7], split[8]);
                lst.add(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8]));
            }
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

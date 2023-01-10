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
            if (order_arr[8].equals("paid")) {
                total += Integer.parseInt(order_arr[2]);
            }
        }
        System.out.println("Total revenue is: " + total + " VND (Paid orders only)");
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
                if (order_arr[8].equals("paid")) {
                    paid += Integer.parseInt(order_arr[2]);
                }
                unpaid += Integer.parseInt(order_arr[2]);
            }
        }
        System.out.println("Total revenue for day " + day + " is " + paid + " VND (Paid orders only)");
        System.out.println("Total revenue for day " + day + " is " + unpaid + " VND (Paid and Unpaid orders)");
    }
}

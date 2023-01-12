import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dayOrder extends Order{
    public dayOrder(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void executedOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter day to search for orders:");
        String day = scanner.nextLine();
        StringBuilder paid = new StringBuilder();
        StringBuilder unpaid = new StringBuilder();
        boolean found = false;
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] order_arr = getOrders_data().get(i).split(",");
            if (day.equals(order_arr[7])) {
                found = true;
                if (order_arr[8].equals("Delivered")) {
                    paid.append(Arrays.toString(order_arr));
                    paid.append("\n");
                } else {
                    unpaid.append(Arrays.toString(order_arr));
                    unpaid.append("\n");
                }
            }
        }
        if (!found) {
            System.out.println("No date found!");
        } else {
            System.out.println("Delivered order(s) in day " + day + ": \n" + paid);
            System.out.println("Processing order(s) in day " + day + ": \n" + unpaid);
        }
    }
}
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
        ArrayList<String> item_list = new ArrayList<String>();
        StringBuilder paid = new StringBuilder();
        StringBuilder unpaid = new StringBuilder();
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] order_arr = getOrders_data().get(i).split(",");
            if (day.equals(order_arr[7])) {
                if (order_arr[8].equals("paid")) {
                    paid.append(Arrays.toString(order_arr));
                    paid.append("\n");
                } else {
                    unpaid.append(Arrays.toString(order_arr));
                    unpaid.append("\n");
                }
            }
        }
        System.out.println("Paid order(s) in day " + day + ": \n" + paid);
        System.out.println("Unpaid order(s) in day " + day + ": \n" + unpaid);
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class getOrderInfo extends Order {
    public getOrderInfo(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void getOrder() {
        ArrayList<String> order_arr = new ArrayList<String>();
        ArrayList<String> name_arr = new ArrayList<String>();
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        while (!valid) {
            System.out.println("Enter the customer ID: ");
            String ID = scanner.nextLine();
            for (int i = 0; i < getOrders_data().size(); i++) {
                String[] arr = getOrders_data().get(i).split(",");
                name_arr.add(arr[3]);
                if (ID.equals(arr[3])) {
                    order_arr.add(getOrders_data().get(i));
                }
            }
            if (name_arr.contains(ID) == false) {
                System.out.println("No ID matched ");
                valid = false;
            } else {
                for (int i = 0; i < order_arr.size(); i++) {
                    String[] arr = order_arr.get(i).split(",");
                    System.out.println("Order Id: " + arr[0] + ", Items: " + arr[1] + ", Total price: " + arr[2] + ", Customer id: " + arr[3]
                            + ", Phone number: " + arr[4] + ", Email: " + arr[5] + ", Address: " + arr[6] + ", Date: " + arr[7] + ", Status: " + arr[8]);
                }
                valid = true;
            }
        }
    }
}

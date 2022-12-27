import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class changeOrderStatus extends Order {
    public changeOrderStatus(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void changeStatus() {
        ArrayList<String> id_arr = new ArrayList<String>();
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] arr = getOrders_data().get(i).split(",");
            id_arr.add(arr[0]);
        }
        while (!valid) {
            System.out.println("Enter the order ID: ");
            String ID = scanner.nextLine();
            if (id_arr.contains(ID) == false) {
                System.out.println("No ID matched ");
                valid = false;
            }
            else {
                int i = id_arr.indexOf(ID);
                String[] arr = getOrders_data().get(i).split(",");
                System.out.println("Change status of order to:" +
                                "\n1 paid" +
                                "\n2 unpaid");
                int opt = scanner.nextInt();
                if(opt == 1) {
                    arr[8] = "paid";
                } else if (opt == 2) {
                    arr[8] = "unpaid";
                } else {
                    System.out.println("Input invalid!");
                }
                String new_data = arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]+","+arr[5]+","+arr[6]+","+arr[7]+","+arr[8];
                getOrders_data().set(i,new_data);
                System.out.println("Update order's status successfully!");
                System.out.println(getOrders_data().get(i));
                valid = true;
            }
        }
    }
}

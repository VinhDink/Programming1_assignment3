import java.util.ArrayList;
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
        StringBuilder title = new StringBuilder();

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
            if (!name_arr.contains(ID)) {
                System.out.println("No ID matched ");
                valid = false;
            } else {
                System.out.printf("%-10s%-40s%-15s%-20s%-15s%-30s%-30s%-15s%-10s\n",
                        "Order ID", "Title", "Price", "Customer ID", "Phone", "Email address", "Address", "Order date", "Status");
                System.out.println("----------------------------------------------------" +
                        "-------------------------------------------------------------------------------" +
                        "---------------------------------------------------");
                for (int i = 0; i < order_arr.size(); i++) {
                    String[] arr = order_arr.get(i).split(",");
                    String a = arr[1].replace("[", "");
                    String b = a.replace("]", "");
                    String[] split1 = b.split(";");
                    if (split1.length > 2) {
                        title.append(String.format("%s, %s,...", split1[0], split1[1]));
                    } else if (split1.length == 2){
                        title.append(String.format("%s, %s", split1[0], split1[1]));
                    } else {
                        title.append(String.format("%s", split1[0]));
                    }
                    System.out.printf("%-10s%-40s%-15s%-20s%-15s%-30s%-30s%-15s%-10s\n",
                            arr[0], title, arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]);
                    title.delete(0, title.length());
                }
                valid = true;
            }
        }
    }
}

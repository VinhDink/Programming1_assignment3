import java.util.ArrayList;
import java.util.Arrays;

public class viewOrders extends Order {


    public viewOrders(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void viewOrdersInfo() {
        StringBuilder title = new StringBuilder();
        System.out.printf("%-10s%-40s%-15s%-20s%-15s%-30s%-30s%-15s%-10s\n",
                "Order ID", "Title", "Price", "Customer ID", "Phone", "Email address", "Address", "Order date", "Status");
        System.out.println("----------------------------------------------------" +
                "-------------------------------------------------------------------------------" +
                "---------------------------------------------------");
        for (int i = 0; i < getOrders_data().size();i++)
        {
            String[] split = getOrders_data().get(i).split(",");
            if (split[1].contains("[")) {
                String a = split[1].replace("[", "");
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
                        split[0], title, split[2], split[3], split[4], split[5], split[6], split[7], split[8]);
                title.delete(0, title.length());
            } else {
                System.out.printf("%-10s%-40s%-15s%-20s%-15s%-30s%-30s%-15s%-10s\n",
                        split[0], split[1], split[2], split[3], split[4], split[5], split[6], split[7], split[8]);
            }
        }
        System.out.println("Total orders: " + getOrders_data().size());
    }
}

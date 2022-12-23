import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class viewOrders extends Order {


    public viewOrders(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void viewOrdersInfo() {
        for (int i = 0; i < getOrders_data().size();i++)
        {
            System.out.println("Order "+i+": " +  getOrders_data().get(i));
        }
    }
}

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class viewProducts extends Product {

    public viewProducts(ArrayList<String> items_data) {
        super(items_data);
    }

    public void viewProdsInfo() {
        for (int i = 0; i < getItems_data().size();i++)
        {
            System.out.println("Item "+i+": " +  getItems_data().get(i));
        }
    }
}

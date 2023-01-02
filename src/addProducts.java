import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
public class addProducts extends Product {
    static PrintWriter pw = null;
    static Scanner fileScanner =  null;

    //Constructor

    public addProducts(ArrayList<String> items_data) {
        super(items_data);
    }


    public void add() {
        int a = 0;
        ArrayList<String> name_arr = new ArrayList<String>();
        for (int i = 0; i < getItems_data().size(); i++) {
            String[] arr = getItems_data().get(i).split(",");
            a = i+1;
            name_arr.add(arr[1]);
        }
        String index = Integer.toString(a+1);
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.println("Enter name for product(name must be unique)");
            String name = scanner.nextLine();
            System.out.println("Enter product's price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter product's category: ");
            String category = scanner.nextLine();
            System.out.println("Enter product's amount: ");
            int amount = scanner.nextInt();
            if (name_arr.contains(name)) {
                System.out.println("Name taken!");
                valid = false;
            } else {
                getItems_data().add("item_" + index+ "," + name + "," + price + "," + category + "," + amount);
                valid = true;
            }
        }
    }
}

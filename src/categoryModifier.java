import java.util.ArrayList;
import java.util.Scanner;

public class categoryModifier extends Product{
    public categoryModifier(ArrayList<String> items_data) {
        super(items_data);
    }
    public void removeCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a category to remove:");
        String category = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < getItems_data().size(); i++) {
            String[] item_arr = getItems_data().get(i).split(",");
            if (item_arr[3].equals(category)) {
                String new_data = item_arr[0]+","+item_arr[1]+","+item_arr[2]+","+"none";
                getItems_data().set(i,new_data);
                found = true;
            }
        }
        if (!found) {
            System.out.println("There is no item with the category: " + category);
        } else {
            System.out.println("Category: " + category +" has been removed!");
        }
    }
    public void addCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name or ID:");
        String product = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < getItems_data().size(); i++) {
            String[] item_arr = getItems_data().get(i).split(",");
            if (item_arr[0].equals(product) || item_arr[1].equals(product)) {
                found = true;
                if (item_arr[3].equals("none")) {
                    System.out.println(item_arr[1] + " does not have a category yet, enter a category to add: ");
                    String category = scanner.nextLine();
                    String new_data = item_arr[0]+","+item_arr[1]+","+item_arr[2]+","+ category;
                    getItems_data().set(i,new_data);
                    System.out.println(item_arr[1] + " is now in category " + category);
                } else {
                    System.out.println("Product " + item_arr[1] + " is already in category: " + item_arr[3]);
                }
            }
        }
        if (!found) {
                System.out.println("There is no item with the name or ID: " + product);
        }
    }
}

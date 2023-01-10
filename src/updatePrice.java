import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class updatePrice extends Product{
    //Constructor
    public updatePrice(ArrayList<String> items_data) {
        super(items_data);
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> id_arr = new ArrayList<String>();
        ArrayList<String> name_arr = new ArrayList<String>();
        ArrayList<String> category_arr = new ArrayList<String>();
        ArrayList<String> amount_arr = new ArrayList<String>();
        boolean valid = false;
        boolean correct = false;
        for (int i = 0; i < getItems_data().size(); i++) {
            String[] arr = getItems_data().get(i).split(",");
            id_arr.add(arr[0]);
            name_arr.add(arr[1]);
            category_arr.add(arr[3]);
            amount_arr.add(arr[4]);
        }
        while (!valid) {
            System.out.println("Enter id of the product you want to change price:");
            String ID = scanner.nextLine();
            double price = 0;
            while (!correct) {
                try {
                    System.out.println("Enter new price:");
                    price = scanner.nextInt();
                    correct = true;
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Invalid parameter!");
                }
            }
            if (!id_arr.contains(ID)) {
                System.out.println("No item matched with that id: " + ID);
                valid = true;
            }else {
                int i = id_arr.indexOf(ID);
                String new_data  = ID+","+name_arr.get(i)+","+price+","+category_arr.get(i)+","+amount_arr.get(i);
                getItems_data().set(i,new_data);
                valid = true;
                System.out.println("Update price successfully!");
            }
        }
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class updatePrice extends Product{
    static PrintWriter pw = null;
    static Scanner fileScanner =  null;

    //Constructor
    public updatePrice(ArrayList<String> items_data) {
        super(items_data);
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> id_arr = new ArrayList<String>();
        ArrayList<String> name_arr = new ArrayList<String>();
        ArrayList<String> category_arr = new ArrayList<String>();
        boolean valid = false;
        for (int i = 0; i < getItems_data().size(); i++) {
            String[] arr = getItems_data().get(i).split(",");
            id_arr.add(arr[0]);
            name_arr.add(arr[1]);
            category_arr.add(arr[3]);
        }
        while (!valid) {
            System.out.println("Enter id of the product you want to change price: ");
            String ID = scanner.nextLine();
            System.out.println("Enter new price:");
            double price = scanner.nextDouble();
            scanner.nextLine();
            if (id_arr.contains(ID) == false) {
                System.out.println("No item matched with that id: ");
                valid = false;
            }else {
                int i = id_arr.indexOf(ID);
                String new_data  = ID+","+name_arr.get(i)+","+price+","+category_arr.get(i);
                getItems_data().set(i,new_data);
                valid = true;
                System.out.println("Update price successfully!");
            }
        }
        try {
            fileScanner = new Scanner(new File("src/data/items.txt"));
            pw = new PrintWriter(new FileWriter("src/data/items.txt", false));
            for (int i = 0; i < getItems_data().size(); i++) {
                pw.write(getItems_data().get(i));
                pw.write("\r\n");
            }
        }catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        finally {
            if (pw != null) {
                pw.close();
            }
            fileScanner.close();
        }
    }
}

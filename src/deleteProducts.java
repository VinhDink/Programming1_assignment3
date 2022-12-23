import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class deleteProducts extends Product {
    static PrintWriter pw = null;
    static Scanner fileScanner =  null;
    //Constructor
    public deleteProducts(ArrayList<String> items_data) {
        super(items_data);
    }

    public void delete() {
            ArrayList<String> id_arr = new ArrayList<String>();
            Scanner scanner = new Scanner(System.in);
            boolean valid = false;
            System.out.println("Enter the ID of the product you want to delete:");
            String ID = scanner.nextLine();
            for (int i = 0; i < getItems_data().size(); i++) {
                String[] arr = getItems_data().get(i).split(",");
                id_arr.add(arr[0]);
            }
                while (!valid) {
                    if (id_arr.contains(ID)==false) {
                        System.out.println("No item matched with that id: ");
                        valid = false;
                    } else {
                        int i = id_arr.indexOf(ID);
                        getItems_data().remove(i);
                        System.out.println("Delete product succesfully");
                        valid = true;
                    }
            }    try {
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



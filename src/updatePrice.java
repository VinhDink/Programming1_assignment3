import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class updatePrice {
    static PrintWriter pw = null;
    static Scanner fileScanner =  null;

    public static void update() {
        try {
            fileScanner = new Scanner(new File("src/data/items.txt"));
            File original = new File("src/data/items.txt");
            File temp = new File("src/data/temp.txt");
            temp.createNewFile();
            pw = new PrintWriter(new FileWriter("src/data/temp.txt", false));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the product id you want to change price: ");
            String id = scanner.nextLine();
            System.out.println("Enter new price:");
            ArrayList<String> id_arr = new ArrayList<String>();
            double price = scanner.nextDouble();
            while (fileScanner.hasNext()) {
                String[] arr = fileScanner.nextLine().split(",");
                id_arr.add(arr[0]);
                if (arr[0].equals(id) == false) {
                    pw.write(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]);
                    pw.write("\r\n");
                }
                else {
                    pw.write(arr[0]+","+arr[1]+","+price+","+arr[3]);
                    pw.write("\r\n");
                    System.out.println("Price has been updated!");
                }
                temp.renameTo(original);
            }
            if (id_arr.contains(id) == false) {
                System.out.println("No item matched with that id: ");
            }
        }
        catch (IOException ioe) {
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

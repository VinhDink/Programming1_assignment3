import javax.sound.midi.SysexMessage;
import javax.swing.border.TitledBorder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class addProducts {
    static PrintWriter pw = null;
    static Scanner fileScanner =  null;

    //Constructor

    public static void add() {
        try {
            fileScanner = new Scanner(new File("src/data/items.txt"));
            ArrayList<String> name_arr = new ArrayList<String>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Set name for product (name must be unique!)");
            String title = scanner.nextLine();
            System.out.println("Set a category");
            String category = scanner.nextLine();
            System.out.println("Set a price");
            double price = scanner.nextDouble();
            pw = new PrintWriter(new FileWriter("src/data/items.txt", true));
            int i = 0;
            while (fileScanner.hasNext()) {
                String[] arr = fileScanner.nextLine().split(",");
                name_arr.add(arr[1]);
                i++;
            }
            if (name_arr.contains(title) == true) {
                System.out.println("name already exist!");
            } else {
                pw.write("\r\n");
                pw.write("Item_"+i+1+",");
                pw.write(title +",");
                pw.write(price+",");
                pw.write(category);
                System.out.println("Add product successfully!");
            }

        }
        catch(IOException ioe) {
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

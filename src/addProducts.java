import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class addProducts {
    static PrintWriter pw = null;
    static Scanner fileScanner =  null;

    public static void add() {
        try {
            fileScanner = new Scanner(new File("src/data/items.txt"));
            Scanner scanner = new Scanner(System.in);
            boolean status;
            System.out.println("Set ID for product (ID must be unique!)");
            String ID = scanner.nextLine();
            System.out.println("Set name for product (name must be unique!)");
            String name = scanner.nextLine();
            System.out.println("Set a category");
            String category = scanner.nextLine();
            System.out.println("Set a price");
            String price = scanner.nextLine();
            ArrayList<String> id_arr = new ArrayList<String>();
            ArrayList<String> name_arr = new ArrayList<String>();
            pw = new PrintWriter(new FileWriter("src/data/items.txt", true));
            while (fileScanner.hasNext()) {
                String[] arr = fileScanner.nextLine().split(",");
                id_arr.add(arr[0]);
                name_arr.add(arr[1]);
            }
            if (id_arr.contains(ID) == true ) {
                System.out.println("ID already exist!");
            } else if (name_arr.contains(name) == true) {
                System.out.println("name already exist!");
            } else {
                pw.write("\r\n");
                pw.write(ID+",");
                pw.write(name+",");
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

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class viewProducts {
    static Scanner fileScanner = null;


    public static void viewProdsInfo() {
        try {
            fileScanner = new Scanner(new File("src/data/items.txt"));
            int i = 1;
            while (fileScanner.hasNext()) {
                String prods = fileScanner.nextLine();
                System.out.println("Product " + i++ +":  "+ prods);
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        finally {
            fileScanner.close();
        }
    }
}

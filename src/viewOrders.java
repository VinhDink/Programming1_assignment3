import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class viewOrders {
    static Scanner fileScanner = null;

    //Constructor

    public static void viewOrdersInfo() {
        try {
            fileScanner = new Scanner(new File("src/data/orders.txt"));
            int i = 1;
            while (fileScanner.hasNext()) {
                String orders = fileScanner.nextLine();
                System.out.println("Orders " + i++ +":  "+ orders);
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

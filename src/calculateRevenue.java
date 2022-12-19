import java.io.*;
import java.util.Scanner;
public class calculateRevenue {
    static Scanner fileScanner = null;

    public static void totalRevenue() {
        try {
            String ordersPath = "src/data/orders.txt";
            fileScanner = new Scanner(new File(ordersPath));
            double total = 0;

            while (fileScanner.hasNext()) {
                String[] data = fileScanner.nextLine().split(",");
                total += Double.parseDouble(data[2]);
            }
            System.out.printf("%.3f VND\n", total);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } finally {
            fileScanner.close();
        }

    }
}

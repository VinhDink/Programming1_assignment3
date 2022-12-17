import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class deleteProducts {
    static Scanner fileScanner =  null;
    static PrintWriter pw = null;

    public static void delete() {
        try {
            fileScanner = new Scanner(new File("src/data/items.txt"));
            ArrayList<String> id_arr = new ArrayList<String>();
            File original = new File("src/data/items.txt");
            File temp = new File("src/data/temp.txt");
            boolean status;
            temp.createNewFile();
            pw = new PrintWriter(new FileWriter("src/data/temp.txt", false));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the ID of the product you want to delete:");
            String ID = scanner.nextLine();
            while (fileScanner.hasNext()) {
                String[] arr = fileScanner.nextLine().split(",");
                if (ID.equals(arr[0]) == false) {
                    pw.write(arr[0]+","+arr[1]+","+arr[2]+","+arr[3]);
                    pw.write("\r\n");
                    status = true;
                }
            }
            if (status = true) {
                System.out.println("Delete product succesfully");
            }
            original.delete();
            temp.renameTo(original);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } finally {
            if (pw != null) {
                pw.close();
            }
            fileScanner.close();
        }
    }
}

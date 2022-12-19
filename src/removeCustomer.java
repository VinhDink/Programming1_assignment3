import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class removeCustomer {
    static Scanner fileScanner =  null;
    static PrintWriter pw = null;

    public static void remove() {
        String OriginalPath = "src/data/customers.txt";
        String tempPath = "src/data/temp.txt";
        try {
            fileScanner = new Scanner(new File(OriginalPath));
            File originalFile = new File(OriginalPath);
            File temp = new File(tempPath);
            boolean status = false;
            temp.createNewFile();
            pw = new PrintWriter(new FileWriter(tempPath, false));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Customer ID to remove:");
            String ID = scanner.nextLine();
            while (fileScanner.hasNext()) {
                String[] data = fileScanner.nextLine().split(",");
                if (ID.equals(data[0]) == false) {
                    pw.write(data[0]+","+data[1]+","+data[2]+","+data[3]+","+data[4]+","+data[5]+","+data[6]);
                    pw.write("\r\n");
                    status = true;
                }
            }
            if (status == true) {
                System.out.println("Customer with ID: " + ID +" has been deleted!");
            }
            fileScanner.close();
            pw.flush();
            pw.close();
            originalFile.delete();
            File temp2 = new File(OriginalPath);
            temp.renameTo(temp2);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
}

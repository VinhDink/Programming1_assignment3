import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class viewMembers {
    static Scanner fileScanner = null;

    public static void viewMembersInfo() {
        try {
            fileScanner = new Scanner(new File("src/data/customers.txt"));
            int i = 1;
            while (fileScanner.hasNext()) {
                String member = fileScanner.nextLine();
                System.out.println("Members " + i++ +":  "+ member);
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

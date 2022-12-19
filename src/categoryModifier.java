import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class categoryModifier {
    static Scanner fileScanner =  null;
    static PrintWriter pw = null;
    public static void removeCategory() {
        String OriginalPath = "src/data/items.txt";
        String tempPath = "src/data/temp.txt";
        try {
            fileScanner = new Scanner(new File(OriginalPath));
            File originalFile = new File(OriginalPath);
            File temp = new File(tempPath);
            boolean found = false;
            temp.createNewFile();
            pw = new PrintWriter(new FileWriter(tempPath, false));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a category to remove:");
            String category = scanner.nextLine();
            while (fileScanner.hasNext()) {
                String[] data = fileScanner.nextLine().split(",");
                if (category.equals(data[3]) == true) {
                    pw.write(data[0]+","+data[1]+","+data[2]+","+"none\n");
                    found = true;
                } else {
                    pw.write(data[0]+","+data[1]+","+data[2]+","+data[3] + "\n");
                }
            }
            if (found == true) {
                System.out.println("Category: " + category +" has been removed!");
            } else {
                System.out.println("There is no item with the category: " + category);
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

    public static void addCategory() {
        Scanner fileScanner =  null;
        PrintWriter pw = null;

        String OriginalPath = "src/items.txt";
        String tempPath = "src/temp.txt";
        try {
            fileScanner = new Scanner(new File(OriginalPath));
            File originalFile = new File(OriginalPath);
            File temp = new File(tempPath);
            boolean found = false;
            temp.createNewFile();
            pw = new PrintWriter(new FileWriter(tempPath, false));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter an item name or ID to add category:");
            String searchTerm = scanner.nextLine();
            while (fileScanner.hasNext()) {
                String[] data = fileScanner.nextLine().split(",");
                if (searchTerm.equals(data[0]) == true || searchTerm.equals(data[1]) == true) {
                    found = true;
                    if (data[3].equals("none")) {
                        System.out.println(data[1] + " does not have a category yet, enter a category to add: ");
                        String category = scanner.nextLine();

                        pw.write(data[0]+","+data[1]+","+data[2]+","+ category + "\n");
                        System.out.println(data[1] + " is now in category " + category);
                    } else {
                        System.out.println(data[1] + " is already in category "+ data[3]);
                        pw.write(data[0]+","+data[1]+","+data[2]+","+data[3]+"\n");
                    }
                } else {
                    pw.write(data[0]+","+data[1]+","+data[2]+","+data[3]+"\n");
                }
            }
            if (found == false) {
                System.out.println("There is no item with the name or ID: " + searchTerm);
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

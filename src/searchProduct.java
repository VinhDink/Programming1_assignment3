import java.util.ArrayList;
import java.util.Scanner;

public class searchProduct extends Product{
    public searchProduct(ArrayList<String> items_data) {
        super(items_data);
    }
    public void search(ArrayList<String> item_data) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> cate = new ArrayList<>();
        ArrayList<String> item = new ArrayList<>();
        boolean matched = false;

        System.out.println("Our available categories:");
        for (String i : item_data) {
            String[] split = i.split(",");
            if (!cate.contains(split[3].toLowerCase())) {
                cate.add(split[3].toLowerCase());
                System.out.printf("%s\t",split[3]);
            }
        }

        System.out.println();
        do {
            //choose a category
            System.out.println("Enter the category:");
            String answer = sc.nextLine();
            if (cate.contains(answer.toLowerCase())) {
                System.out.printf("Our products of %s:\n", answer);
                System.out.printf("%-15s%-30s%-10s%-15s%-10s\n",
                        "ID", "Title", "Price", "Category", "In Stock");
                for (String i : item_data) {
                    if (i.toLowerCase().contains(answer.toLowerCase())) {
                        String[] split = i.split(",");
                        System.out.printf("%-15s%-30s%-10s%-15s%-10s\n",
                                split[0], split[1], split[2], split[3], split[4]);
                        item.add(i);
                    }
                }
            } else {
                System.out.println("We do not have this category! Please try again!");
                continue;
            }

            //choose the price range
            double low, high;
            System.out.println("Please enter the price range, the lowest value and the highest value:");
            low = sc.nextDouble();
            high = sc.nextDouble();
            System.out.printf("Our products of %s, from %.3f to %.3f:\n", answer, low, high);
            System.out.printf("%-15s%-30s%-10s%-15s%-10s\n",
                    "ID", "Title", "Price", "Category", "In Stock");
            for (String i : item) {
                String[] split = i.split(",");
                double price = Double.parseDouble(split[2]);
                if (price>=low && price<=high) {
                    System.out.printf("%-15s%-30s%-10s%-15s%-10s\n",
                            split[0], split[1], split[2], split[3], split[4]);
                    matched = true;
                }
            }
            if (!matched) {
                System.out.println("No item matches the range!\n");
            }
            System.out.println();
            System.out.printf("Our products from %.3f to %.3f:\n", low, high);
            System.out.printf("%-15s%-30s%-10s%-15s%-10s\n",
                    "ID", "Title", "Price", "Category", "In Stock");
            for (String i : item_data) {
                String[] split = i.split(",");
                double price = Double.parseDouble(split[2]);
                if (price>=low && price<=high) {
                    System.out.printf("%-15s%-30s%-10s%-15s%-10s\n",
                            split[0], split[1], split[2], split[3], split[4]);
                    matched = true;
                }
            }

            if (!matched) {
                System.out.println("No item matches the range!\n");
                matched = true;
            }

        } while (!matched);


    }
}

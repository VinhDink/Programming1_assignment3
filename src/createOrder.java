import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class createOrder extends Product{
    public ArrayList<String> customer_data;
    public createOrder(ArrayList<String> customer_data, ArrayList<String> items_data) {
        super(items_data);
        this.customer_data = customer_data;
    }

    public void createOrder(ArrayList<String> item_data, ArrayList<String> order_data, ArrayList<String> customer_data)
            throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean matched = false;
        String membership;
        double discount = 0;
        double totalPrice = 0;
        String customerID = null, phone = null, email = null, address = null;
        LocalDate date = LocalDate.now();
        ArrayList<String> item = new ArrayList<>();

        //view customer info and membership
        System.out.println("Please enter your customerID:");
        do {
            String ans = sc.nextLine();
            for (String i : customer_data) {
                String[] split = i.split(",");
                if (split[0].equals(ans)) {
                    customerID = split[0];
                    phone = split[4];
                    email = split[5];
                    address = split[6];

                    //print customer info
                    System.out.println("Your information:");
                    for (String j : split) {
                        System.out.printf("%s\t", j);
                    }
                    System.out.println("");
                    //apply discount
                    membership = split[7];
                    if (membership.equals("Silver")) {
                        System.out.println("Your discount is 5%");
                        discount = 0.95;
                    } else if (membership.equals("Gold")) {
                        System.out.println("Your discount is 10%");
                        discount = 0.90;
                    } else {
                        System.out.println("Your discount is 15%");
                        discount = 0.85;
                    }
                    matched = true;
                }
            }
            if (matched) {
                //print products
                System.out.println("\nOUR PRODUCT");
                System.out.printf("%-15s%-30s%-10s%-15s%-10s\n", "ID", "Title", "Price", "Category", "In Stock");
                for (String i : item_data) {
                    String[] split = i.split(",");
                    for (String a : split) {
                        System.out.printf("%-15s%-30s%-10s%-15s%-10s\n",
                                split[0], split[1], split[2], split[3], split[4]);
                        break;
                    }
                }
                System.out.println("");
            } else {
                System.out.println("Your ID is not initialized, please try again!");
            }
        } while (!matched);


        //create order
        boolean available = false;
        do{
            System.out.println("Enter the productID of product that you want to purchase:");
            String ans = sc.nextLine();
            for (String a : item_data) {
                String[] split = a.split(",");
                if (split[0].equals(ans)) {

                    //display item
                    System.out.println("");
                    System.out.println("Your item is");
                    for (String i : split) {
                        if (i.equals(split[4])) continue;
                        System.out.printf("%s\t", i);
                    }

                    //display item after applying discount
                    System.out.println("\n");
                    System.out.println("After applying discount, your item is");
                    totalPrice += Double.parseDouble(split[2]) * discount;
                    split[2] = String.valueOf(Double.parseDouble(split[2]) * discount);
                    item.add(split[1]);
                    for (String i : split) {
                        if (i.equals(split[4])) continue;
                        System.out.printf("%s\t", i);
                    }
                }
            }
            //more items?
            System.out.println("\nDo you want to continue shopping? (Yes/No)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
                continue;
            }

            //paid or unpaid?
            System.out.println("\nHow do you want to purchase? (COD/Online Banking)");
            String paymentMethod = sc.nextLine();
            String status;
            if (paymentMethod.charAt(0) == 'C' || paymentMethod.charAt(0) == 'c') {
                status = "unpaid";
            } else {
                status = "paid";
            }

            //write new order to orders-data arraylist
            int orderId = order_data.size(); //the id of order
            order_data.add(String.format("%d,%s,%.3f,%s,%s,%s,%s,%s,%s",
                    orderId, item, totalPrice, customerID, phone, email, address, date, status));
            setItems_data(order_data);
            available = true;

            if (available) {
                System.out.println("\nYour order is processing...\nCreate Order successfully!");
            } else {
                System.out.println("This product does not exist! Please try again!");
            }
        } while (!available);
    }
}

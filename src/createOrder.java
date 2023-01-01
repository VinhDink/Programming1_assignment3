import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
        PrintWriter pw = null;
        boolean matched = false;
        String resultCustomer = null;
        String membership = null;
        double discount = 0;
        double newPrice = 0;
        Date date = new Date();

        //view customer info and membership
        System.out.println("Please enter your customerID:");
        do {
            String ans = sc.nextLine();
            for (String i : customer_data) {
                String[] split = i.split(",");
                if (split[0].equals(ans)) {
                    resultCustomer = String.format("%s, %s, %s, %s",
                            split[0], split[4], split[5], split[6]); //prepare to add to data files
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
        System.out.println("Enter the productID of product that you want to purchase:");
        boolean available = false;
        do{
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
                    String result = String.format("%s,%s", split[1], split[2]);
                    newPrice = Double.parseDouble(split[2])*discount;
                    split[2] = String.valueOf(newPrice);
                    for (String i : split) {
                        if (i.equals(split[4])) continue;
                        System.out.printf("%s\t", i);
                    }

                    //paid or unpaid?
                    System.out.println("\nHow do you want to purchase? (COD/Online Banking)");
                    String an = sc.nextLine();
                    String status = null;
                    if (an.charAt(0) == 'C' || an.charAt(0) == 'c') {
                        status = "unpaid";
                    } else {status = "paid";}
                    //write new order to orders.txt
                    try {
                        pw = new PrintWriter(new FileWriter("src/data/orders.txt", true));
                        int orderId = order_data.size(); //the id of order
                        String d = String.valueOf(date);
                        if (orderId == 5) {
                            pw.println("");
                        }
                        pw.printf("%d,%s,%s,%s,%s\n", orderId, result, resultCustomer, d, status); //add order info
                    }
                    catch (IOException ioe) {
                        System.err.println(ioe.getMessage());
                    }
                    finally {
                        if (pw != null) {
                            pw.close();
                        }
                    }
                    available = true;
                }
            }
            if (available) {
                System.out.println("\nYour order is processing...\nCreate Order successfully!");
            } else {
                System.out.println("This product does not exist! Please try again!");
            }
        } while (!available);
    }
}

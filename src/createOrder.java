/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Ha Thuy Chi
  ID: s3930417
  Acknowledgement: None
*/

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class createOrder extends Customer{
    public createOrder(ArrayList<String> customer_data, String username, String password) {
        super(customer_data, username, password);
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
        String customerUsername = getUsername();
        do {
            for (String i : customer_data) {
                String[] split = i.split(",");
                if (split[1].equals(customerUsername)) {
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
                    } else if (membership.equals("Platinum")){
                        System.out.println("Your discount is 15%");
                        discount = 0.85;
                    } else {
                        discount = 1;
                        System.out.println("Your discount is 0%");
                    }
                    matched = true;
                }
            }
            if (matched) {
                //print products
                System.out.println("\nOUR PRODUCT");
                System.out.printf("%-15s%-30s%-10s%-15s%-10s\n", "ID", "Title", "Price", "Category", "In Stock");
                System.out.println("--------------------------------------------------------------------------------");
                for (String i : item_data) {
                    String[] split = i.split(",");
                    System.out.printf("%-15s%-30s%-10s%-15s%-10s\n",
                            split[0], split[1], split[2], split[3], split[4]);
                }
                System.out.println();
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
                    //update in stock value of item_data arraylist
                    int inStock = Integer.parseInt(split[4]);
                    split[4] = String.valueOf(inStock-1);
                    item_data.set(item_data.indexOf(a),String.format("%s,%s,%s,%s,%s",
                            split[0], split[1], split[2], split[3], split[4]));


                    //display item
                    System.out.println("");
                    System.out.println("Your item is");
                    for (String i : split) {
                        if (i.equals(split[4])) continue;
                        System.out.printf("%s\t", i);
                    }

                    //display item after applying discount
                    System.out.println("\n-------------------------------------");
                    System.out.println("After applying discount, your item is");
                    totalPrice += Double.parseDouble(split[2]) * discount;
                    split[2] = String.valueOf(Double.parseDouble(split[2]) * discount);
                    item.add(split[1]);//add item to a list for order_data update
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
            //write new order to orders-data arraylist
            int orderId = order_data.size(); //the id of order
            String semicolonSeparated = item.toString().replace(",", ";"); //change separator
            order_data.add(String.format("order_id%d,%s,%.3f,%s,%s,%s,%s,%s,Processing",
                    orderId, semicolonSeparated, totalPrice, customerID, phone, email, address, date));
            available = true;

            if (available) {
                System.out.println("\nYour order is processing...\nCreate Order successfully!");
                String id = null;
                ArrayList<String> id_arr = new ArrayList<String>();
                double total = 0;
                for (int i = 0; i < customer_data.size(); i++) {
                    String[] arr = customer_data.get(i).split(",");
                    id_arr.add(arr[0]);
                    if (arr[1].equals(getUsername())) {
                        id = arr[0];
                    }
                };
                for (int i = 0; i < order_data.size(); i++) {
                    String[] arr = order_data.get(i).split(",");
                    if (arr[3].equals(id)) {
                        total += Double.parseDouble(arr[2]);
                    }
                };
                for (int i = 0; i < customer_data.size(); i++) {
                    String[] arr = customer_data.get(i).split(",");
                    if (arr[0].equals(id)) {
                        if (total > 25000.000) {
                            arr[7] = "Platinum";
                            int j = id_arr.indexOf(id);
                            String new_data = arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]+","+arr[5]+","+arr[6]+","+arr[7];
                            getCustomer_data().set(j,new_data);
                        } else if (total > 10000.000) {
                            arr[7] = "Gold";
                            int j = id_arr.indexOf(id);
                            String new_data = arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]+","+arr[5]+","+arr[6]+","+arr[7];
                            getCustomer_data().set(j,new_data);
                        } else if (total > 5000.000) {
                            arr[7] = "Silver";
                            int j = id_arr.indexOf(id);
                            String new_data = arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]+","+arr[5]+","+arr[6]+","+arr[7];
                            getCustomer_data().set(j,new_data);
                        } else {
                            arr[7] = "Basic";
                            int j = id_arr.indexOf(id);
                            String new_data = arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]+","+arr[5]+","+arr[6]+","+arr[7];
                            getCustomer_data().set(j,new_data);
                        }
                    }
                }
            } else {
                System.out.println("This product does not exist! Please try again!");
            }
        } while (!available);
    }
}
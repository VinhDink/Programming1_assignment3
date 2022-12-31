import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static PrintWriter pw = null;
    static PrintWriter pw2 = null;
    static Scanner fileScanner =  null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Scanner items_file = new Scanner(new File("src/data/items.txt"));
            ArrayList<String> items_data = new ArrayList<String>();
            while (items_file.hasNext()) {
                String data = items_file.nextLine();
                items_data.add(data);
            }
            Scanner orders_file = new Scanner(new File("src/data/orders.txt"));
            ArrayList<String> orders_data = new ArrayList<String>();
            while (orders_file.hasNext()) {
                String data = orders_file.nextLine();
                orders_data.add(data);
            }
            Scanner customers_file = new Scanner(new File("src/data/customers.txt"));
            ArrayList<String> customer_data = new ArrayList<String>();
            while (customers_file.hasNext()) {
                String data = customers_file.nextLine();
                customer_data.add(data);
            }
            System.out.println("COSC2081 GROUP ASSIGNMENT\n" +
                    "STORE ORDER MANAGEMENT SYSTEM\n" +
                    "Instructor: Mr. Tom Huynh & Dr. Phong Ngo\n" +
                    "Group: DNV\n" +
                    "s3926232, Dinh Quang Vinh\n" +
                    "sXXXXXXX, Student Name\n" +
                    "sXXXXXXX, Student Name\n" +
                    "s3924871, Nguyen Minh Nhat");
            boolean logged_in = true;
            while (logged_in) {
                System.out.println("Choose the option by enter its index!");
                System.out.println("1 Login as customer\n" + "2 Register as customer \n" + "3 Login as admin \n"
                + "4 Exist");
                int option1 = scanner.nextInt();
                    switch (option1) {
                        case 1:System.out.println("1 View all information\n2 Update information\n3 Check current membership status\n4 List all products \n5 Sort products by price order\n6 Create a new order\n7 View my orders");
                            int customerOption1 = scanner.nextInt();
                            switch (customerOption1) {
                                case 5:
                                    System.out.println("1 Price from low to high\n2 Price from high to low");
                                    int customerOption2 = scanner.nextInt();
                                    switch (customerOption2) {
                                        case 1:
                                            sortPriceAscending ascending = new sortPriceAscending(items_data);
                                            ascending.sortPrice();
                                            break;
                                        case 2:
                                            sortPriceDescending descending = new sortPriceDescending(items_data);
                                            descending.sortPrice();
                                            break;
                                    }
                                }
                        case 3: {
                            System.out.println("Enter your username");
                            String username = scanner.next();
                            System.out.println("Enter your password");
                            String password = scanner.next();
                            Admin admin = new Admin(username, password);
                            if (admin.validateAccount() == true) {
                                boolean active = true;
                                while (active) {
                                    System.out.println("1 View information of all products" +
                                            "\n2 View information of all orders" +
                                            "\n3 View information of all member" +
                                            "\n4 Add product" +
                                            "\n5 Delete product" +
                                            "\n6 Update price" +
                                            "\n7 Get order information by customer ID" +
                                            "\n8 Change order's status" +
                                            "\n9 Return");
                                    int option2 = scanner.nextInt();
                                    switch (option2) {
                                        case 1:
                                            viewProducts prods = new viewProducts(items_data);
                                            prods.viewProdsInfo();
                                            break;
                                        case 2:
                                            viewOrders ords = new viewOrders(orders_data);
                                            ords.viewOrdersInfo();
                                            break;
                                        case 3:
                                            viewMembers mem = new viewMembers(customer_data);
                                            mem.viewCustomerInfo();
                                            break;
                                        case 4:
                                            addProducts addprod = new addProducts(items_data);
                                            addprod.add();
                                            break;
                                        case 5:
                                            deleteProducts deleteprod = new deleteProducts(items_data);
                                            deleteprod.delete();
                                            break;
                                        case 6:
                                            updatePrice update = new updatePrice(items_data);
                                            update.update();
                                            break;
                                        case 7:
                                            getOrderInfo order = new getOrderInfo(orders_data);
                                            order.getOrder();
                                            break;
                                        case 8:
                                            changeOrderStatus ord = new changeOrderStatus(orders_data);
                                            ord.changeStatus();
                                            break;
                                        case 9:
                                            active = false;
                                            logged_in = true;
                                    }
                                }
                            }
                            break;
                        }
                        case 4: logged_in = false;
                            fileScanner = new Scanner(new File("src/data/items.txt"));
                            pw2 = new PrintWriter(new FileWriter("src/data/items.txt", false));
                            for (int i = 0; i < items_data.size(); i++) {
                                pw2.write(items_data.get(i));
                                pw2.write("\r\n");
                            }
                            fileScanner = new Scanner(new File("src/data/orders.txt"));
                            pw = new PrintWriter(new FileWriter("src/data/orders.txt", false));
                            for (int i = 0; i < orders_data.size(); i++) {
                                pw.write(orders_data.get(i));
                                pw.write("\r\n");
                            }
                    }

            }
        }catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }finally {
            if (pw != null) {
                pw.close();
                pw2.close();
            }
            fileScanner.close();
        }
    }
}

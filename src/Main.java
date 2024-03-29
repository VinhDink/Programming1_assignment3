

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static PrintWriter pw = null;
    static PrintWriter pw2 = null;
    static PrintWriter pw3 = null;
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
                    "s3362467, Le Hoang Duong\n" +
                    "s3930417, Ha Thuy Chi\n" +
                    "s3924871, Nguyen Minh Nhat\n" );
            boolean logged_in = true;
            while (logged_in) {
                System.out.println("Choose the option by entering its index!");
                System.out.println("1 Login as customer\n" + "2 Register as customer \n" + "3 Login as admin \n"
                + "4 Exit");
                int option1 = scanner.nextInt();
                    switch (option1) {
                        case 1: {
                            System.out.println("Please enter your username!");
                            String username = scanner.next();
                            System.out.println("Please enter your password!");
                            String password = scanner.next();
                            Customer customer = new Customer(customer_data,username,password);
                            if (customer.validateCustomer() == true) {
                                boolean active1 = true;
                                while (active1) {
                                    currentCustomer current = new currentCustomer(customer_data,username,password);
                                    System.out.println("\n"+"\nWelcome to our Store"+"\n-------------------------------------------------"+"\n1 View all information" +
                                            "\n2 Update information" +
                                            "\n3 Check current membership status" +
                                            "\n4 List all products" +
                                            "\n5 Sort products by price order" +
                                            "\n6 View products by category and price range" +
                                            "\n7 Create a new order" +
                                            "\n8 View my orders" +
                                            "\n9 Exit");
                                    int customerOption1 = scanner.nextInt();
                                    switch (customerOption1) {
                                        case 1:
                                            current.view();
                                            break;
                                        case 2:
                                            current.update();
                                            break;
                                        case 3:
                                            current.checkMembership();
                                            break;
                                        case 4:
                                            viewProducts prods = new viewProducts(items_data);
                                            prods.viewProdsInfo();
                                            break;
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
                                            break;
                                        case 6:
                                            searchProduct search = new searchProduct(items_data);
                                            search.search(items_data);
                                            break;
                                        case 7:
                                            createOrder order = new createOrder(customer_data, username, password);
                                            order.createOrder(items_data, orders_data, customer_data);
                                            break;
                                        case 8:
                                            viewOrder order1 = new viewOrder(customer_data, username, password);
                                            order1.view(orders_data, customer_data);
                                            break;
                                        case 9:
                                            active1 = false;
                                    }
                                }
                            }
                            break;
                        }
                        case 2: {
                            addCustomer newCustomer = new addCustomer(customer_data, null, null);
                            newCustomer.add();
                            break;
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
                                    System.out.println("\n\n-----------------------------------"+"\n1 View information of all products" +
                                            "\n2 View information of all orders" +
                                            "\n3 View information of all member" +
                                            "\n4 Add product" +
                                            "\n5 Delete product" +
                                            "\n6 Update price" +
                                            "\n7 Get order information by customer ID" +
                                            "\n8 Change order's status" +
                                            "\n9 Remove customer by ID:" +
                                            "\n10 Calculate total revenue" +
                                            "\n11 Calculate day revenue" +
                                            "\n12 See most popular product" +
                                            "\n13 See least popular product" +
                                            "\n14 See all order in a particular day" +
                                            "\n15 See list of membership" +
                                            "\n16 Add Category" +
                                            "\n17 Remove Category" +
                                            "\n18 See customer with the most spending" +
                                            "\n19 Return");
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
                                            viewMembers mem = new viewMembers(customer_data,username,password);
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
                                            removeCustomer remove = new removeCustomer(customer_data,username,password);
                                            remove.remove();
                                            break;
                                        case 10:
                                            calculateRevenue cal = new calculateRevenue(orders_data);
                                            cal.totalRevenue();
                                            break;
                                        case 11:
                                            calculateRevenue cal2 = new calculateRevenue(orders_data);
                                            cal2.dayRevenue();
                                            break;
                                        case 12:
                                            popularProduct prod = new popularProduct(orders_data);
                                            prod.mostPopular();
                                            break;
                                        case 13:
                                            popularProduct prod2 = new popularProduct(orders_data);
                                            prod2.leastPopular();
                                            break;
                                        case 14:
                                            dayOrder ord2 = new dayOrder(orders_data);
                                            ord2.executedOrder();
                                            break;
                                        case 15:
                                            membershipList member = new membershipList(customer_data,"","");
                                            member.showList();
                                            break;
                                        case 16:
                                            categoryModifier cate = new categoryModifier(items_data);
                                            cate.addCategory();
                                            break;
                                        case 17:
                                            categoryModifier cate2 = new categoryModifier(items_data);
                                            cate2.removeCategory();
                                            break;
                                        case 18:
                                            customerPay pay = new customerPay(orders_data);
                                            pay.mostPay();
                                            break;
                                        case 19:
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
                            fileScanner = new Scanner(new File("src/data/customers.txt"));
                            pw3 = new PrintWriter(new FileWriter("src/data/customers.txt", false));
                            for (int i = 0; i < customer_data.size(); i++) {
                                pw3.write(customer_data.get(i));
                                pw3.write("\r\n");
                            }
                    }

            }
        }catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }finally {
            if (pw != null) {
                pw.close();
                pw2.close();
                pw3.close();
            }
            fileScanner.close();
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("COSC2081 GROUP ASSIGNMENT\n" +
                "STORE ORDER MANAGEMENT SYSTEM\n" +
                "Instructor: Mr. Tom Huynh & Dr. Phong Ngo\n" +
                "Group: DNV\n" +
                "s3926232, Dinh Quang Vinh\n" +
                "sXXXXXXX, Student Name\n" +
                "sXXXXXXX, Student Name\n" +
                "sXXXXXXX, Student Name");
        System.out.println("Choose the option by enter its index!");
        System.out.println("1 Login as customer\n" + "2 Register as customer \n" + "3 Login as admin");
        int option1 = scanner.nextInt();
        if (option1 == 3) {
            System.out.println("Enter your username");
            String username = scanner.next();
            System.out.println("Enter your password");
            String password = scanner.next();
            Admin admin = new Admin(username, password);
            if (admin.validateAccount() == true) {
                System.out.println("1 View information of all products" +
                        "\n2 View information of all orders" +
                        "\n3 View information of all member" +
                        "\n4 Add product" +
                        "\n5 Delete product" +
                        "\n6 Update price");
                int option2 = scanner.nextInt();
                if (option2 == 1) {
                    viewProducts.viewProdsInfo();
                } else if (option2 == 2) {
                    viewOrders.viewOrdersInfo();
                } else if (option2 == 3) {
                    viewMembers.viewMembersInfo();
                } else if (option2 == 4) {
                    addProducts.add();
                } else if (option2 == 5) {
                    deleteProducts.delete();
                } else if (option2 == 6) {
                    updatePrice.update();
                }
            } else System.out.println("Stop");
        }
    }
}

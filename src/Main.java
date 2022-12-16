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
        int option = scanner.nextInt();
        if (option == 3) {
            System.out.println("Enter your username");
            String username = scanner.next();
            System.out.println("Enter your password");
            String password = scanner.next();
            Admin admin = new Admin(username, password);
            admin.validateAccount();
        } else System.out.println("Stop");

    }
}
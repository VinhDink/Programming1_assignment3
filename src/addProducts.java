/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Dinh Quang Vinh
  ID: s3926232
  Acknowledgement: None
*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class addProducts extends Product {
    public addProducts(ArrayList<String> items_data) {
        super(items_data);
    }
    public void add() {
        int a = 0;
        ArrayList<String> name_arr = new ArrayList<String>();
        for (int i = 0; i < getItems_data().size(); i++) {
            String[] arr = getItems_data().get(i).split(",");
            a = i+1;
            name_arr.add(arr[1]);
        }
        String index = Integer.toString(a+1);
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        boolean correct = false;
        while (!valid) {
            System.out.println("Enter name for product(name must be unique)");
            String name = scanner.nextLine();
            double price = 0;
            while (!correct) {
                try {
                    System.out.println("Enter product's price: ");
                    price = scanner.nextDouble();
                    correct = true;
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Invalid parameter!");
                }
            }
            correct = false;
            scanner.nextLine();
            System.out.println("Enter product's category: ");
            String category = scanner.nextLine();
            int amount = 0;
            while (!correct) {
                try {
                    System.out.println("Enter product's amount: ");
                    amount = scanner.nextInt();
                    correct = true;
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.out.println("Invalid parameter!");
                }
            }
            if (name_arr.contains(name)) {
                System.out.println("Name taken!");
                valid = false;
            } else {
                getItems_data().add("item_" + index+ "," + name + "," + price + "," + category + "," + amount);
                System.out.printf("You just added item: item_%s\t%s\t%.2f\t%s\t%d\n", index, name, price, category, amount);
                valid = true;
            }
        }
    }
}

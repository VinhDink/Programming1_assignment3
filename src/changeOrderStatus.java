
/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Dinh Quang Vinh
  ID: s3926232
  Acknowledgement: None
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class changeOrderStatus extends Order {
    public changeOrderStatus(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void changeStatus() {
        ArrayList<String> id_arr = new ArrayList<String>();
        boolean valid = false;
        boolean correct = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Order list:");
        System.out.println("\n--------------------------------------------------------------------------");
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] arr = getOrders_data().get(i).split(",");
            System.out.println(getOrders_data().get(i));
            System.out.println("\n");
            id_arr.add(arr[0]);
        }
        while (!valid) {
            System.out.println("Enter the order ID: ");
            String ID = scanner.nextLine();
            if (!id_arr.contains(ID)) {
                System.out.println("No ID matched ");
                valid = false;
            }
            else {
                int i = id_arr.indexOf(ID);
                String[] arr = getOrders_data().get(i).split(",");
                while (!correct) {
//                    int opt = 0;
                    try {
                        System.out.println("Change status of order to:" +
                                "\n1 Delivered" +
                                "\n2 Processing");
                        int opt = scanner.nextInt();
                        if(opt == 1) {
                            arr[8] = "Delivered";
                            correct = true;
                        } else if (opt == 2) {
                            arr[8] = "Processing";
                            correct = true;
                        } else {
                            System.out.println("Input invalid!");
                        }
                    } catch (InputMismatchException e) {
                        scanner.nextLine();
                        System.out.println("Invalid parameter!");
                    }

                }
                String new_data = arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+","+arr[4]+","+arr[5]+","+arr[6]+","+arr[7]+","+arr[8];
                getOrders_data().set(i,new_data);
                System.out.println("Update order's status successfully!");
                System.out.println(getOrders_data().get(i));
                valid = true;
            }
        }
    }
}

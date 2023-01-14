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
import java.util.Scanner;

public class deleteProducts extends Product {
    //Constructor
    public deleteProducts(ArrayList<String> items_data) {
        super(items_data);
    }

    public void delete() {
            ArrayList<String> id_arr = new ArrayList<String>();
            Scanner scanner = new Scanner(System.in);
            boolean valid = false;
            for (int i = 0; i < getItems_data().size(); i++) {
                String[] arr = getItems_data().get(i).split(",");
                id_arr.add(arr[0]);
            }
            while (!valid) {
                System.out.println("Enter the ID of the product you want to delete:");
                String ID = scanner.nextLine();
                if (!id_arr.contains(ID)) {
                    System.out.println("No item matched with that id: ");
                    valid = false;
                } else {
                    int i = id_arr.indexOf(ID);
                    getItems_data().remove(i);
                    System.out.println("Delete product successfully");
                    valid = true;
                }
            }
    }
}



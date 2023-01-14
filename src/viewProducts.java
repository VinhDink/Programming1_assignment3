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

public class viewProducts extends Product {

    public viewProducts(ArrayList<String> items_data) {
        super(items_data);
    }

    public void viewProdsInfo() {
        System.out.printf("%-15s%-30s%-10s%-15s%-10s\n", "ID", "Title", "Price", "Category", "In Stock");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < getItems_data().size();i++)
        {
            String[] arr = getItems_data().get(i).split(",");
            System.out.printf("%-15s%-30s%-10s%-15s%-10s\n",
                    arr[0], arr[1], arr[2], arr[3], arr[4]);
        }
    }
}

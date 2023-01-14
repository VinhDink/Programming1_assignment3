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

public class Product {
    private ArrayList<String> items_data;
    //Constructor
    public Product(ArrayList<String> items_data) {
        this.items_data = items_data;
    }
    //Getter

    public ArrayList<String> getItems_data() {
        return items_data;
    }

    //Setter
    public void setItems_data(ArrayList<String> items_data) {
        this.items_data = items_data;
    }
}
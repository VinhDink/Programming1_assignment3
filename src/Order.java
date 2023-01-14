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

public class Order {
    private ArrayList<String> orders_data;
    //Constructor
    public Order(ArrayList<String> orders_data) {
        this.orders_data = orders_data;
    }
    //Getter

    public ArrayList<String> getOrders_data() {
        return orders_data;
    }

    //Setter
    public void setItems_data(ArrayList<String> orders_data) {
        this.orders_data = orders_data;
    }
}


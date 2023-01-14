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

public class Customer {
    private ArrayList<String> customer_data;
    protected String username;
    protected String password;
    //Constructor
    public Customer(ArrayList<String> customer_data,String username,String password) {
        this.customer_data = customer_data;
        this.username = username;
        this.password = password;
    }

    //Getter
    public ArrayList<String> getCustomer_data() {
        return customer_data;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    //Setter
    public void setCustomer_data(ArrayList<String> customer_data) {
        this.customer_data = customer_data;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validateCustomer() {
        ArrayList<String> username_arr = new ArrayList<String>();
        ArrayList<String> password_arr = new ArrayList<String>();
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] arr = customer_data.get(i).split(",");
            username_arr.add(arr[1]);
            password_arr.add(arr[2]);
        }
        if (username_arr.contains(username) == true) {
            int i = username_arr.indexOf(username);
            if (password_arr.get(i).equals(password)) {
                System.out.println("Login successfully!");
                return true;
            } else System.out.println("Wrong password");
        } else System.out.println("Wrong username!");
        return false;
    }
}

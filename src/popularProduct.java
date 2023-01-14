/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Nguyen Minh Nhat
  ID: s3924871
  Acknowledgement: None
*/

import java.util.ArrayList;
import java.util.Arrays;

public class popularProduct extends Order{
    public popularProduct(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void mostPopular() {
        ArrayList<String> item_list = new ArrayList<String>();
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] item_index = getOrders_data().get(i).split(",");
            String str = item_index[1].substring(1, item_index[1].length() - 1);
            String[] item_arr = str.split("; ");
            for (String s : item_arr) {
                if (!item_list.contains(s)) {
                    item_list.add(s);
                }
            }

        }
        String[] arr = new String[item_list.size()];
        arr = item_list.toArray(arr);
        String thePopular = "";
        int sale = 0;
        for (String s : arr) {
            int count = 0;
            for (int j = 0; j < getOrders_data().size(); j++) {
                String[] item_index = getOrders_data().get(j).split(",");
                String str = item_index[1].substring(1, item_index[1].length() - 1);
                String[] item_arr = str.split("; ");
                for (String z : item_arr) {
                    if (s.equals(z)) {
                        count++;
                    }
                    if (count > sale) {
                        sale = count;
                        thePopular = s;
                    }
                }
            }
        }
        System.out.println(thePopular + " is the most popular product with " + sale + " orders");
    }

    public void leastPopular() {
        ArrayList<String> item_list = new ArrayList<String>();
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] item_index = getOrders_data().get(i).split(",");
            String str = item_index[1].substring(1, item_index[1].length() - 1);
            String[] item_arr = str.split("; ");
            for (String s : item_arr) {
                if (!item_list.contains(s)) {
                    item_list.add(s);
                }
            }

        }
        String[] arr = new String[item_list.size()];
        arr = item_list.toArray(arr);
        String theLeast = "";
        int sale = 100;
        for (String s : arr) {
            int count = 0;
            int total = 0;
            for (int j = 0; j < getOrders_data().size(); j++) {
                String[] item_index = getOrders_data().get(j).split(",");
                String str = item_index[1].substring(1, item_index[1].length() - 1);
                String[] item_arr = str.split("; ");
                for (String z : item_arr) {
                    total++;
                    if (!s.equals(z)) {
                        count++;
                    }
                }
            }
            if (sale >= total - count) {
                sale = total - count;
                theLeast = s;
            }
        }
        System.out.println(theLeast + " is the least popular product with only " + sale + " order(s)");
    }
}

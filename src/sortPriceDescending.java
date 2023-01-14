/*
  RMIT University Vietnam
  Course: COSC2081 Programming 1
  Semester: 2022C
  Assessment: Assignment 3
  Author: Ha Thuy Chi
  ID: s3930417
  Acknowledgement: None
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sortPriceDescending extends Product {
    public sortPriceDescending(ArrayList<String> items_data) {
        super(items_data);
    }

    public void sortPrice() throws FileNotFoundException {
        FileReader file = new FileReader("src/data/items.txt");
        Scanner fileScanner = new Scanner(file);
        ArrayList<Double> priceList = new ArrayList<>();
        ArrayList<String> itemList = new ArrayList<>();

        while(fileScanner.hasNext()) {
            String[] split = fileScanner.nextLine().split(",");
            double price = Double.parseDouble(split[2]);
            itemList.add(split[0]);
            itemList.add(split[1]);
            itemList.add(split[2]);
            itemList.add(split[3]);
            priceList.add(price);
        }

        ArrayList<String> stringPriceList = new ArrayList<>();
        priceList.sort(Collections.reverseOrder());

        for (Double aDouble : priceList) {
            stringPriceList.add(aDouble.toString());
        }

        System.out.printf("PRICE FROM HIGHEST TO LOWEST:\n\n%-15s%-30s%-10s%-5s\n" +
                        "----------------------------------------------------------------\n",
                "ID", "Title", "Price", "Category");

        for (String i : stringPriceList) {
            for (String j : itemList) {
                if (i.equals(j)) {
                    int a = itemList.indexOf(j);
                    System.out.printf("%-15s%-30s%-10s%-5s\n", itemList.get(a - 2), itemList.get(a - 1),
                            itemList.get(a), itemList.get(a + 1));
                }
            }
        }
    }
}

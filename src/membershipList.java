import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class membershipList extends Customer{
    public membershipList(ArrayList<String> customer_data) {
        super(customer_data);
    }

    public void showList() {
        StringBuilder silver = new StringBuilder();
        StringBuilder gold = new StringBuilder();
        StringBuilder platinum = new StringBuilder();
        StringBuilder none = new StringBuilder();

        int silverNum = 0;
        int goldNum = 0;
        int platinumNum = 0;
        int noneNum = 0;
        for (int i = 0; i < getCustomer_data().size(); i++) {
            String[] customer_arr = getCustomer_data().get(i).split(",");
            String toString = Arrays.toString(customer_arr);
            switch (customer_arr[7]) {
                case "Silver":
                    silver.append(toString);
                    silver.append("\n");
                    silverNum++;
                    break;
                case "Gold":
                    gold.append(toString);
                    gold.append("\n");
                    goldNum++;
                    break;
                case "Platinum":
                    platinum.append(toString);
                    platinum.append("\n");
                    platinumNum++;
                    break;
                default:
                    none.append(toString);
                    none.append("\n");
                    noneNum++;
                    break;
            }
        }
        System.out.println("Platinum has " + platinumNum + " member(s):\n" + platinum);
        System.out.println("Gold has " + goldNum + " member(s):\n" + gold);
        System.out.println("Silver has " + silverNum + " member(s):\n" + silver);
        System.out.println("Membership-less has " + noneNum + " member(s):\n" + none);
    }
}

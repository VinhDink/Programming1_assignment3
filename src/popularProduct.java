import java.util.ArrayList;

public class popularProduct extends Order{
    public popularProduct(ArrayList<String> orders_data) {
        super(orders_data);
    }

    public void mostPopular() {
        ArrayList<String> item_list = new ArrayList<String>();
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] item_arr = getOrders_data().get(i).split(",");
            if (!item_list.contains(item_arr[1])) {
                item_list.add(item_arr[1]);
            }
        }
        String[] arr = new String[item_list.size()];
        arr = item_list.toArray(arr);

        String thePopular = "";
        int sale = 0;
        for (String s : arr) {
            int count = 0;
            for (int j = 0; j < getOrders_data().size(); j++) {
                String[] item_arr = getOrders_data().get(j).split(",");
                if (s.equals(item_arr[1])) {
                    count++;
                }
                if (count > sale) {
                    sale = count;
                    thePopular = s;
                }
            }
        }
        System.out.println(thePopular + " is the most popular product with " + sale + " orders");
    }

    public void leastPopular() {
        ArrayList<String> item_list = new ArrayList<String>();
        for (int i = 0; i < getOrders_data().size(); i++) {
            String[] item_arr = getOrders_data().get(i).split(",");
            if (!item_list.contains(item_arr[1])) {
                item_list.add(item_arr[1]);
            }
        }
        String[] arr = new String[item_list.size()];
        arr = item_list.toArray(arr);
        System.out.println(item_list);

        String theLeast = "";
        int sale = 1;
        for (String s : arr) {
            int count = 0;
            int total = 0;
            for (int j = 0; j < getOrders_data().size(); j++) {
                total++;
                String[] item_arr = getOrders_data().get(j).split(",");
                if (!s.equals(item_arr[1])) {
                    count++;
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

public class Product {
    private String ID;
    private String title;
    private double price;
    private String category;

    //Constructor
    public Product(String ID, String title, double price, String category) {
        this.ID = ID;
        this.title = title;
        this.price = price;
        this.category = category;
    }

    //Getter
    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    //Setter
    public void setCategory(String category) {
        this.category = category;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}



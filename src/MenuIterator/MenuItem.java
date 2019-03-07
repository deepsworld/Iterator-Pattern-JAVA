package MenuIterator;

public class MenuItem {
    private String item_name;
    private int category;
    private boolean heart_healthy;
    private double price;

    public MenuItem(String item_name, int category, boolean heart_healthy, double price){
        this.item_name = item_name;
        this.category = category;
        this.heart_healthy = heart_healthy;
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getCategory() {
        return category;
    }

    public boolean isHeart_healthy() {
        return heart_healthy;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return (item_name + "\t $" + price + "\t" + category );
    }
}

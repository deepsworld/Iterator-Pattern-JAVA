package MenuIterator;

import java.util.ArrayList;

public class Menu {

    public static final int APPETIZERS = 1;
    public static final int MAIN_DISH = 2;
    public static final int DESSERT = 3;

    public static final boolean HEART_HEALTHY = true;
    public static final boolean NOT_HEART_HEALTHY = false;

    //private AllItemsIterator;


    ArrayList<MenuItem> menuItems;

    // -- constructors
    public Menu(){
        menuItems = new ArrayList<MenuItem>();
    }
    // add item to the list
    public void addItem(MenuItem item){
        menuItems.add(item);
    }

    // remove item from the list
    public void removeItem(MenuItem item){
        menuItems.remove(item);
    }
    public void removeItem(int index){
        menuItems.remove(index);
    }

    // factory methods
    public MenuIterator getAllItemsIterator(){
        return new AllItemsIterator(this,0);
    }

    // Iterates over a specified item type(appetizer, main dish, or dessert).
    public MenuIterator getItemIterator(int category){
        return new ItemsIterator(this, 0, category);
    }
    // Iterates over the heart healthy items on the menu
    public MenuIterator getHeartHealthyIterator() {
        return new HeartHealthyIterator(this, 0);
    }

    // Iterates over the main dishes that are under a specified price
    public MenuIterator getPriceIterator(double price){
        return new PriceIterator(this, 0, price);
    }











}

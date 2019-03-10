package MenuIterator;

import java.util.ArrayList;

public class Menu {

    public static final int APPETIZERS = 1;
    public static final int MAIN_DISH = 2;
    public static final int DESSERT = 3;

    public static final boolean HEART_HEALTHY = true;
    public static final boolean NOT_HEART_HEALTHY = false;

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
    public void removeItem(String name){
        int j = menuItems.size();
        for(int i = 0; i <= j; i ++){
            if((menuItems.get(i).getItem_name().toLowerCase()).equals(name)){
                removeItem(i);
                j = i;
            }
        }
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

        return new ItemIterator(this, 0, category);
    }
    // Iterates over the heart healthy items on the menu
    public MenuIterator getHeartHealthyIterator() {

        return new HeartHealthyIterator(this, 0);
    }

    // Iterates over the dishes that are under a specified price
    public MenuIterator getPriceIterator(double price){

        return new PriceIterator(this, 0, price);
    }


    // Iterates over all the menu items.
    private class AllItemsIterator implements MenuIterator{
        private int current_index;
        private Menu menuList;

        public AllItemsIterator(Menu menuList, int current_index){
            this.menuList = menuList;
            this.current_index = current_index;

            // set to first returnable item in list
            if(!appropriateValue()){
                advanceToNext();
            }
        }

        // -- private methods
        private void advanceToNext(){
            current_index = current_index + 1;

            while(!offEnd() && !appropriateValue())
                current_index = current_index + 1;
        }

        private boolean offEnd() {
            return current_index == menuList.menuItems.size();
        }
        private boolean appropriateValue(){
            return true;
        }

        @Override
        public boolean hasNext() {
            return !offEnd() && appropriateValue();
        }

        @Override
        public MenuItem next() throws InvalidIteratorOperationException {
            if(!hasNext())
                throw new InvalidIteratorOperationException();

            MenuItem return_val = menuList.menuItems.get(current_index);
            advanceToNext();
            return return_val;
        }
    }


    // Iterates over the heart healthy items on the menu
    private class HeartHealthyIterator implements MenuIterator{
        private int current_index;
        private Menu menuList;

        public HeartHealthyIterator(Menu menuList, int current_index){
            this.menuList = menuList;
            this.current_index = current_index;

            // set to first returnable item in list
            if(!appropriateValue()){
                advanceToNext();
            }
        }

        // -- private methods
        private void advanceToNext(){
            current_index = current_index + 1;

            while(!offEnd() && !appropriateValue())
                current_index = current_index + 1;
        }

        private boolean offEnd() {
            return current_index == menuList.menuItems.size();
        }

        private boolean appropriateValue(){
            return (menuList.menuItems.get(current_index).isHeart_healthy());
        }

        @Override
        public boolean hasNext() {
            return !offEnd() && appropriateValue();
        }

        @Override
        public MenuItem next() throws InvalidIteratorOperationException {
            if(!hasNext())
                throw new InvalidIteratorOperationException();

            MenuItem return_val = menuList.menuItems.get(current_index);
            advanceToNext();
            return return_val;
        }
    }

    // Iterates over a specified item type(appetizer, main dish, or dessert).
    private class ItemIterator implements MenuIterator{
        private int current_index;
        private Menu menuList;
        private int category;

        public ItemIterator(Menu menuList, int current_index, int category){
            this.menuList = menuList;
            this.current_index = current_index;
            this.category = category;

            // set to first returnable item in list
            if(!appropriateValue()){
                advanceToNext();
            }
        }

        // -- private methods
        private void advanceToNext(){
            current_index = current_index + 1;

            while(!offEnd() && !appropriateValue())
                current_index = current_index + 1;
        }

        private boolean offEnd() {
            return current_index == menuList.menuItems.size();
        }
        private boolean appropriateValue(){
            return (menuList.menuItems.get(current_index).getCategory() == category);
        }

        @Override
        public boolean hasNext() {
            return !offEnd() && appropriateValue();
        }

        @Override
        public MenuItem next() throws InvalidIteratorOperationException {
            if(!hasNext())
                throw new InvalidIteratorOperationException();

            MenuItem return_val = menuList.menuItems.get(current_index);
            advanceToNext();
            return return_val;
        }
    }

    // Iterating over a specific price in the menu.
    private class PriceIterator implements MenuIterator{
        private int current_index;
        private Menu menuList;
        private double price;

        public PriceIterator(Menu menuList, int current_index, double price){
            this.menuList = menuList;
            this.current_index = current_index;
            this.price = price;

            // set to first returnable item in list
            if(!appropriateValue()){
                advanceToNext();
            }
        }

        // -- private methods
        private void advanceToNext(){
            current_index = current_index + 1;

            while(!offEnd() && !appropriateValue())
                current_index = current_index + 1;
        }

        private boolean offEnd() {
            return current_index == menuList.menuItems.size();
        }

        private boolean appropriateValue(){
            return (menuList.menuItems.get(current_index).getPrice() < price);
        }

        @Override
        public boolean hasNext() {
            return !offEnd() && appropriateValue();
        }

        @Override
        public MenuItem next() throws InvalidIteratorOperationException {
            if(!hasNext())
                throw new InvalidIteratorOperationException();

            MenuItem return_val = menuList.menuItems.get(current_index);
            advanceToNext();
            return return_val;
        }
    }


}

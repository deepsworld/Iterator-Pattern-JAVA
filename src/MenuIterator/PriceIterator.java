package MenuIterator;

public class PriceIterator extends ItemListItrAbstractClass {

     private double price;
    // Constructor
    public PriceIterator(Menu menuList, int start_loc, double price){
        super(menuList,start_loc);
        this.price = price;
    }

    @Override
    protected boolean appropriateValue() {
        return isSpecifiedPrice();
    }

    // check if it is under the specified price
    private boolean isSpecifiedPrice() {
        System.out.println(menuList.menuItems.get(current_index).getPrice());
        return (menuList.menuItems.get(current_index).getPrice()) <= price;
    }


}

package MenuIterator;

public class ItemsIterator extends ItemListItrAbstractClass {

    int category;
    // Constructor
    public ItemsIterator(Menu menuList, int start_loc, int category){
        super(menuList,start_loc);
        this.category = category;
    }

    @Override
    protected boolean appropriateValue() {
        System.out.print(category);
        return isSpecifiedCategory();
    }

    // check the food category
    private boolean isSpecifiedCategory(){
        return (menuList.menuItems.get(current_index).getCategory()) == category;
    }
}

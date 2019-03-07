package MenuIterator;

public class AllItemsIterator extends ItemListItrAbstractClass {

    // Constructor
    public AllItemsIterator(Menu menuList, int start_loc){
        super(menuList,start_loc);
    }

    @Override
    protected boolean appropriateValue() {
        return true;
    }
}

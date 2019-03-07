package MenuIterator;

public class HeartHealthyIterator extends ItemListItrAbstractClass {

    // Constructor
    public HeartHealthyIterator(Menu menuList, int start_loc){
        super(menuList,start_loc);
    }

    @Override
    protected boolean appropriateValue() {
        return isHeartHealthy();
    }

    // check if the food is heart healthy
    private boolean isHeartHealthy(){
        return (menuList.menuItems.get(current_index).isHeart_healthy());
    }
}

package MenuIterator;

public abstract class ItemListItrAbstractClass implements MenuIterator {

    protected int current_index;
    protected Menu menuList;

    public ItemListItrAbstractClass(Menu menuList, int current_index){
        this.menuList = menuList;
        this.current_index = current_index;

        // set to first returnable item in list
        if(!appropriateValue())
            advanceToNext();
    }

    // -- abstract methods
    protected abstract boolean appropriateValue();


    @Override
    public boolean hasNext() {
        return !offEnd() && appropriateValue();
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

    @Override
    public MenuItem next() throws InvalidIteratorOperationException {
        if(!hasNext())
            throw new InvalidIteratorOperationException();

        MenuItem return_val = menuList.menuItems.get(current_index);
        advanceToNext();
        return return_val;
    }
}

package MenuIterator;

public interface MenuIterator {

    // returns true if items of appropriate type left in list
    boolean hasNext();

    // returns current item and advances to next item
    MenuItem next() throws InvalidIteratorOperationException;
}

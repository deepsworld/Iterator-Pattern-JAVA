package MenuIterator;

public class Main {

    public static void main(String[] args) throws InvalidIteratorOperationException {

        Menu eatAtJoesMenu = new Menu();


        eatAtJoesMenu.addItem(new MenuItem("Ice Cream", Menu.DESSERT, Menu.HEART_HEALTHY, 3.99));
        eatAtJoesMenu.addItem(new MenuItem("Chicken Parmeson", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 9.99));
        eatAtJoesMenu.addItem(new MenuItem("Fried Fillet", Menu.MAIN_DISH, Menu.HEART_HEALTHY, 8.99));

        eatAtJoesMenu.addItem(new MenuItem("Cheese Pizza", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, 7.99));
        eatAtJoesMenu.addItem(new MenuItem("Fish Tikka", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 24.99));
        eatAtJoesMenu.addItem(new MenuItem("Masala Chicken", Menu.MAIN_DISH, Menu.HEART_HEALTHY, 15.99));

        eatAtJoesMenu.addItem(new MenuItem("Cheese Cake", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, 10.99));
        eatAtJoesMenu.addItem(new MenuItem("Boiled Salmon", Menu.MAIN_DISH, Menu.HEART_HEALTHY, 5.99));
        eatAtJoesMenu.addItem(new MenuItem("Beef Burger", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 6.99));

        MenuIterator itr = eatAtJoesMenu.getItemIterator(Menu.MAIN_DISH);
        System.out.println("ALL ITEMS UNDER $15.00");
        while (itr.hasNext())
        {
            MenuItem item = itr.next();
            System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());
        }


    }
}

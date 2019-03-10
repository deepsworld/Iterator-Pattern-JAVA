package MenuIterator;

import java.util.*;

public class Driver {

    public static void main(String[] args) throws InvalidIteratorOperationException {

        Menu eatAtJoesMenu = new Menu();
        Scanner scan = new Scanner(System.in);


        eatAtJoesMenu.addItem(new MenuItem("Chicken Parmeson", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 9.99));
        eatAtJoesMenu.addItem(new MenuItem("Rice Pudding", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, 3.50));
        eatAtJoesMenu.addItem(new MenuItem("Cheese Pizza", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, 7.99));


        eatAtJoesMenu.addItem(new MenuItem("Ice Cream", Menu.DESSERT, Menu.HEART_HEALTHY, 3.99));
        eatAtJoesMenu.addItem(new MenuItem("Fried Fillet", Menu.MAIN_DISH, Menu.HEART_HEALTHY, 8.99));

        eatAtJoesMenu.addItem(new MenuItem("Fish Tikka", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 24.99));
        eatAtJoesMenu.addItem(new MenuItem("Masala Chicken", Menu.MAIN_DISH, Menu.HEART_HEALTHY, 15.99));

        eatAtJoesMenu.addItem(new MenuItem("Cheese Cake", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, 10.99));
        eatAtJoesMenu.addItem(new MenuItem("Boiled Salmon", Menu.MAIN_DISH, Menu.HEART_HEALTHY, 5.99));
        eatAtJoesMenu.addItem(new MenuItem("Beef Burger", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 6.99));

        int user_choice;

        do{
            //eatAtJoesMenu.removeItem(8);
            showInstructions();
            System.out.print("Your Choice: ");
            user_choice = scan.nextInt();

            switch (user_choice){
                case 0:{
                    user_choice = 0;
                    System.out.println("Exiting...");
                    break;
                }
                case 1: {
                    System.out.println();
                    System.out.println("--- ALL MENU ITEMS ---");
                    MenuIterator itr = eatAtJoesMenu.getAllItemsIterator();
                    while (itr.hasNext())
                    {
                        MenuItem item = itr.next();
                        System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());
                    }
                    break;
                }

                case 2: {
                    System.out.println();
                    System.out.println("--- APPETIZERS ---");
                    MenuIterator itr = eatAtJoesMenu.getItemIterator(Menu.APPETIZERS);
                    while (itr.hasNext())
                    {
                        MenuItem item = itr.next();
                        System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());

                    }
                    break;
                }

                case 3: {
                    System.out.println();
                    System.out.println("--- MAIN DISHES ---");
                    MenuIterator itr = eatAtJoesMenu.getItemIterator(Menu.MAIN_DISH);
                    while (itr.hasNext())
                    {
                        MenuItem item = itr.next();
                        System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());

                    }
                    break;
                }

                case 4: {
                    System.out.println();
                    System.out.println("--- DESSERTS ---");
                    MenuIterator itr = eatAtJoesMenu.getItemIterator(Menu.DESSERT);
                    while (itr.hasNext())
                    {
                        MenuItem item = itr.next();
                        System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());

                    }
                    break;
                }

                case 5: {
                    System.out.println();
                    System.out.println("--- ALL HEART HEALTHY MENU ITEMS ---");
                    MenuIterator itr = eatAtJoesMenu.getHeartHealthyIterator();
                    while (itr.hasNext())
                    {
                        MenuItem item = itr.next();
                        System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());
                    }
                    break;
                }

                case 6: {
                    System.out.println("Specified price: ");
                    double price = scan.nextDouble();
                    System.out.println();
                    if(price == 0){
                        System.out.println("---- Invalid input price ----");
                    }
                    else{
                        System.out.println("--- ALL ITEMS UNDER $" + price + " ---");
                        MenuIterator itr = eatAtJoesMenu.getPriceIterator(price);
                        while (itr.hasNext())
                        {
                            MenuItem item = itr.next();
                            System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());
                        }
                    }

                    break;
                }

                case 7: {
                    System.out.println();
                    System.out.println("Enter item name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.println("Enter item category(Appetizer-1,Main Dish-2,Dessert-3): ");
                    int category = scan.nextInt();
                    if(category < 0 || category > 3){
                        System.out.println("Invalid category input");
                    }
                    else{
                        System.out.println("Is item heart healthy?(y/n) ");
                        scan.nextLine();
                        String hearth_health = scan.nextLine();
                        boolean heart_healthy = false;
                        if(hearth_health.equals("y")){
                            heart_healthy = true;
                        }
                        else if(hearth_health.equals("n")){
                            // value already assigned.
                        }
                        else{
                            System.out.println("Invalid input");
                        }
                        System.out.println("Enter item price: ");
                        double price = scan.nextDouble();
                        eatAtJoesMenu.addItem(new MenuItem(name, category, heart_healthy, price));
                        System.out.println("---- Item added to the menu: " + name + " $"+ price +" ----");
                        System.out.println();
                        MenuIterator itr = eatAtJoesMenu.getAllItemsIterator();
                        while (itr.hasNext())
                        {
                            MenuItem item = itr.next();
                            System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());
                        }
                    }

                    break;
                }

                case 8: {
                    MenuIterator itr = eatAtJoesMenu.getAllItemsIterator();
                    while (itr.hasNext())
                    {
                        MenuItem item = itr.next();
                        System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());
                    }
                    System.out.println();
                    System.out.println("Enter name of the item to remove: ");
                    scan.nextLine();
                    String name = scan.nextLine().toLowerCase();
                    eatAtJoesMenu.removeItem(name);
                    System.out.println("---- " + name + " removed from the menu ----\n");
                    MenuIterator itr1 = eatAtJoesMenu.getAllItemsIterator();
                    while (itr1.hasNext())
                    {
                        MenuItem item = itr1.next();
                        System.out.println(item.getItem_name() + "\t" + "$" + item.getPrice());
                    }
                    break;
                }

                default:{
                    System.out.println();
                    System.out.println("Input choice does not exist");
                }
            }
        }while(user_choice != 0);
    }

    // method to show instructions
    public static void showInstructions(){
        String instructions = "---- Make a Choice ---- \n" +
                "1 – Display all menu items \n" +
                "2 – Display all appetizers \n" +
                "3 – Display all main dishes \n" +
                "4 – Display all desserts \n" +
                "5 – Display all hearty healthy items \n" +
                "6 – Display all main dishes under a specified price \n" +
                "7 – Add menu item \n" +
                "8 – Remove menu item \n" +
                "0 - quit\n";
        System.out.print(instructions);
    }
}

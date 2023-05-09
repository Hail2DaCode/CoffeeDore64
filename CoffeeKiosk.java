import java.util.ArrayList;


class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;
    public CoffeeKiosk() {
        menu = new ArrayList<Item>();
        orders= new ArrayList<Order>();
    }
    public Item addMenuItem(String name, double price) {
        Item item = new Item(name, price);
        menu.add(item);
        int index = menu.indexOf(item);
        item.setIndex(index);
        return item;
    }
    public ArrayList<Item> displayMenu() {
        for (Item item: menu) {
            System.out.printf("%d %s -- $%.2f\n", item.getIndex(), item.getName(), item.getPrice());
        }
        return menu;
    }
        public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Order order = new Order(name);
        this.displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            int num = Integer.parseInt(itemNumber);
            order.addItem(menu.get(num));
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();

            
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        order.display();
    }
    public void addMenuItemByInput() {
        System.out.println("Welcome to menu adder!  Press q to quit or any other button to continue");
        String itemNumber = System.console().readLine();
        while(!itemNumber.equals("q")) {
            System.out.println("Please enter item name.");
            String name = System.console().readLine();
            System.out.println("Please enter item price.");
            String price = System.console().readLine();
            double newPrice = Double.parseDouble(price);
            Item item = new Item(name, newPrice);
            menu.add(item);
            int index = menu.indexOf(item);
            item.setIndex(index);
            System.out.println("Would you like to add more items to your menu? Press q to quit or any other key to continue");
            itemNumber = System.console().readLine();
            
        }
        this.displayMenu();
    }

}
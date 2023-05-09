import java.util.ArrayList;


class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;
    public Order() {
        name = "Guest";
        items = new ArrayList<Item>();
    }
    public Order(String name) {
        this.name = name;
        items = new ArrayList<Item>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isReady() {
        return ready;
    }
    public void setReady(boolean ready) {
        this.ready = ready;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public String getStatusMessage() {
        return (isReady()? "Your order is ready": "Thank you for waiting.  Your order will be ready soon");
    }
    public double getOrderTotal() {
        double total = 0.00;
        for(Item item: this.getItems() ) {
            total += item.getPrice();
        }
        return total;
    }
    public  void display() {
        System.out.printf("Customer name: %s \n",  this.getName());
        for (Item item:  this.getItems()) {
            System.out.printf("%s - $%.2f \n", item.getName(), item.getPrice());
        }
        System.out.printf("Total: $%.2f\n\n", this.getOrderTotal() );
    }
}
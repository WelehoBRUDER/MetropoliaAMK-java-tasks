import java.util.ArrayList;

class ShoppingCart {
    private ArrayList<Item> cart = new ArrayList<>();

    public void addItem(String item, double price) {
        this.cart.add(new Item(item, price));
    }

    public void removeItem(String item) {
        for (Item i : this.cart) {
            if (i.getName().equals(item)) {
                this.cart.remove(i);
                break;
            }
        }
    }

    public int getItemCount() {
        return this.cart.size();
    }

    public double calculateTotal() {
        return this.cart.stream().mapToDouble(Item::getPrice).sum();
    }
}
package Module_2_2.Task_4;

import java.util.HashMap;

public class GroceryListQuantifier {
    public final class Item {
        private String category;
        private double cost;
        private int quantity;

        public Item(String category, double cost, int quantity) {
            this.category = category;
            this.cost = cost;
            this.quantity = quantity;
        }

        public String getCategory() {
            return category;
        }

        public double getCost() {
            return cost;
        }

        public double getTotalCost() {
            return cost * quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }

    private HashMap<String, Item> groceryList = new HashMap<String, Item>();


    public void addItem(String item) {
        if (!checkItem(item)) {
            groceryList.put(item, new Item("misc", 1.0, 1));
        } else {
            System.out.println("Item '" + item + "' already exists!");
        }
    }

    public void addItem(String item, double cost) {
        if (!checkItem(item)) {
            groceryList.put(item, new Item("misc", cost, 1));
        } else {
            System.out.println("Item '" + item + "' already exists!");
        }
    }

    public void addItem(String item, double cost, String category) {
        if (!checkItem(item)) {
            groceryList.put(item, new Item(category, cost, 1));
        } else {
            System.out.println("Item '" + item + "' already exists!");
        }
    }

    public void addItem(String item, double cost, String category, int quantity) {
        if (!checkItem(item)) {
            groceryList.put(item, new Item(category, cost, quantity));
        } else {
            Item itm = groceryList.get(item);
            itm.setQuantity(quantity + itm.getQuantity());
            itm.setCost(cost);
            itm.setCategory(category);
        }
    }

    public void updateQuantity(String item, int quantity) {
        if (checkItem(item)) {
            groceryList.get(item).setQuantity(quantity);
        }
    }

    public void removeItem(String item) {
        if (checkItem(item)) {
            groceryList.remove(item);
        } else {
            System.out.println("Item '" + item + "' not found");
        }
    }

    public void removeItem(String item, int quantity) {
        if (checkItem(item)) {
            Item itm = groceryList.get(item);
            itm.setQuantity(itm.getQuantity() - quantity);
            if (itm.getQuantity() <= 0) {
                groceryList.remove(item);
            }
        } else {
            System.out.println("Item '" + item + "' not found");
        }
    }

    public void displayList() {
        int count = 1;
        for (String key : groceryList.keySet()) {
            double cost = groceryList.get(key).getCost();
            System.out.println(count + ". " + key + " = " + cost + "€");
            count++;
        }
    }

    public void displayAvailableItems() {
        int count = 1;
        for (String key : groceryList.keySet()) {
            Item itm = groceryList.get(key);
            int amnt = itm.getQuantity();
            double cost = itm.getCost();
            double totalCost = itm.getTotalCost();
            if (amnt > 0) {
                System.out.println(count + ". " + key + " = " + cost + "€ each, amount: " + amnt + " (" + totalCost + "€ total)");
                count++;
            }
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        // Perhaps this wasn't the clean method I was hoping for...
        // Converts the HashMap to a stream that is then mapped to a list of getCost
        // which is then reduced to always return a double
        // Unfortunate that (a,b) -> a.getCost() + b.getCost() didn't work :(
        return groceryList.values().stream().map(Item::getTotalCost).reduce(0.0, Double::sum);
    }

    public void displayByCategory(String category) {
        int count = 1;
        for (String key : groceryList.keySet()) {
            String cat = groceryList.get(key).getCategory();
            if (cat.equals(category)) {
                double cost = groceryList.get(key).getCost();
                System.out.println(count + ". " + key + " = " + cost + "€");
                count++;
            }
        }
    }

    public static void main(String[] args) {
        GroceryListQuantifier groceryListManager = new GroceryListQuantifier();
        groceryListManager.addItem("banana", 7, "fruit", -3);
        groceryListManager.addItem("eggs", 2, "dairy", 3);
        groceryListManager.addItem("apples", 3, "fruit", 15);
        groceryListManager.addItem("apples", 4, "fruit", 7);
        groceryListManager.addItem("waffles", 3.5, "grains", 22);
        System.out.println("Grocery List: ");
        groceryListManager.displayAvailableItems();
        System.out.println("Total price: " + groceryListManager.calculateTotalCost() + "€");
    }
}

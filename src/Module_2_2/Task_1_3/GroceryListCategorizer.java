package Module_2_2.Task_1_3;

import java.util.HashMap;

public class GroceryListCategorizer {
    public final class Item {
        private String category;
        private double cost;

        public Item(String category, double cost) {
            this.category = category;
            this.cost = cost;
        }

        public String getCategory() {
            return category;
        }

        public double getCost() {
            return cost;
        }
    }

    private HashMap<String, Item> groceryList = new HashMap<String, Item>();


    public void addItem(String item) {
        if (!checkItem(item)) {
            groceryList.put(item, new Item("misc", 1.0));
        } else {
            System.out.println("Item '" + item + "' already exists!");
        }
    }

    public void addItem(String item, double cost) {
        if (!checkItem(item)) {
            groceryList.put(item, new Item("misc", cost));
        } else {
            System.out.println("Item '" + item + "' already exists!");
        }
    }

    public void addItem(String item, double cost, String category) {
        if (!checkItem(item)) {
            groceryList.put(item, new Item(category, cost));
        } else {
            System.out.println("Item '" + item + "' already exists!");
        }
    }

    public void removeItem(String item) {
        if (checkItem(item)) {
            groceryList.remove(item);
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

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        // Perhaps this wasn't the clean method I was hoping for...
        // Converts the HashMap to a stream that is then mapped to a list of getCost
        // which is then reduced to always return a double
        // Unfortunate that (a,b) -> a.getCost() + b.getCost() didn't work :(
        return groceryList.values().stream().map(Item::getCost).reduce(0.0, Double::sum);
    }

    public static void main(String[] args) {
        GroceryListCategorizer groceryListManager = new GroceryListCategorizer();
        groceryListManager.addItem("banana", 7);
        groceryListManager.addItem("eggs", 2);
        groceryListManager.addItem("apples", 3);
        groceryListManager.addItem("apples", 4);
        groceryListManager.addItem("waffles", 3.5);
        System.out.println("Grocery List: ");
        groceryListManager.displayList();
        System.out.println("Total price: " + groceryListManager.calculateTotalCost() + "€");
        System.out.println("Is 'eggs' in the grocery list? " + (groceryListManager.checkItem("eggs") ? "Yes" : "No"));
        System.out.println("Removing 'eggs' from the list...");
        groceryListManager.removeItem("eggs");
        groceryListManager.removeItem("eggs");
        System.out.println("Updated Grocery List: ");
        groceryListManager.displayList();
    }
}

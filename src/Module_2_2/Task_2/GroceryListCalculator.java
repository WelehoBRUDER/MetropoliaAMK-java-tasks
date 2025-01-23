package Module_2_2.Task_2;

import java.util.HashMap;

public class GroceryListCalculator {
    private HashMap<String, Double> groceryList = new HashMap<String, Double>();

    public void addItem(String item) {
        if(!checkItem(item)) {
            groceryList.put(item, 1.0);
        }
        else {
            System.out.println("Item '" + item + "' already exists!");
        }
    }
    public void addItem(String item, double cost) {
        if(!checkItem(item)) {
            groceryList.put(item, cost);
        }
        else {
            System.out.println("Item '" + item + "' already exists!");
        }
    }

    public void removeItem(String item) {
        if (checkItem(item)) {
            groceryList.remove(item);
        }
        else {
            System.out.println("Item '" + item + "' not found");
        }
    }

    public void displayList() {
        int count = 1;
        for (String key : groceryList.keySet()) {
            double cost = groceryList.get(key);
            System.out.println(count + ". " + key + " = " + cost + "€");
            count++;
        }
    }

    public boolean checkItem(String item) {
        return groceryList.containsKey(item);
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (String key : groceryList.keySet()) {
            double cost = groceryList.get(key);
            totalCost += cost;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        GroceryListCalculator groceryListManager = new GroceryListCalculator();
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

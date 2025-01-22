package Module_2_2.Task_1;

import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if(!checkItem(item)) {
            groceryList.add(item);
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
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    public static void main(String[] args) {
        GroceryListManager groceryListManager = new GroceryListManager();
        groceryListManager.addItem("banana");
        groceryListManager.addItem("eggs");
        groceryListManager.addItem("apples");
        groceryListManager.addItem("apples");
        System.out.println("Grocery List: ");
        groceryListManager.displayList();
        System.out.println("Is 'eggs' in the grocery list? " + (groceryListManager.checkItem("eggs") ? "Yes" : "No"));
        System.out.println("Removing 'eggs' from the list...");
        groceryListManager.removeItem("eggs");
        groceryListManager.removeItem("eggs");
        System.out.println("Updated Grocery List: ");
        groceryListManager.displayList();
    }
}

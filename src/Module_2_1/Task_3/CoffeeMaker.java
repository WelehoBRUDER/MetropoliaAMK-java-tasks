package Module_2_1.Task_3;



public class CoffeeMaker {
    public enum CoffeeType {
        normal, espresso
    }

    private CoffeeType coffeeType;
    private boolean isOn;
    private int amount;
    private int maxAmount;
    private int minAmount;

    public void onOff() {
        this.isOn = !this.isOn;
        System.out.println("Coffee maker is " + (this.isOn ? "on" : "off"));
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        if (this.isOn) {
            this.coffeeType = coffeeType;
            System.out.println("Coffee type is " + this.coffeeType);
        }
    }

    public void setAmount(int amount) {
        if (this.isOn) {
            this.amount = amount;
            if (amount > maxAmount) {
                this.amount = maxAmount;
            }
            else if (amount < minAmount) {
                this.amount = minAmount;
            }

            System.out.println("Coffee amount is " + this.amount + " ml");
        }
    }

    public CoffeeMaker() {
        isOn = false;
        coffeeType = CoffeeType.normal;
        amount = 0;
        maxAmount = 80;
        minAmount = 10;
    }
}

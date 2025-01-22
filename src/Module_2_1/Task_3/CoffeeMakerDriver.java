package Module_2_1.Task_3;

public class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        coffeeMaker.onOff();
        coffeeMaker.setCoffeeType(CoffeeMaker.CoffeeType.espresso);
        coffeeMaker.setAmount(50);
        coffeeMaker.onOff();
    }
}

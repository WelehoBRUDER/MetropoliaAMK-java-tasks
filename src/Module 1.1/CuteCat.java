public class CuteCat {
    private String name;

    public CuteCat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        // Renamed cat to catWhiskers for consistency
        CuteCat catWhiskers = new CuteCat("Whiskers");
        CuteCat catRex = new CuteCat("Rex");

        // Call the meow method on the cat instance
        catWhiskers.meow();
        catWhiskers.meow();
        catRex.meow();
        catWhiskers.meow();
    }
}
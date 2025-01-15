package Module_1_4;

public class NameGenerator {
    private String[] firstNames = {"Jack", "Tom", "Henry", "Lisa", "Tina", "Mona"};
    private String[] lastNames = {"Smith", "Doe", "Jones", "Timber", "Lakes", "Woods"};

    public String generateName() {
        String name = firstNames[(int) (Math.random() * firstNames.length)] + " " + lastNames[(int) (Math.random() * firstNames.length)];
        return name;
    }

    public static void main(String[] args) {
        NameGenerator nameGen = new NameGenerator();
        System.out.println(nameGen.generateName());
    }
}

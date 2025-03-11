import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("Markus", 25, "Helsinki"));
        people.add(new Person("Thomas", 19, "London"));
        people.add(new Person("Tarmo", 56, "Tampere"));
        people.add(new Person("Maria", 33, "Bucharest"));
        people.add(new Person("Laura", 42, "London"));

        // Sort the people list by age (ascending)
        people.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("People sorted by age:");
        // Print the sorted list
        for (Person p : people) {
            System.out.println(p.getName() + " " + p.getAge() + " " + p.getCity());
        }

        // Filter to only london
        people.removeIf(person -> !person.getCity().equals("London"));

        System.out.println("\nOnly people from London:");
        // Print the filtered list
        for (Person p : people) {
            System.out.println(p.getName() + " " + p.getAge() + " " + p.getCity());
        }
    }
}

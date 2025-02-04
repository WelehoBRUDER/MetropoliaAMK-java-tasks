package Module_3_4.Task_3;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final String FILE_PATH = "src//Module_3_4//Task_3//enrollments.ser";
        ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
        Student studentA = new Student("Tarmo", 26);
        Student studentB = new Student("Jans", 31);

        Course math = new Course("M-2", "Math 2", "Jukka P.");
        Course fys = new Course("FY-1", "Physics 1", "Heini A.");

        enrollments.add(new Enrollment(studentA, math, "7-3-2009"));
        enrollments.add(new Enrollment(studentB, fys, "15-1-2009"));

        try (
                FileOutputStream fout = new FileOutputStream(FILE_PATH);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
        ) {
            // Write the entire list of ellrollments to the .ser file.
            oos.writeObject(enrollments);

        } catch (Exception e) {
            System.err.println("Writing enrollments: " + e);
        }

        try (
                FileInputStream inputStream = new FileInputStream(FILE_PATH);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ) {
            // Read the array of enrollments from the .ser file.
            ArrayList<Enrollment> readEnrollments = (ArrayList<Enrollment>) objectInputStream.readObject();
            // Print information about each enrollment
            for (Enrollment enrollment : readEnrollments) {
                enrollment.displayInfo();
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Reading enrollments: " + e);
        }
    }
}

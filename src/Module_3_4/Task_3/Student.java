package Module_3_4.Task_3;

import java.io.Serializable;

public class Student implements Serializable {
    private static int count = 1;
    private final int id;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.id = count;
        this.name = name;
        this.age = age;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}

package hw.homework1.advanced.task1;

public class Student {
    private String name;
    private int id;

    public Student(String name, int ID) {
        this.name = name;
        this.id = ID;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID=" + id +
                '}';
    }
}

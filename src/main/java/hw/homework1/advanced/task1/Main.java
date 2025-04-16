package hw.homework1.advanced.task1;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Student student1 = new Student("Eva", 1);
        Student student2 = new Student("Coll", 2);
        Student student3 = new Student("Alice", 5);

        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);

        studentManager.removeStudentById(2);

        studentManager.printAllStudent();

    }



}

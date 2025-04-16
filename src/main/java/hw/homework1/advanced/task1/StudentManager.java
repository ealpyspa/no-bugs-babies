package hw.homework1.advanced.task1;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> studentArrayList;

    public StudentManager() {
        this.studentArrayList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentArrayList.add(student);
    }

    public void removeStudentById(int ID) {
        for(int i = 0; i < studentArrayList.size(); i++) {
            if(studentArrayList.get(i).getID() == ID) {
                studentArrayList.remove(i);
                break;
            }
        }
    }

    public void printAllStudent() {
        studentArrayList.forEach(System.out::println);
    }

}

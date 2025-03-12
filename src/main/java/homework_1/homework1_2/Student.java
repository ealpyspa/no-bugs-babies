package homework_1.homework1_2;

public class Student implements Printable{
    private String name;
    private int number;
    private double gpa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }


    @Override
    public void print() {
        System.out.println("Name: " + this.name + "\n" + "Student number: " + this.number + "\n" + "GPA: " + this.gpa);

    }
}

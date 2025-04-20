package hw.homework1.base;

import hw.homework1.base.homework1_1.Book;
import hw.homework1.base.homework1_2.Student;
import hw.homework1.base.homework1_3.Point;
import hw.homework1.base.homework1_4.Clock;
import hw.homework1.base.homework1_5.Car;

public class Main {
    public static void main(String[] args) {

        //homework1_1
        Book book = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        book.display();

        //homework1_2
        Student student = new Student();
        student.setName("Alice Cooper");
        student.setNumber(312);
        student.setGpa(3.8);
        student.print();

        //homework1_3
        Point point = new Point();
        point.setX(1);
        point.setY(1);
        point.moveDown();
        point.moveLeft();
        point.printCoordinates();

        //homework1_4
        Clock clock = new Clock();
        clock.setHours(23);
        clock.setMinutes(59);
        clock.setSeconds(59);
        clock.tick();
        clock.readTime();

        //homework1_5
        Car car = new Car();
        car.setBrand("BMW");
        car.setModel("320i");
        car.setYear(2017);
        car.start();
        car.drive(525);
        car.stop();
    }
}
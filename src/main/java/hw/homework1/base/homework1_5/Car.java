package hw.homework1.base.homework1_5;

public class Car implements Drivable{
    private String brand;
    private String model;
    private int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("The car is ready for driving.");
    }

    @Override
    public void stop() {
        System.out.println("The car has stopped.");
    }

    @Override
    public void drive(int distance) {
        System.out.println("The car drove " + distance + " kilometers.");
    }

}

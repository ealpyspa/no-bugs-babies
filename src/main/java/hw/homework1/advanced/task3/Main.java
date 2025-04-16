package hw.homework1.advanced.task3;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("apple", 50.0);
        Product product2 = new Product("banana", 60.0);
        Product product3 = new Product("orange", 40.0);

        PriceList priceList = new PriceList();

        priceList.addProduct(product1);
        priceList.addProduct(product2);
        priceList.addProduct(product3);

        priceList.changeProductPrice(product1, 55.00);
        priceList.printAllProducts();

        System.out.println(priceList.getPriceByProductName("banana"));

    }
}

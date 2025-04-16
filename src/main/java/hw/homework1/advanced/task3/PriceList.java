package hw.homework1.advanced.task3;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private HashMap<String, Double> priceMap;

    public PriceList() {
        this.priceMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        priceMap.put(product.getName(), product.getPrice());
    }

    public void changeProductPrice(Product product, Double newPrice) {
        priceMap.put(product.getName(), newPrice);
    }

    public Double getPriceByProductName(String name){
        if(priceMap.containsKey(name)) {
            return priceMap.get(name);
        } else System.out.println("There is no such product.");
        return null;
    }

    public void printAllProducts() {
        for(Map.Entry<String, Double> element : priceMap.entrySet()) {
            System.out.println(element);
        }
    }

}

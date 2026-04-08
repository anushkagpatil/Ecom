

package main.java.com;

import java.util.*;

public class ProductService {

    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("bread", 40));
        productList.add(new Product("cake", 350));
        productList.add(new Product("cookies", 150));
        productList.add(new Product("muffin", 60));
        productList.add(new Product("donut", 50));
        productList.add(new Product("croissant", 120));
        productList.add(new Product("brownie", 90));
        productList.add(new Product("pastry", 80));
        productList.add(new Product("sandwich", 70));
        productList.add(new Product("cupcake", 65));
    }

    // Display all products
    public static List<Product> displayProducts() {
        if (productList.isEmpty()) {
            throw new IllegalStateException("No products available");
        }
        return productList;
    }

    // Search product by name
    public static Product searchProduct(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid product name");
        }

        for (Product p : productList) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }

        throw new IllegalArgumentException("Product not found");
    }
}
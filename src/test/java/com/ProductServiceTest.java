package test.java.com;

import main.java.com.Product;
import main.java.com.ProductService;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class ProductServiceTest {

    @Before
    public void setUp() {
        System.out.println("Starting Test");
    }

    @After
    public void tearDown() {
        System.out.println("Test Finished");
    }

    // 1. Check total number of products
    @Test
    public void testDisplayProductsSize() {
        List<Product> list = ProductService.displayProducts();
        assertEquals(10, list.size());
    }

    // 2. Check list is not null
    @Test
    public void testDisplayProductsNotNull() {
        List<Product> list = ProductService.displayProducts();
        assertNotNull(list);
    }

    // 3. Check list is not empty
    @Test
    public void testDisplayProductsNotEmpty() {
        List<Product> list = ProductService.displayProducts();
        assertFalse(list.isEmpty());
    }

    // 4. Check first product (optional validation)
    @Test
    public void testFirstProductDetails() {
        List<Product> list = ProductService.displayProducts();
        Product p = list.get(0);
        assertEquals("cake", p.getName());
        assertEquals(350, p.getPrice());
    }

    // 5. Search valid product
    @Test
    public void testSearchProductFound() {
        Product p = ProductService.searchProduct("cake");
        assertEquals("cake", p.getName());
        assertEquals(350, p.getPrice());
    }

    // 6. Case insensitive search
    @Test
    public void testSearchCaseInsensitive() {
        Product p = ProductService.searchProduct("DONUT");
        assertEquals("donut", p.getName());
    }

    // 7. Search another valid product
    @Test
    public void testSearchAnotherProduct() {
        Product p = ProductService.searchProduct("bread");
        assertEquals("bread", p.getName());
        assertEquals(50, p.getPrice());
    }

    // 8. Returned object should not be null
    @Test
    public void testSearchNotNull() {
        Product p = ProductService.searchProduct("cake");
        assertNotNull(p);
    }

    // 9. Product not found
    @Test(expected = IllegalArgumentException.class)
    public void testProductNotFound() {
        ProductService.searchProduct("pizza");
    }

    // 10. Null input
    @Test(expected = IllegalArgumentException.class)
    public void testNullSearch() {
        ProductService.searchProduct(null);
    }

    // 11. Empty string input
    @Test(expected = IllegalArgumentException.class)
    public void testEmptySearch() {
        ProductService.searchProduct("");
    }

    // 12. Blank spaces input
    @Test(expected = IllegalArgumentException.class)
    public void testBlankSearch() {
        ProductService.searchProduct("   ");
    }

    // 13. Validate all product names are lowercase
    @Test
    public void testAllNamesLowercase() {
        List<Product> list = ProductService.displayProducts();
        for (Product p : list) {
            assertEquals(p.getName(), p.getName().toLowerCase());
        }
    }

    // 14. Validate all prices are positive
    @Test
    public void testAllPricesPositive() {
        List<Product> list = ProductService.displayProducts();
        for (Product p : list) {
            assertTrue(p.getPrice() > 0);
        }
    }
}
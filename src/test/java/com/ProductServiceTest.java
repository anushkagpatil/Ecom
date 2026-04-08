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

    @Test
    public void testDisplayProducts() {
        List<Product> list = ProductService.displayProducts();
        assertEquals(10, list.size());
    }

    @Test
    public void testSearchProductFound() {
        Product p = ProductService.searchProduct("cake");
        assertEquals("cake", p.getName());
        assertEquals(350, p.getPrice());
    }

    @Test
    public void testSearchCaseInsensitive() {
        Product p = ProductService.searchProduct("DONUT");
        assertEquals("donut", p.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProductNotFound() {
        ProductService.searchProduct("pizza");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullSearch() {
        ProductService.searchProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptySearch() {
        ProductService.searchProduct("");
    }
}
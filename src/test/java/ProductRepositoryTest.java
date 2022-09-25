import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product book1 = new Book(1, "Book_1", "Author 1", 100);
    Product book2 = new Book(2, "Book_2", "Author 2", 200);
    Product smartphone1 = new Smartphone(3, "M1", "Xiaomi", 1000);

    @Test
    public void saveProduct() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(smartphone1);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteProduct() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.removeById(2);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}

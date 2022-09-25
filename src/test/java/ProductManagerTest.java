import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Product book1 = new Book(1, "Book_1", "Author 1", 100);
    Product book2 = new Book(2, "Book_2", "Author 2", 200);
    Product smartphone1 = new Smartphone(3, "M1", "Xiaomi", 1000);
    ProductRepository repo = new ProductRepository();

    @Test
    public void addProduct () {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);

        ProductManager manager = new ProductManager(repo);

        Product smartphone2 = new Smartphone(2, "M2", "Samsung", 2000);
        manager.add(smartphone2);

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneProductByName () {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);

        ProductManager manager = new ProductManager(repo);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Book_2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTwoProducsByName () {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);

        ProductManager manager = new ProductManager(repo);

        Product[] expected = {book1,smartphone1};
        Product[] actual = manager.searchBy("1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNullProducsByName () {

        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);

        ProductManager manager = new ProductManager(repo);

        Product[] expected = {};
        Product[] actual = manager.searchBy("3");

        Assertions.assertArrayEquals(expected, actual);
    }

}

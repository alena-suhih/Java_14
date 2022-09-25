public class Main {

    public static void main(String[] args) {
        Product book1 = new Book(1, "Book_1", "Author 1", 100);
        Product book2 = new Book(2, "Book_2", "Author 2", 200);
        Product book3 = new Book(3, "Book_3", "Author 3", 300);
        Product smartphone1 = new Smartphone(1, "M1", "Xiaomi", 1000);

        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);

        ProductManager manager = new ProductManager(repo);

        Product smartphone2 = new Smartphone(2, "M2", "Samsung", 2000);
        manager.add(smartphone2);

        Product[] searchResult = manager.searchBy("3");

        System.out.print(searchResult);
    }
}

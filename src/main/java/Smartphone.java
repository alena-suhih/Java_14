public class Smartphone extends Product {
    private String maker;

    public Smartphone(int id, String name,String maker, int price) {
        super(id, name, price);
        this.maker = maker;
    }
}

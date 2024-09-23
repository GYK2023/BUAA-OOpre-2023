public abstract class Product {
    private int id;
    private long price;
    private String name;

    public Product(int id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getProName() {
        return name;
    }

    public long getProPrice() {
        return price;
    }

    public int getProId() {
        return id;
    }
}

public class Bottle implements Commodity {
    private int id;
    private String name;
    private int capacity;
    private long price;
    private String type;

    public Bottle(int id, String name, int capacity, long price, String type) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
        this.type = type;
    }

    public void clearBottle() {
        capacity = 0;
    }
    //测试基本函数

    public String getBottleName() {
        return this.name;
    }

    public int getBottleId() {
        return id;
    }

    public int getBottleCapacity() {
        return capacity;
    }

    public int getBottleGain(int hitNow) {
        return capacity;
    }

    public long getPrice() {
        return this.price;
    }
}

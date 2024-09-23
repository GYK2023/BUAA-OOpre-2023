public class Bottle extends Product implements Commodity {
    //private int id;
    //private String name;
    private int capacity;
    //private long price;
    private String type;
    private boolean isEmpty;

    public Bottle(int id, String name, int capacity, long price, String type) {
        super(id,name,price);
        //this.id = id;
        //this.name = name;
        this.capacity = capacity;
        //this.price = price;
        this.type = type;
        isEmpty = false;
    }

    public void clearBottle() {
        isEmpty = true;
        //capacity = 0;
    }

    public boolean checkEmpty() {
        return isEmpty;
    }
    //测试基本函数

    /*public String getBottleName() {
        return this.name;
    }*/

    /*public int getBottleId() {
        return id;
    }*/

    public int getBottleCapacity() {
        return capacity;
    }

    public int getBottleGain(int hitNow) {
        return capacity;
    }

    public long getPrice() {
        return super.getProPrice();
    }

    public long getMoney() {
        return 0;
    }
}
